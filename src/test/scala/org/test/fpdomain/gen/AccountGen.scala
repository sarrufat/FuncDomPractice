package org.test.fpdomain.gen

import org.scalacheck.Arbitrary
import org.fpdomain.dmodel.Account
import org.scalacheck.Gen
import org.fpdomain.dmodel.Balance

object Generator {
  val strNumber = (n: Int) ⇒ Gen.listOfN(n, Gen.numChar).map(_.mkString)
  val strString = (n: Int) ⇒ Gen.listOfN(n, Gen.alphaNumChar).map(_.mkString)
}

object AccountGen {
  private val maxAmount = 10000000
  import Generator._
  def genBalance = for {
    bi ← Arbitrary.arbitrary[Int] suchThat { bi ⇒ bi >= 0 && bi < maxAmount }
  } yield Balance(BigDecimal(bi))

  val genAccount = for {
    no ← strNumber(10)
    name ← strString(20)
    bamount ← genBalance
  } yield Account(no = no, name = name, balance = bamount)
}
