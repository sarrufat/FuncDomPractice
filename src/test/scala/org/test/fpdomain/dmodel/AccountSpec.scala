package org.test.fpdomain.dmodel

import com.packt.UnitSpec
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.test.fpdomain.gen.AccountGen
import org.fpdomain.dmodel.Account

class AccountSpec extends UnitSpec with GeneratorDrivenPropertyChecks {
  implicit val classImplicit = PropertyCheckConfiguration(minSuccessful = 100)

  "Generators" should "generate some Accounts" in {
    forAll(AccountGen.genAccount) { acc ⇒
      acc.no.length() should be(10)
      acc.balance.amount.signum should (be(1) or be(0))
    }
  }
}
