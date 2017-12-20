package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class BishopTest extends WordSpec with Matchers {
  "A Bishop" should {
    "return a valid moveSet" when {
      "it includes all Points diagonally to the top right, to the top left and diagonally to the bottom right, to the bottom left of the Gamefield" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)

        gameFieldBuilder += currentPoint -> Bishop('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 13

        //top right
        moveSet should contain(Point(4, 2))
        moveSet should contain(Point(5, 1))
        moveSet should contain(Point(6, 0))

        //top left
        moveSet should contain(Point(2, 2))
        moveSet should contain(Point(1, 1))
        moveSet should contain(Point(0, 0))

        //bottom right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 5))
        moveSet should contain(Point(6, 6))
        moveSet should contain(Point(7, 7))

        //bottom left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 5))
        moveSet should contain(Point(0, 6))

      }

      "it includes all Points to the top right, to the bottom right, to the bottom left and only two Points, if the second includes an enemy figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val enemyPoint = Point(1, 1)

        gameFieldBuilder += currentPoint -> Bishop('w')
        gameFieldBuilder += enemyPoint -> Bishop('b')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 12

        //top right
        moveSet should contain(Point(4, 2))
        moveSet should contain(Point(5, 1))
        moveSet should contain(Point(6, 0))

        //top left
        moveSet should contain(Point(2, 2))
        moveSet should contain(Point(1, 1))

        //bottom right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 5))
        moveSet should contain(Point(6, 6))
        moveSet should contain(Point(7, 7))

        //bottom left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 5))
        moveSet should contain(Point(0, 6))
      }

      "it includes all Points to the top right, to the bottom right, to the bottom left and only one Point, if the second includes an own figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val ownPoint = Point(1, 1)

        gameFieldBuilder += currentPoint -> Bishop('w')
        gameFieldBuilder += ownPoint -> Bishop('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 11

        //top right
        moveSet should contain(Point(4, 2))
        moveSet should contain(Point(5, 1))
        moveSet should contain(Point(6, 0))

        //top left
        moveSet should contain(Point(2, 2))

        //bottom right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 5))
        moveSet should contain(Point(6, 6))
        moveSet should contain(Point(7, 7))

        //bottom left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 5))
        moveSet should contain(Point(0, 6))
      }
    }
  }

  "A Bishop" should {
    "have a specific toString Method" in {
      val whiteBishop = Bishop('w')
      val blackBishop = Bishop('b')
      val noSpecificBishop = Bishop('x')

      whiteBishop.toString shouldBe "♗"
      blackBishop.toString shouldBe "♝"
      noSpecificBishop.toString shouldBe "Bx"
    }
  }
}
