package de.knsit.otrsBen

import de.knsit.otrsBen.config.ConfigFactory
import de.knsit.otrsBen.config.toScheduleExpression
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.annotation.Resource
import javax.ejb.Singleton
import javax.ejb.Startup
import javax.ejb.Timeout
import javax.ejb.TimerService

/**
 * @author Peter Kurfer
 * Created on 3/31/18.
 */
@Startup
@Singleton
open class NotifySchedulerBean {

    @Resource
    private var timerService: TimerService? = null

    @PostConstruct
    fun setup() {
        timerService?.createCalendarTimer(ConfigFactory.schedulerConfig.toScheduleExpression())
    }

    @Timeout
    fun proceed() {
        println("Proceeding...")
    }

    @PreDestroy
    fun cleanup() {
        println("Running cleanup...")
    }
}