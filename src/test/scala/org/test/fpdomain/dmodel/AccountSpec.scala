package org.test.fpdomain.dmodel

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.test.fpdomain.gen.AccountGen

import org.fpdomain.service.AccountServiceS
import cats.data._
import org.fpdomain.repository.AccountRepositoryInMemory
import scala.util.Success
import scala.util.Failure
import org.test.fpdomain.util.UnitSpec

class AccountSpec extends UnitSpec with GeneratorDrivenPropertyChecks {

  implicit val classImplicit = PropertyCheckConfiguration(minSuccessful = 100)

  "Generators" should "generate some Accounts" in {
    forAll(AccountGen.genAccount) { acc ⇒
      acc.no.length() should be(10)
      acc.balance.amount.signum should (be(1) or be(0))
    }
  }

  "Account service" should "open accounts" in {
    forAll(AccountGen.genAccount) { acc ⇒
      AccountServiceS.open(acc.no, acc.name, None).run(AccountRepositoryInMemory) match {
        case Success(acc) ⇒
        case Failure(f)   ⇒ fail(f.getMessage)
      }
    }
  }
}
