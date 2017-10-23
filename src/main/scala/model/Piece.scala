package model

import model.impl.{Field, GameField}


trait Piece{
  def possibleMove(gameField:GameField): List[Field]
  override def toString: String
}
