package de.knsit.otrsBen.config

import com.jdiazcano.cfg4k.providers.ConfigProvider
import com.jdiazcano.cfg4k.providers.ProxyConfigProvider
import com.jdiazcano.cfg4k.providers.bind
import com.jdiazcano.cfg4k.sources.FileConfigSource
import com.jdiazcano.cfg4k.yaml.YamlConfigLoader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File
import kotlin.test.*

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
class ConfigLoadingTest {

    private lateinit var provider: ConfigProvider

    @BeforeEach
    fun `load config file`() {
        val loader = YamlConfigLoader(FileConfigSource(File(ConfigLoadingTest::class.java.getResource("/demo-config.yaml").path)))
        provider = ProxyConfigProvider(loader)
    }

    @ParameterizedTest
    @ValueSource(strings = ["database.ben", "database.otrs"])
    fun `load database config`(configKey: String) {
        val dbConfig = provider.bind<DbConfig>("database.ben")

        assertNotNull(dbConfig.jdbcUri)
        assertNotSame("", dbConfig.jdbcUri)

        assertNotNull(dbConfig.username)
        assertNotSame("", dbConfig.username)

        assertNotNull(dbConfig.password)
        assertNotSame("", dbConfig.password)
    }

    @Test
    fun `load LDAP config`() {
        val ldapConfig = provider.bind<LdapConfig>("ldap")

        assertNotNull(ldapConfig.baseDn)
        assertNotSame("", ldapConfig.baseDn)

        assertNotNull(ldapConfig.bindDn)
        assertNotSame("", ldapConfig.bindDn)

        assertNotNull(ldapConfig.bindPw)
        assertNotSame("", ldapConfig.bindPw)

        assertNotNull(ldapConfig.ldapUri)
        assertNotSame("", ldapConfig.ldapUri)

        assertNotNull(ldapConfig.userSearchFilter)
        assertNotSame("", ldapConfig.userSearchFilter)
    }

    @Test
    fun `load SMTP config`() {
        val smtpConfig = provider.bind<SmtpConfig>("smtp")

        assertNotNull(smtpConfig.senderAddress)
        assertNotSame("", smtpConfig.senderAddress)

        assertNotNull(smtpConfig.friendlySenderName)
        assertNotSame("", smtpConfig.friendlySenderName)

        assertNotNull(smtpConfig.smtpHost)
        assertNotSame("", smtpConfig.smtpHost)

        assertNotNull(smtpConfig.username)
        assertNotSame("", smtpConfig.username)

        assertNotNull(smtpConfig.password)
        assertNotSame("", smtpConfig.password)

        assertEquals(25, smtpConfig.smtpPort)

        assertFalse(smtpConfig.useSSL)
        assertTrue(smtpConfig.useCredentials)
    }
}