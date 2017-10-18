package model.impl

import model.Piece
import util.Point


case class Field(var point: Point, var optionChessPiece: Option[Piece] = None) {
}