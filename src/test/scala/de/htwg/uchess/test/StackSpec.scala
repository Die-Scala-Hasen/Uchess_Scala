package de.htwg.uchess.test

import org.scalatest.WordSpec
import scala.collection.mutable.Stack

class StackSpec extends WordSpec {

  "A Stack" should {

    "pop values in last-in-first-out order" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    "throw NoSuchElementException if an empty stack is popped" in {
      val emptyStack = new Stack[String]
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
    }
  }
}