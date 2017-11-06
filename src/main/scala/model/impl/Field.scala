package model.impl

import model.Piece
import util.Point


case class Field(val point: Point, var optionChessPiece: Option[Piece] = None) {
}