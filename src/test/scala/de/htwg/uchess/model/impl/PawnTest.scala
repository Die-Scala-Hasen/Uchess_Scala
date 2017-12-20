package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class PawnTest extends WordSpec with Matchers {

  "A Pawn" should {
    "return a valid moveSet" when {
      "it includes two Points froward at Start" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 6)

        gameFieldBuilder += currentPoint -> Pawn('w')
        val gameField = gameFieldBuilder.result()

        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 2

        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(3, 4))


      }
      "it includes one Point froward, if the next straight Point is empty" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 6)

        gameFieldBuilder += currentPoint -> Pawn('w', firstMove = false)

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 1

        moveSet should contain(Point(3, 5))
      }

      "it includes no Point, if the next straight includes a figure" in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 6)
        val nextStraightPoint = Point(3, 5)

        gameFieldBuilder += currentPoint -> Pawn('w')
        gameFieldBuilder += nextStraightPoint -> Pawn('b')

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 0
      }

      "it includes two Points froward, if the straight Point is empty and the right diagonal Point includes an enemy figure  " in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 6)
        val nextStraightPoint = Point(4, 5)

        gameFieldBuilder += currentPoint -> Pawn('w', firstMove = false)
        gameFieldBuilder += nextStraightPoint -> Pawn('b', firstMove = false)

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 2

        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(4, 5))
      }
      "it includes two Points froward, if the straight Point is empty and the left diagonal Point includes an enemy figure  " in {
        val gameFieldBuilder = Map.newBuilder[Point, Piece]
        val currentPoint = Point(3, 6)
        val nextStraightPoint = Point(2, 5)

        gameFieldBuilder += currentPoint -> Pawn('w', firstMove = false)
        gameFieldBuilder += nextStraightPoint -> Pawn('b', firstMove = false)

        val gameField = gameFieldBuilder.result()
        val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

        moveSet.size shouldBe 2

        moveSet should contain(Point(3, 5))
        moveSet should contain(Point(2, 5))
      }
    }
  }

  "A Pawn" should {
    "have a specific toString Method" in {

      val whitePawn = Pawn('w')
      val blackPawn = Pawn('b')
      val noSpecificPawn = Pawn('x')

      whitePawn.toString shouldBe "♙"
      blackPawn.toString shouldBe "♟"
      noSpecificPawn.toString shouldBe "Px"
    }
  }
}
