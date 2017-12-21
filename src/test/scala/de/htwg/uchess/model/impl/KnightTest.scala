package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class KnightTest extends WordSpec with Matchers {
 "A Knight" should {
   "return a valid moveSet" when {
     "it includes all reachable Points, if the way is free" in {
       val gameFieldBuilder = Map.newBuilder[Point, Piece]
       val currentPoint = Point(5, 2)

       gameFieldBuilder += currentPoint -> Knight('w')

       val gameField = gameFieldBuilder.result()
       val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

       moveSet.size shouldBe 8

       moveSet should contain(Point(4, 0))
       moveSet should contain(Point(6, 0))
       moveSet should contain(Point(7, 1))
       moveSet should contain(Point(7, 3))
       moveSet should contain(Point(6, 4))
       moveSet should contain(Point(4, 4))
       moveSet should contain(Point(3, 3))
       moveSet should contain(Point(3, 1))

     }

     "it includes all reachable Points, if the way is blocked" in {
       val gameFieldBuilder = Map.newBuilder[Point, Piece]
       val currentPoint = Point(5, 2)

       val blockerPointUp = Point(5, 1)
       val blockerPointDown = Point(5, 3)
       val blockerPointLeft = Point(4, 2)
       val blockerPointRight = Point(6, 2)

       gameFieldBuilder += currentPoint -> Knight('w')
       gameFieldBuilder += blockerPointUp -> Pawn('w')
       gameFieldBuilder += blockerPointDown -> Pawn('w')
       gameFieldBuilder += blockerPointLeft -> Pawn('b')
       gameFieldBuilder += blockerPointRight -> Pawn('b')

       val gameField = gameFieldBuilder.result()
       val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

       moveSet.size shouldBe 8

       moveSet should contain(Point(4, 0))
       moveSet should contain(Point(6, 0))
       moveSet should contain(Point(7, 1))
       moveSet should contain(Point(7, 3))
       moveSet should contain(Point(6, 4))
       moveSet should contain(Point(4, 4))
       moveSet should contain(Point(3, 3))
       moveSet should contain(Point(3, 1))
     }

     "it includes all reachable Points, if the way is target is blocked by an enemy figure" in {
       val gameFieldBuilder = Map.newBuilder[Point, Piece]
       val currentPoint = Point(5, 2)
       val targetPoint = Point(4,0)

       gameFieldBuilder += currentPoint -> Knight('w')
       gameFieldBuilder += targetPoint -> Pawn('b')

       val gameField = gameFieldBuilder.result()
       val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

       moveSet.size shouldBe 8

       moveSet should contain(Point(4, 0))
       moveSet should contain(Point(6, 0))
       moveSet should contain(Point(7, 1))
       moveSet should contain(Point(7, 3))
       moveSet should contain(Point(6, 4))
       moveSet should contain(Point(4, 4))
       moveSet should contain(Point(3, 3))
       moveSet should contain(Point(3, 1))
     }

     "it includes not all reachable Points, if the way is target is blocked by an own figure" in {
       val gameFieldBuilder = Map.newBuilder[Point, Piece]
       val currentPoint = Point(5, 2)
       val targetPoint = Point(4,0)

       gameFieldBuilder += currentPoint -> Knight('w')
       gameFieldBuilder += targetPoint -> Pawn('w')

       val gameField = gameFieldBuilder.result()
       val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

       moveSet.size shouldBe 7

       moveSet should contain(Point(6, 0))
       moveSet should contain(Point(7, 1))
       moveSet should contain(Point(7, 3))
       moveSet should contain(Point(6, 4))
       moveSet should contain(Point(4, 4))
       moveSet should contain(Point(3, 3))
       moveSet should contain(Point(3, 1))
     }

     "it includes only three Points, if the Knight is at the border of the Gamefield" in {
       val gameFieldBuilder = Map.newBuilder[Point, Piece]
       val currentPoint = Point(0, 6)

       gameFieldBuilder += currentPoint -> Knight('w')

       val gameField = gameFieldBuilder.result()
       val moveSet = gameField(currentPoint).possibleMove(gameField, currentPoint)

       moveSet.size shouldBe 3

       moveSet should contain(Point(1, 4))
       moveSet should contain(Point(2, 5))
       moveSet should contain(Point(2, 7))

     }
   }
 }

  "A Knight" should {
    "have a specific toString Method" in {
      val whiteKnight = Knight('w')
      val blackKnight = Knight('b')
      val noSpecificKnight = Knight('x')

      whiteKnight.toString shouldBe "♘"
      blackKnight.toString shouldBe "♞"
      noSpecificKnight.toString shouldBe "Knx"
    }
  }
}
