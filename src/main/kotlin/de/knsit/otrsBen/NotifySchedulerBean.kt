package de.knsit.otrsBen

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.ejb.Schedule
import javax.ejb.Singleton
import javax.ejb.Startup

/**
 * @author Peter Kurfer
 * Created on 3/31/18.
 */
@Startup
@Singleton
open class NotifySchedulerBean {

    @Schedule(hour = "*", minute = "*", second = "*/5", info = "Checking for outstanding notifications to send")
    fun checkForOutstandingNotifications() {
        println("Checking for notifications to send")
    }

    @PostConstruct
    fun setup() {
        println("Running setup...")
    }

    @PreDestroy
    fun cleanup() {
        println("Running cleanup...")
    }
}