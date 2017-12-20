package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class TowerTest extends WordSpec with Matchers {
  "A Tower" should {
    "return a valid moveSet" when {
      "it includes all Points forward, backward, right and left of the Gamefield" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)

        gameFieldBuilder += currentPoint -> Tower('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 14

        //forward
        moveSet should contain(Point(3, 0))
        moveSet should contain(Point(3, 1))
        moveSet should contain(Point(3, 2))

        //backward
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(0, 3))
        moveSet should contain(Point(1, 3))
        moveSet should contain(Point(2, 3))

        //right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 3))
        moveSet should contain(Point(6, 3))
        moveSet should contain(Point(7, 3))

      }

      "it includes all Points backward, right and left, but forward only two Points if the second includes an enemy figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val enemyPoint = Point(3, 1)

        gameFieldBuilder += currentPoint -> Tower('w')
        gameFieldBuilder += enemyPoint -> Tower('b')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 13


        //forward
        moveSet should contain(Point(3, 1))
        moveSet should contain(Point(3, 2))

        //backward
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(0, 3))
        moveSet should contain(Point(1, 3))
        moveSet should contain(Point(2, 3))

        //right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 3))
        moveSet should contain(Point(6, 3))
        moveSet should contain(Point(7, 3))

      }

      "it includes all Points backward, right and left, but forward only one Point if the second includes an own figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val ownPoint = Point(3, 1)

        gameFieldBuilder += currentPoint -> Tower('w')
        gameFieldBuilder += ownPoint -> Tower('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 12

        //forward
        moveSet should contain(Point(3, 2))

        //backward
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(0, 3))
        moveSet should contain(Point(1, 3))
        moveSet should contain(Point(2, 3))

        //right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 3))
        moveSet should contain(Point(6, 3))
        moveSet should contain(Point(7, 3))
      }
    }
  }

  "A Tower" should {
    "have a specific toString Method" in {
      val whiteTower = Tower('w')
      val blackTower = Tower('b')
      val noSpecificPawn = Tower('x')

      whiteTower.toString shouldBe "♖"
      blackTower.toString shouldBe "♜"
      noSpecificPawn.toString shouldBe "Tx"
    }
  }
}
