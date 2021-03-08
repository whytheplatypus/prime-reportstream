# Background

The current PostgreSQL database server is accessed by a single user account that has a permission set that is too broad.  To address this a combination of admin, user, and service accounts will be created.  Each account will be associated with a permission set that corresponds to that user's _minimum required_ access to perform the operations needed.

# Goals

The goal of the proposal is to move from a single administrative user account to several admin, user, and service accounts each with access to specific resources.  This not only will enhance the security of the database access, but provide a more robust means for auditing transactions and by which entity they were performed.

# Proposal

|Account Type|Account Name|Access Type|Database Access|
|---|---|---|---|
|Server Admin|prime|Read/Write|All|
|Developer Admin|<dev_name>_admin|Read/Write|prime_data_hub|
|Developer|<dev_name>|Read|prime_data_hub|
|Service|cicd|Read/Write|prime_data_hub|
|Service|prime_reportstream|Read/Write|prime_data_hub|
