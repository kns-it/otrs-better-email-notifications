package de.knsit.otrsBen.config

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.*

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
object ConfigFactoryTest {

    @JvmStatic
    @BeforeAll
    fun setupFactory() {
        ConfigFactory.load(File(ConfigLoadingTest::class.java.getResource("/demo-config.yaml").path))
    }

    @Test
    fun `test get OTRS DB config`() {
        val dbConfig = ConfigFactory.otrsDbConfig

        assertNotNull(dbConfig.jdbcUri)
        assertNotSame("", dbConfig.jdbcUri)

        assertNotNull(dbConfig.username)
        assertNotSame("", dbConfig.username)

        assertNotNull(dbConfig.password)
        assertNotSame("", dbConfig.password)
    }

    @Test
    fun `test OTRS DB laziness`() {
        assertSame(ConfigFactory.otrsDbConfig, ConfigFactory.otrsDbConfig)
    }

    @Test
    fun `test get BEN DB config`() {
        val dbConfig = ConfigFactory.benDbConfig

        assertNotNull(dbConfig.jdbcUri)
        assertNotSame("", dbConfig.jdbcUri)

        assertNotNull(dbConfig.username)
        assertNotSame("", dbConfig.username)

        assertNotNull(dbConfig.password)
        assertNotSame("", dbConfig.password)
    }

    @Test
    fun `test BEN DB config laziness`() {
        assertSame(ConfigFactory.benDbConfig, ConfigFactory.benDbConfig)
    }

    @Test
    fun `test get LDAP config`() {
        val ldapConfig = ConfigFactory.ldapConfig

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
    fun `test LDAP config laziness`() {
        assertSame(ConfigFactory.ldapConfig, ConfigFactory.ldapConfig)
    }

    @Test
    fun `test get SMTP config`() {
        val smtpConfig = ConfigFactory.smtpConfig

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

    @Test
    fun `test SMTP config laziness`() {
        assertSame(ConfigFactory.smtpConfig, ConfigFactory.smtpConfig)
    }

    @Test
    fun `test get template config`() {
        val templateConfig = ConfigFactory.templateConfig

        assertNotNull(templateConfig.templateFolderPath)
        assertNotSame("", templateConfig.templateFolderPath)

        assertNotNull(templateConfig.templateName)
        assertNotSame("", templateConfig.templateName)
    }

    @Test
    fun `test template config laziness`() {
        assertSame(ConfigFactory.templateConfig, ConfigFactory.templateConfig)
    }
}