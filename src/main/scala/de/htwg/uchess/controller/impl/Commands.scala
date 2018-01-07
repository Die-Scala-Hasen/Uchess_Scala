package de.htwg.uchess.controller.impl

import de.htwg.uchess.util.Point

trait Command {}

case object QuitCmd extends Command
case object RestartCmd extends Command
case class MoveCmd(src: Point, dst: Point) extends Command
