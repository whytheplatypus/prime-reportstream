## Background
Our current onboarding technique has us sending data manually to the receiver while we work through the 
steps to set up a client. While it is good for us to be able to manually upload data, and verify the connection
works at that point, we can run into issues when attempting to send data from Azure.

We saw this happen recently with Texas where we were able to send data manually but our application was 
unable to due to security restrictions in our SSH library not connecting to systems only offering `sha1`
key exchange.

## Goals
Therefore, the goal should be to have a way to manually invoke the sending of reports with fake data to a
receiver and verify the transport specified in settings works.

## Proposal
I am proposing we create a function that will invoke the fake data generator to create a report of pure 
fake data, constrained to a single receiver, which is then routed to a test receiver.

I envision the request looking something similar to

```shell
curl -H "x-functions-key:<SECRET KEY>" "https://prime.cdc.gov/api/sendtestdata?receiver=tx-doh&numRows=50"
```

When invoked, ReportStream will create a report of fake data for the number of rows specified (up to some logical constraint)
and will set the `processing_mode_code` to `D` and then route the data.  It should also match the 
`target-states` collection to be the `stateCode` for the organization.

This means we will need to make sure that all organizations have more than one receiver specified, and that 
production data has `processing_mode_code` set to `P` explicitly.

Invoking the function should return the same report that submitting data does.

We should also limit the number of times this can be invoked.

I know that this could be done manually by a dev generating a fake file locally 
and then submitting to production, but I want to accomplish a few things:
1. Simplify the process of doing this
2. Provide some assurances that some fields like `processing_mode_code` is forced to `D` and there's no chance of inadvertently sending junk data
3. Ensure that we don't leak any PHI/PII by sending data to an organization that shouldn't get any records they shouldn't

## Final Thoughts
The goal of this proposal is to make it easy to verify the sending of test data to receivers once the settings for them has
been put into production. It not only requires a function, but updates our process to make sure that we
set up two receivers in each organization, one for development data and one for production data.
