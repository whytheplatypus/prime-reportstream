package gov.cdc.prime.router.secrets

import com.azure.core.credential.TokenCredential
import com.azure.identity.DefaultAzureCredentialBuilder
import com.azure.security.keyvault.secrets.SecretAsyncClient
import com.azure.security.keyvault.secrets.SecretClientBuilder

internal object AzureSecretService : SecretService() {
    private val KEY_VAULT_NAME: String by lazy { System.getenv("SECRET_KEY_VAULT_NAME") ?: "" }
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

    override fun fetchSecretFromStore(secretName: String): String? {
        val azureSafeSecretName = secretName.toLowerCase().replace("_", "-")
        return secretClient?.getSecret(azureSafeSecretName)?.block()?.let {
            return it.value
        }
    }
}