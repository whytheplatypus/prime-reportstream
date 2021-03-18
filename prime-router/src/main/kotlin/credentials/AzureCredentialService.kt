package gov.cdc.prime.router.credentials

import com.azure.core.credential.TokenCredential
import com.azure.identity.DefaultAzureCredentialBuilder
import com.azure.security.keyvault.secrets.SecretAsyncClient
import com.azure.security.keyvault.secrets.SecretClientBuilder

internal object AzureCredentialService : CredentialService() {

    private val KEY_VAULT_NAME: String by lazy { System.getenv("CREDENTIAL_KEY_VAULT_NAME") ?: "" }
    private val secretClient by lazy { initSecretClient() }

    internal fun initSecretClient(
        secretClientBuilder: SecretClientBuilder = SecretClientBuilder(),
        credential: TokenCredential = DefaultAzureCredentialBuilder().build()
    ): SecretAsyncClient? {
        return secretClientBuilder
            .vaultUrl("https://$KEY_VAULT_NAME.vault.azure.net")
            .credential(credential)
            .buildAsyncClient()
    }

    override fun fetchCredential(connectionId: String): Credential? {
        return secretClient?.getSecret("$connectionId")?.block()?.let {
            return Credential.fromJSON(it.value)
        }
    }

    override fun saveCredential(connectionId: String, credential: Credential) {
        secretClient?.setSecret("$connectionId", credential.toJSON())?.block()
            ?: throw Exception("Failed to save credentials for: $connectionId")
    }
}