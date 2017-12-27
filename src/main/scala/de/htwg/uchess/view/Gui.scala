package de.htwg.uchess.view

import java.awt.Color

import de.htwg.uchess.controller.Controller
import javax.swing.JButton
import javax.swing.JFrame
import java.awt.GridLayout

class Gui(controller: Controller) {

  val blackFieldColor = new Color(185, 122, 87)
  val whiteFieldColor = new Color(239, 227, 175)

  JFrame.setDefaultLookAndFeelDecorated(true)
  val frame: JFrame = new JFrame("GridLayout Test")
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setLayout(new GridLayout(8, 8))


  val buttons = List.fill(64)(new JButton())


  for (x <- 0 to 7) {
    if (x % 2 == 0) {
      buttons(x).setBackground(whiteFieldColor)
      buttons(x + 16).setBackground(whiteFieldColor)
      buttons(x + 32).setBackground(whiteFieldColor)
      buttons(x + 48).setBackground(whiteFieldColor)

      buttons(x + 9).setBackground(whiteFieldColor)
      buttons(x + 25).setBackground(whiteFieldColor)
      buttons(x + 41).setBackground(whiteFieldColor)
      buttons(x + 57).setBackground(whiteFieldColor)

      buttons(x + 8).setBackground(blackFieldColor)
      buttons(x + 24).setBackground(blackFieldColor)
      buttons(x + 40).setBackground(blackFieldColor)
      buttons(x + 56).setBackground(blackFieldColor)

//      buttons(x + 9).setText("" + (x+9) )
//      buttons(x + 25).setText(""+ (x + 25))
//      buttons(x + 41).setText(""+(x + 41))
//      buttons(x + 57).setText(""+(x + 57))
//
//      buttons(x).setText("" + x )
//      buttons(x + 16).setText(""+ (x + 16))
//      buttons(x + 32).setText(""+(x + 32))
//      buttons(x + 48).setText(""+(x +48))
//
//      buttons(x + 8).setText("" + (x+8) )
//      buttons(x + 24).setText(""+ (x + 24))
//      buttons(x + 40).setText(""+(x + 40))
//      buttons(x + 56).setText(""+(x + 56))
    } else {
      buttons(x).setBackground(blackFieldColor)
      buttons(x + 16).setBackground(blackFieldColor)
      buttons(x + 32).setBackground(blackFieldColor)
      buttons(x + 48).setBackground(blackFieldColor)

//      buttons(x).setText("" + x )
//      buttons(x + 16).setText(""+ (x + 16))
//      buttons(x + 32).setText(""+(x + 32))
//      buttons(x + 48).setText(""+(x +48))
    }
  }


//  try {
//
//    val image = new ImageIcon(this.getClass.getResource("horse.png")).getImage
//    val img = ImageIO.read(getClass.getResource("horse.png"))
//    buttons(0).setIcon(new ImageIcon(img))
//  } catch {
//    case ex: Exception =>
//      System.out.println(ex)
//  }


  for (n <- 0 to 63) {
    frame.add(buttons(n))
  }

  frame.pack()
  frame.setVisible(true)

  }