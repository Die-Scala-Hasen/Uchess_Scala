/**
  * Created by mbo on 25.09.2017.
  */
import Array._

object Main {
  def main(args: Array[String]) {
    var myMatrix = ofDim[Int](3,3)

    // build a matrix
    for (i <- 0 to 2; j <- 0 to 2) {
        myMatrix(i)(j) = j;
    }

    // Print two dimensional array
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }
}