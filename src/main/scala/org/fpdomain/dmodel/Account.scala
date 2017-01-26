package org.fpdomain.dmodel

import java.util.{ Date ⇒ JDate, Calendar ⇒ JCalendar }

object common {
  type Amount = BigDecimal

  def today = {
    val cal = JCalendar.getInstance
    cal.setTime(JCalendar.getInstance.getTime)
    cal.set(JCalendar.HOUR_OF_DAY, 0)
    cal.set(JCalendar.MINUTE, 0)
    cal.set(JCalendar.SECOND, 0)
    cal.set(JCalendar.MILLISECOND, 0)
    cal.getTime
  }
}

import common._

case class Balance(amount: Amount = 0)

case class Account(no: String, name: String, dateOfOpening: JDate = today, dateOfClosing: Option[JDate] = None,
                   balance: Balance = Balance(0))
