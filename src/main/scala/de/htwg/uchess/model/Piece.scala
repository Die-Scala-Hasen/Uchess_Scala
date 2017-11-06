package de.htwg.uchess.model

import de.htwg.uchess.model.impl.{Field, GameField}


trait Piece{
  def possibleMove(gameField:GameField): List[Field]
  override def toString: String
}
