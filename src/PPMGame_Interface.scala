import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class PPMGame_Interface extends Application {


  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("PPM GAME")
    val fxmlLoader = new FXMLLoader(getClass.getResource("Controller.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}
object FxApp {

  val r = MyRandom(System.nanoTime())
  val initialBoard: PPMGameUtils.Board = List.fill(5)(List.fill(5)(' '))

  val filePath = "C:\\Users\\Miguel Brito\\Desktop\\PROJETOPPMMMMM\\untitled\\src\\words.txt"
  val wordsAndCoords = PPMGameUtils.readWordsAndCoordsFromFile(filePath)
  val boardWithWords = PPMGameUtils.setBoardWithWords(initialBoard, wordsAndCoords.map(_._1), wordsAndCoords.map(_._2))

  var filledBoard = PPMGameUtils.completeBoardRandomly(boardWithWords, r, PPMGameUtils.nextChar)._1

  var points = 0

  var wordsFound = List[String]()

  var wordsToFind = wordsAndCoords.map(_._1)

  var selectedCoord = (-1,-1)

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[PPMGame_Interface], args: _*)
  }

}

