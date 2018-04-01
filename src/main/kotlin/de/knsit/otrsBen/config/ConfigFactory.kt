package de.knsit.otrsBen.config

import com.jdiazcano.cfg4k.providers.ConfigProvider
import com.jdiazcano.cfg4k.providers.ProxyConfigProvider
import com.jdiazcano.cfg4k.providers.bind
import com.jdiazcano.cfg4k.sources.FileConfigSource
import com.jdiazcano.cfg4k.yaml.YamlConfigLoader
import java.io.File

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
object ConfigFactory {

    private lateinit var provider: ConfigProvider

    fun load(configFilePath: File) {
        val loader = YamlConfigLoader(FileConfigSource(configFilePath))
        provider = ProxyConfigProvider(loader)
    }

    val otrsDbConfig: DbConfig by lazy {
        provider.bind<DbConfig>("database.otrs")
    }

    val benDbConfig: DbConfig by lazy {
        provider.bind<DbConfig>("database.ben")
    }

    val ldapConfig: LdapConfig by lazy {
        provider.bind<LdapConfig>("ldap")
    }

    val smtpConfig: SmtpConfig by lazy {
        provider.bind<SmtpConfig>("smtp")
    }

    val templateConfig: TemplateConfig by lazy {
        provider.bind<TemplateConfig>("template")
    }
}