package io.armory.plugin.example.spring

import com.netflix.spinnaker.clouddriver.aws.security.AmazonAccountsSynchronizer
import com.netflix.spinnaker.clouddriver.security.AccountCredentialsRepository
import com.netflix.spinnaker.clouddriver.aws.security.DefaultAccountConfigurationProperties
import com.netflix.spinnaker.clouddriver.aws.security.DefaultAmazonAccountsSynchronizer
import com.netflix.spinnaker.clouddriver.aws.security.NetflixAmazonCredentials
import com.netflix.spinnaker.clouddriver.aws.security.config.CredentialsConfig
import com.netflix.spinnaker.clouddriver.aws.security.config.CredentialsLoader

class OverrideAmazonAccountsSynchronizer : AmazonAccountsSynchronizer {
    val delegate = DefaultAmazonAccountsSynchronizer()

    fun synchronize(
            credentialsLoader: CredentialsLoader<out NetflixAmazonCredentials>?,
            credentialsConfig: CredentialsConfig?,
            accountCredentialsRepository: AccountCredentialsRepository?,
            defaultAccountConfigurationProperties: DefaultAccountConfigurationProperties?,
            catsModule: com.netflix.spinnaker.cats.module.CatsModule?): MutableList<out NetflixAmazonCredentials> {
        val account = CredentialsConfig.Account()
        account.name = "fakeAccount2"
        credentialsConfig?.accounts?.add(account)
        return delegate.synchronize(credentialsLoader, credentialsConfig, accountCredentialsRepository, defaultAccountConfigurationProperties, catsModule)
    }

}