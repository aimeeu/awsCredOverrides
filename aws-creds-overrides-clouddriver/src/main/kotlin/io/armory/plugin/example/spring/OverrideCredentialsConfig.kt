package io.armory.plugin.example.spring

import com.netflix.spinnaker.clouddriver.aws.security.config.CredentialsConfig

class OverrideCredentialsConfig : CredentialsConfig() {

    override fun getAccounts(): MutableList<Account> {
        val account = Account()
        account.name ="fakeAwsAccount"
        return mutableListOf(account)
    }
}
