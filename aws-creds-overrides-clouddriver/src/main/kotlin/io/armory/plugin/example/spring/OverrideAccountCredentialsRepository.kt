package io.armory.plugin.example.spring

import com.netflix.spinnaker.clouddriver.security.AccountCredentials
import com.netflix.spinnaker.clouddriver.security.AccountCredentialsRepository
import com.netflix.spinnaker.clouddriver.security.MapBackedAccountCredentialsRepository

class OverrideAccountCredentialsRepository(
        val delegate: AccountCredentialsRepository = MapBackedAccountCredentialsRepository()
): AccountCredentialsRepository by delegate {

    override fun getAll(): MutableSet<out AccountCredentials<Any>>? {
        return delegate.getAll()
    }

}
