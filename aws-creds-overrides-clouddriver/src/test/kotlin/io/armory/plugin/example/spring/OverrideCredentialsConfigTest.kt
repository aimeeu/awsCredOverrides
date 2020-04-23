package io.armory.plugin.example.spring

import dev.minutest.junit.JUnit5Minutests
import dev.minutest.rootContext
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class OverrideCredentialsConfigTest : JUnit5Minutests {

    fun tests() = rootContext {
        test("execute OverrideCredentialsConfig") {
            expectThat(OverrideCredentialsConfig().accounts[0].name)
                    .isEqualTo("fakeAwsAccount")
        }
    }

}
