package de.htwg.uchess.model.impl

import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class GameFieldTest extends WordSpec with Matchers {
  "A Gamefield should be scalable and contains specific figures " when {
    "it is very small" in {
      val gameFieldToTest = GameField(1)
      gameFieldToTest.size shouldBe 1
      gameFieldToTest.gameField.get(Point(0, 0)) shouldBe Some(King('b'))
    }
    "it is small" in {
      val gameFieldToTest = GameField(3)
      gameFieldToTest.size shouldBe 3
      gameFieldToTest.gameField.get(Point(1, 0)) shouldBe Some(King('b'))
      gameFieldToTest.gameField.get(Point(1, 2)) shouldBe Some(King('w'))
    }
    "it is normal" in {
      val gameFieldToTest = GameField(8)
      gameFieldToTest.size shouldBe 8

      gameFieldToTest.gameField.get(Point(0, 0)) shouldBe Some(Tower('b'))
      gameFieldToTest.gameField.get(Point(7, 0)) shouldBe Some(Tower('b'))
      gameFieldToTest.gameField.get(Point(0, 7)) shouldBe Some(Tower('w'))
      gameFieldToTest.gameField.get(Point(7, 7)) shouldBe Some(Tower('w'))

      gameFieldToTest.gameField.get(Point(1, 0)) shouldBe Some(Knight('b'))
      gameFieldToTest.gameField.get(Point(6, 0)) shouldBe Some(Knight('b'))
      gameFieldToTest.gameField.get(Point(1, 7)) shouldBe Some(Knight('w'))
      gameFieldToTest.gameField.get(Point(6, 7)) shouldBe Some(Knight('w'))

      gameFieldToTest.gameField.get(Point(2, 0)) shouldBe Some(Bishop('b'))
      gameFieldToTest.gameField.get(Point(5, 0)) shouldBe Some(Bishop('b'))
      gameFieldToTest.gameField.get(Point(2, 7)) shouldBe Some(Bishop('w'))
      gameFieldToTest.gameField.get(Point(5, 7)) shouldBe Some(Bishop('w'))

      gameFieldToTest.gameField.get(Point(3, 0)) shouldBe Some(Queen('b'))
      gameFieldToTest.gameField.get(Point(3, 7)) shouldBe Some(Queen('w'))

      gameFieldToTest.gameField.get(Point(4, 0)) shouldBe Some(King('b'))
      gameFieldToTest.gameField.get(Point(4, 7)) shouldBe Some(King('w'))

      gameFieldToTest.gameField.get(Point(0, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(1, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(2, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(3, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(4, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(5, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(6, 1)) shouldBe Some(Pawn('b'))
      gameFieldToTest.gameField.get(Point(7, 1)) shouldBe Some(Pawn('b'))

      gameFieldToTest.gameField.get(Point(0, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(1, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(2, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(3, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(4, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(5, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(6, 6)) shouldBe Some(Pawn('w'))
      gameFieldToTest.gameField.get(Point(7, 6)) shouldBe Some(Pawn('w'))


    }
    "it is big" in {
      val gameFieldToTest = GameField(16)
      gameFieldToTest.size shouldBe 16
      gameFieldToTest.gameField.get(Point(8, 0)) shouldBe Some(King('b'))
      gameFieldToTest.gameField.get(Point(8, 15)) shouldBe Some(King('w'))
    }
    "it is very big" in {
      val gameFieldToTest = GameField(50)
      gameFieldToTest.size shouldBe 50
      gameFieldToTest.gameField.get(Point(25, 0)) shouldBe Some(King('b'))
      gameFieldToTest.gameField.get(Point(25, 49)) shouldBe Some(King('w'))
    }
  }
  "A Gamefield" should {
    "have a specific toString Method" in {
      val printOfGameField = "\n  | a | b | c | d | e | f | g | h |\n==+---------------------+\n1 |♜|♞|♝|♛|♚|♝|♞|♜|\n2 |♟|♟|♟|♟|♟|♟|♟|♟|\n3 | | | | | | | | |\n4 | | | | | | | | |\n5 | | | | | | | | |\n6 | | | | | | | | |\n7 |♙|♙|♙|♙|♙|♙|♙|♙|\n8 |♖|♘|♗|♕|♔|♗|♘|♖|\n==+---------------------+"

      val gameFieldToTest = GameField(8)
      gameFieldToTest.toString shouldBe printOfGameField
    }
  }
}
