package de.htwg.uchess.util

import org.scalatest.WordSpec
import org.scalatest.Matchers

class PointTest extends WordSpec with Matchers {

  "A Point" should {
    val pointToTest = Point(1,6)
    "have an specific toString Method" in{
      pointToTest.toString() shouldBe "Point(1,6)"
    }
    "equals to the same Point" in{
      val equalsPoint = Point(1,6)
      pointToTest.equals(equalsPoint) shouldBe true
    }
    "not equals to a different Point" in{
      val notEqualsPoint = Point(0,6)
      pointToTest.equals(notEqualsPoint) shouldBe false
    }
    "not equals to a different Object" in{
      val notEqualsObject ="Point(1,6)"
      pointToTest.equals(notEqualsObject) shouldBe false
    }
  }

}
