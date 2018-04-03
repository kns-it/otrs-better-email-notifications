package de.knsit.otrsBen.config

import javax.ejb.ScheduleExpression

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
interface SchedulerConfig {
    var hour: String
    var minute: String
    var second: String
}

fun SchedulerConfig.toScheduleExpression(): ScheduleExpression = ScheduleExpression().apply {
    this.hour(this@toScheduleExpression.hour)
    this.minute(this@toScheduleExpression.minute)
    this.second(this@toScheduleExpression.second)
}