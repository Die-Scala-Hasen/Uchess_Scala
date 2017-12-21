package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class KingTest extends WordSpec with Matchers {
  "A King" should {
    "return a valid moveSet" when {
      "it includes all reachable Points, if the way is free" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)

        gameFieldBuilder += currentPoint -> King('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 8

        moveSet should contain(Point(2, 2))
        moveSet should contain(Point(3, 2))
        moveSet should contain(Point(4, 2))
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(4, 4))

      }

      "it includes all reachable Points, if teh target is blocked by an enemy figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val targetPoint = Point(4, 2)

        gameFieldBuilder += currentPoint -> King('w')
        gameFieldBuilder += targetPoint -> Pawn('b')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 8

        moveSet should contain(Point(2, 2))
        moveSet should contain(Point(3, 2))
        moveSet should contain(Point(4, 2))
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(4, 4))

      }

      "it includes not all reachable Points, if teh target is blocked by an own figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 3)
        val targetPoint = Point(4, 2)

        gameFieldBuilder += currentPoint -> King('w')
        gameFieldBuilder += targetPoint -> Pawn('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 7

        moveSet should contain(Point(2, 2))
        moveSet should contain(Point(3, 2))
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(4, 4))

      }

      "it includes only three Points, if the King is at the border of the Gamefield" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(0, 7)

        gameFieldBuilder += currentPoint -> King('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 3

        moveSet should contain(Point(0, 6))
        moveSet should contain(Point(1, 6))
        moveSet should contain(Point(1, 7))
      }
    }
  }

  "A King" should {
    "have a specific toString Method" in {
      val whiteKing = King('w')
      val blackKing = King('b')
      val noSpecificKing = King('x')

      whiteKing.toString shouldBe "♔"
      blackKing.toString shouldBe "♚"
      noSpecificKing.toString shouldBe "Kx"
    }
  }
}
