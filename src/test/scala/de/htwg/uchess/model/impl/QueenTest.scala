package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.Matchers
import org.scalatest.WordSpec

class QueenTest extends WordSpec with Matchers {
  "A Queen" should {
    "return a valid moveSet" when {
      "it includes all reachable Points, if the way is free" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 4)

        gameFieldBuilder += currentPoint -> Queen('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 27

        //forward
        moveSet should contain(Point(3, 3))
        moveSet should contain(Point(3, 2))
        moveSet should contain(Point(3, 1))
        moveSet should contain(Point(3, 0))

        //backward
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 4))
        moveSet should contain(Point(0, 4))

        //right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 4))
        moveSet should contain(Point(6, 4))
        moveSet should contain(Point(7, 4))

        //top left
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(1, 2))
        moveSet should contain(Point(0, 1))

        //top right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 2))
        moveSet should contain(Point(6, 1))
        moveSet should contain(Point(7, 0))

        //bottom left
        moveSet should contain(Point(2, 5))
        moveSet should contain(Point(1, 6))
        moveSet should contain(Point(0, 7))

        //bottom right
        moveSet should contain(Point(4, 5))
        moveSet should contain(Point(5, 6))
        moveSet should contain(Point(6, 7))
      }
      "it includes not all reachable Points, if the target is blocked by an enemy figure" in {

        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 4)
        val firstEnemyPoint = Point(3, 2)

        gameFieldBuilder += currentPoint -> Queen('w')
        gameFieldBuilder += firstEnemyPoint -> Pawn('b')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 25

        //forward
        moveSet should contain(Point(3, 3))
        moveSet should contain(Point(3, 2))

        //backward
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 4))
        moveSet should contain(Point(0, 4))

        //right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 4))
        moveSet should contain(Point(6, 4))
        moveSet should contain(Point(7, 4))

        //top left
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(1, 2))
        moveSet should contain(Point(0, 1))

        //top right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 2))
        moveSet should contain(Point(6, 1))
        moveSet should contain(Point(7, 0))

        //bottom left
        moveSet should contain(Point(2, 5))
        moveSet should contain(Point(1, 6))
        moveSet should contain(Point(0, 7))

        //bottom right
        moveSet should contain(Point(4, 5))
        moveSet should contain(Point(5, 6))
        moveSet should contain(Point(6, 7))
      }
      "it includes not all reachable Points, if the target is blocked by an own figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 4)
        val firstEnemyPoint = Point(3, 2)

        gameFieldBuilder += currentPoint -> Queen('w')
        gameFieldBuilder += firstEnemyPoint -> Pawn('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 24

        //forward
        moveSet should contain(Point(3, 3))

        //backward
        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(3, 7))

        //left
        moveSet should contain(Point(2, 4))
        moveSet should contain(Point(1, 4))
        moveSet should contain(Point(0, 4))

        //right
        moveSet should contain(Point(4, 4))
        moveSet should contain(Point(5, 4))
        moveSet should contain(Point(6, 4))
        moveSet should contain(Point(7, 4))

        //top left
        moveSet should contain(Point(2, 3))
        moveSet should contain(Point(1, 2))
        moveSet should contain(Point(0, 1))

        //top right
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 2))
        moveSet should contain(Point(6, 1))
        moveSet should contain(Point(7, 0))

        //bottom left
        moveSet should contain(Point(2, 5))
        moveSet should contain(Point(1, 6))
        moveSet should contain(Point(0, 7))

        //bottom right
        moveSet should contain(Point(4, 5))
        moveSet should contain(Point(5, 6))
        moveSet should contain(Point(6, 7))
      }

      "it includes only twenty-one Points, if the Queen is at the border of the Gamefield" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(1, 6)

        gameFieldBuilder += currentPoint -> Queen('w')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 23

        moveSet should contain(Point(1, 7))
        moveSet should contain(Point(0, 7))
        moveSet should contain(Point(0, 6))
        moveSet should contain(Point(0, 5))
        moveSet should contain(Point(1, 5))
        moveSet should contain(Point(1, 4))
        moveSet should contain(Point(1, 3))
        moveSet should contain(Point(1, 2))
        moveSet should contain(Point(1, 1))
        moveSet should contain(Point(1, 0))
        moveSet should contain(Point(2, 5))
        moveSet should contain(Point(3, 4))
        moveSet should contain(Point(4, 3))
        moveSet should contain(Point(5, 2))
        moveSet should contain(Point(6, 1))
        moveSet should contain(Point(7, 0))
        moveSet should contain(Point(2, 6))
        moveSet should contain(Point(3, 6))
        moveSet should contain(Point(4, 6))
        moveSet should contain(Point(5, 6))
        moveSet should contain(Point(6, 6))
        moveSet should contain(Point(7, 6))
        moveSet should contain(Point(2, 7))
      }
    }
  }

  "A Queen" should {
    "have a specific toString Method" in {
      val whiteQueen = Queen('w')
      val blackQueen = Queen('b')
      val noSpecificQueen = Queen('x')

      whiteQueen.toString shouldBe "♕"
      blackQueen.toString shouldBe "♛"
      noSpecificQueen.toString shouldBe "Qx"
    }
  }
}
