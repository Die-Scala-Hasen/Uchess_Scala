//package de.htwg.uchess.view
//
//import java.awt.event.{ActionEvent, ActionListener}
//import java.awt.{Color, Dimension, GridLayout}
//import javax.swing.{ImageIcon, JFrame, JOptionPane}
//
//import de.htwg.uchess.util.{PieceButton, Point}
//import javax.swing.JMenu
//import javax.swing.JMenuItem
//import javax.swing.JMenuBar
//
//import akka.actor.ActorSelection
//import akka.event.Logging.Info
//
//import scala.collection.mutable.ListBuffer
//
//class Gui(controller: ActorSelection) {
//
//
//  val blackFieldColor = new Color(185, 122, 87)
//  val whiteFieldColor = new Color(239, 227, 175)
//  var firstClick = false
//  var startPosi = new PieceButton(None, new Point(-1, -1))
//  var TargetPosi = new PieceButton(None, new Point(-1, -1))
//  var tempColor = new Color(0, 0, 0)
//  val buttons = new ListBuffer[PieceButton]()
//  var frame: JFrame = new JFrame()
//  val menubar: JMenuBar = new JMenuBar()
//  val menu = new JMenu("File")
//  val itemNewGame = new JMenuItem("New Game")
//  menubar.add(menu)
//  menu.add(itemNewGame)
//
//
//  def update(info: Info): Unit = {
//
//  }
//
//  itemNewGame.addActionListener(new ActionListener() {
//    def actionPerformed(ev: ActionEvent) {
//      c.reset()
//      frame.getContentPane.removeAll()
//      buttons.clear()
//      initPieceButtons()
//      addActionListenerToBtns()
//      drawIconBoard()
//      colorizeBoard()
//    }
//  })
//
//  createFrame()
//  initPieceButtons()
//  colorizeBoard()
//  addActionListenerToBtns()
//  drawIconBoard()
//
//
//  frame.setJMenuBar(menubar)
//  frame.pack()
//  frame.setVisible(true)
//
//  private def createFrame() = {
//    JFrame.setDefaultLookAndFeelDecorated(true)
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
//    frame.setLayout(new GridLayout(8, 8))
//  }
//
//  private def initPieceButtons() = {
//    buttons += new PieceButton(Some("bTower"), Point(0, 0))
//    buttons += new PieceButton(Some("bKnight"), Point(1, 0))
//    buttons += new PieceButton(Some("bBishop"), Point(2, 0))
//    buttons += new PieceButton(Some("bQueen"), Point(3, 0))
//    buttons += new PieceButton(Some("bKing"), Point(4, 0))
//    buttons += new PieceButton(Some("bBishop"), Point(5, 0))
//    buttons += new PieceButton(Some("bKnight"), Point(6, 0))
//    buttons += new PieceButton(Some("bTower"), Point(7, 0))
//
//    for (i <- 0 to 7)
//      buttons += new PieceButton(Some("bPawn"), Point(i, 1))
//    for (i <- 0 to 7)
//      buttons += new PieceButton(None, Point(i, 2))
//    for (i <- 0 to 7)
//      buttons += new PieceButton(None, Point(i, 3))
//    for (i <- 0 to 7)
//      buttons += new PieceButton(None, Point(i, 4))
//    for (i <- 0 to 7)
//      buttons += new PieceButton(None, Point(i, 5))
//
//    for (i <- 0 to 7)
//      buttons += new PieceButton(Some("wPawn"), Point(i, 6))
//
//    buttons += new PieceButton(Some("wTower"), Point(0, 7))
//    buttons += new PieceButton(Some("wKnight"), Point(1, 7))
//    buttons += new PieceButton(Some("wBishop"), Point(2, 7))
//    buttons += new PieceButton(Some("wQueen"), Point(3, 7))
//    buttons += new PieceButton(Some("wKing"), Point(4, 7))
//    buttons += new PieceButton(Some("wBishop"), Point(5, 7))
//    buttons += new PieceButton(Some("wKnight"), Point(6, 7))
//    buttons += new PieceButton(Some("wTower"), Point(7, 7))
//  }
//
//  private def setBtnIcon(btn: PieceButton, icon: String): Unit = {
//    try {
//      val image = new ImageIcon(this.getClass.getResource(icon)).getImage
//      btn.setIcon(new ImageIcon(image))
//    } catch {
//      case ex: Exception =>
//        System.out.println(ex)
//    }
//  }
//
//  private def drawIconBoard() = {
//    for (n <- 0 to 63) {
//      frame.add(buttons(n))
//      buttons(n).figure match {
//        case Some(f) => setBtnIcon(buttons(n), "resources/" + f + ".png")
//        case None => buttons(n).setIcon(null)
//      }
//    }
//  }
//
//  private def colorizeBoard() = {
//    for (x <- 0 to 7) {
//      if (x % 2 == 0) {
//        buttons(x).setBackground(whiteFieldColor)
//        buttons(x + 16).setBackground(whiteFieldColor)
//        buttons(x + 32).setBackground(whiteFieldColor)
//        buttons(x + 48).setBackground(whiteFieldColor)
//
//        buttons(x + 9).setBackground(whiteFieldColor)
//        buttons(x + 25).setBackground(whiteFieldColor)
//        buttons(x + 41).setBackground(whiteFieldColor)
//        buttons(x + 57).setBackground(whiteFieldColor)
//
//        buttons(x + 8).setBackground(blackFieldColor)
//        buttons(x + 24).setBackground(blackFieldColor)
//        buttons(x + 40).setBackground(blackFieldColor)
//        buttons(x + 56).setBackground(blackFieldColor)
//      } else {
//        buttons(x).setBackground(blackFieldColor)
//        buttons(x + 16).setBackground(blackFieldColor)
//        buttons(x + 32).setBackground(blackFieldColor)
//        buttons(x + 48).setBackground(blackFieldColor)
//      }
//    }
//  }
//
//  private def addActionListenerToBtns() = {
//    for (x <- 0 to 63) {
//      buttons(x).setPreferredSize(new Dimension(60, 60))
//      buttons(x).addActionListener(new ActionListener {
//        override def actionPerformed(e: ActionEvent): Unit = {
//          BtnMoveLogik(x)
//        }
//      })
//    }
//  }
//
//  private def BtnMoveLogik(x: Int) = {
//    if (!c.gameLock()) {
//      if (!firstClick) {
//        frame.setTitle("")
//        firstClick = !firstClick
//        startPosi = buttons(x)
//        tempColor = buttons(x).getBackground
//        buttons(x).setBackground(Color.YELLOW)
//      } else {
//        firstClick = !firstClick
//        TargetPosi = buttons(x)
//        startPosi.setBackground(tempColor)
//        val move = c.handleMove(startPosi.pos, TargetPosi.pos)
//        if (move) {
//          TargetPosi.figure = startPosi.figure
//          startPosi.figure = None
//          drawIconBoard()
//          if (c.gameLock()) {
//            frame.setTitle("Game Over")
//            JOptionPane.showMessageDialog(frame,
//              "Game Over " + c.getWinner() + " is Winner");
//          }
//        } else {
//          frame.setTitle(frame.getTitle + " invalid Move")
//        }
//      }
//    }
//  }
//}