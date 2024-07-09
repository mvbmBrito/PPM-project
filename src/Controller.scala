import PPMGameUtils.Coord2D
import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.{Alert, Button, ButtonType, Label, TextField}
import javafx.scene.layout.GridPane

import java.net.URL
import java.util.ResourceBundle

class Controller extends Initializable{

  @FXML
  private var button00: Button = _

  @FXML
  private var button01: Button = _
  @FXML
  private var button02: Button = _
  @FXML
  private var button03: Button = _
  @FXML
  private var button04: Button = _
  @FXML
  private var button10: Button = _
  @FXML
  private var button11: Button = _
  @FXML
  private var button12: Button = _
  @FXML
  private var button13: Button = _
  @FXML
  private var button14: Button = _
  @FXML
  private var button20: Button = _
  @FXML
  private var button21: Button = _
  @FXML
  private var button22: Button = _
  @FXML
  private var button23: Button = _
  @FXML
  private var button24: Button = _
  @FXML
  private var button30: Button = _
  @FXML
  private var button31: Button = _
  @FXML
  private var button32: Button = _
  @FXML
  private var button33: Button = _
  @FXML
  private var button34: Button = _
  @FXML
  private var button40: Button = _
  @FXML
  private var button41: Button = _
  @FXML
  private var button42: Button = _
  @FXML
  private var button43: Button = _
  @FXML
  private var button44: Button = _

  @FXML
  private var buttonN: Button = _
  @FXML
  private var buttonS: Button = _
  @FXML
  private var buttonE: Button = _
  @FXML
  private var buttonW: Button = _
  @FXML
  private var buttonNE: Button = _
  @FXML
  private var buttonNW: Button = _
  @FXML
  private var buttonSE: Button = _
  @FXML
  private var buttonSW: Button = _

  @FXML
  private var grid: GridPane = _

  @FXML
  private var textField: TextField = _
  @FXML
  private var label: Label = _
  @FXML
  private var LabelGameWon: Label = _
  @FXML
  private var pointsLabel: Label = _
  @FXML
  private var points: Label = _
  @FXML
  private var mistakeLabel: Label = _
  @FXML
  private var resetButton: Button = _
  @FXML
  private var voltarparatras: Button = _
  @FXML
  private var labelPontuacao: Label = _
  @FXML
  private var finalPoints: Label = _
  @FXML
  private var labelPlayAgain: Label = _
  @FXML
  private var playAgain: Button = _
  @FXML
  private var repeatWord: Label = _
  @FXML
  private var correct: Label = _


  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    button00.setText(FxApp.filledBoard(0)(0).toString)
    button01.setText(FxApp.filledBoard(0)(1).toString)
    button02.setText(FxApp.filledBoard(0)(2).toString)
    button03.setText(FxApp.filledBoard(0)(3).toString)
    button04.setText(FxApp.filledBoard(0)(4).toString)
    button10.setText(FxApp.filledBoard(1)(0).toString)
    button11.setText(FxApp.filledBoard(1)(1).toString)
    button12.setText(FxApp.filledBoard(1)(2).toString)
    button13.setText(FxApp.filledBoard(1)(3).toString)
    button14.setText(FxApp.filledBoard(1)(4).toString)
    button20.setText(FxApp.filledBoard(2)(0).toString)
    button21.setText(FxApp.filledBoard(2)(1).toString)
    button22.setText(FxApp.filledBoard(2)(2).toString)
    button23.setText(FxApp.filledBoard(2)(3).toString)
    button24.setText(FxApp.filledBoard(2)(4).toString)
    button30.setText(FxApp.filledBoard(3)(0).toString)
    button31.setText(FxApp.filledBoard(3)(1).toString)
    button32.setText(FxApp.filledBoard(3)(2).toString)
    button33.setText(FxApp.filledBoard(3)(3).toString)
    button34.setText(FxApp.filledBoard(3)(4).toString)
    button40.setText(FxApp.filledBoard(4)(0).toString)
    button41.setText(FxApp.filledBoard(4)(1).toString)
    button42.setText(FxApp.filledBoard(4)(2).toString)
    button43.setText(FxApp.filledBoard(4)(3).toString)
    button44.setText(FxApp.filledBoard(4)(4).toString)
    voltarparatras.setVisible(false)
    labelPontuacao.setVisible(false)
    finalPoints.setVisible(false)
    LabelGameWon.setVisible(false)
    labelPlayAgain.setVisible(false)
    playAgain.setVisible(false)
    repeatWord.setVisible(false)
    correct.setVisible(false)
    updatePoints()
  }



  def buttonNOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.North)

  }

  def buttonSOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.South)

  }

  def buttonEOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.East)

  }

  def buttonWOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.West)

  }

  def buttonNWOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.NorthWest)

  }

  def buttonNEOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.NorthEast)

  }

  def buttonSEOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.SouthEast)

  }

  def buttonSWOnClick(): Unit = {

    checkWord(PPMGameUtils.Direction.SouthWest)

  }




  def button00_onClick(): Unit = {
    showInputs(0,0)
  }

  def button01_onClick(): Unit = {
    showInputs(0,1)

  }

  def button02_onClick(): Unit = {
    showInputs(0,2)

  }

  def button03_onClick(): Unit = {
    showInputs(0,3)

  }

  def button04_onClick(): Unit = {
    showInputs(0,4)

  }

  def button10_onClick(): Unit = {
    showInputs(1,0)

  }

  def button11_onClick(): Unit = {
    showInputs(1,1)

  }

  def button12_onClick(): Unit = {
    showInputs(1,2)

  }

  def button13_onClick(): Unit = {
    showInputs(1,3)

  }

  def button14_onClick(): Unit = {
    showInputs(1,4)

  }

  def button20_onClick(): Unit = {
    showInputs(2,0)

  }

  def button21_onClick(): Unit = {
    showInputs(2,1)

  }

  def button22_onClick(): Unit = {
    showInputs(2,2)

  }

  def button23_onClick(): Unit = {
    showInputs(2,3)

  }

  def button24_onClick(): Unit = {
    showInputs(2,4)

  }

  def button30_onClick(): Unit = {
    showInputs(3,0)

  }

  def button31_onClick(): Unit = {
    showInputs(3,1)

  }

  def button32_onClick(): Unit = {
    showInputs(3,2)

  }

  def button33_onClick(): Unit = {
    showInputs(3,3)

  }

  def button34_onClick(): Unit = {
    showInputs(3,4)

  }

  def button40_onClick(): Unit = {
    showInputs(4,0)

  }

  def button41_onClick(): Unit = {
    showInputs(4,1)

  }

  def button42_onClick(): Unit = {
    showInputs(4,2)

  }

  def button43_onClick(): Unit = {
    showInputs(4,3)

  }

  def button44_onClick(): Unit = {
    showInputs(4,4)
  }

  def resetButtonOnClick(): Unit = {
    val alert = new Alert(AlertType.CONFIRMATION)
    alert.setTitle("Confirmação de reinicialização")
    alert.setHeaderText("Tem a certeza de que deseja reiniciar o jogo?")
    alert.setContentText("Isso irá limpar todos os progressos atuais.")

    val result = alert.showAndWait()
    if (result.get() == ButtonType.OK) {
      resetGame()
    }
  }

  def playAgain_onClick(): Unit = {
    resetGame()
  }

  def voltarparatras_onClick(): Unit = {
    back()
  }


  private def back(): Unit = {

    val wordsFoundBackup = FxApp.wordsFound
    FxApp.wordsFound = List[String]()
    FxApp.wordsFound = wordsFoundBackup
    textField.clear()
    pointsLabel.setText(FxApp.points.toString)
    mistakeLabel.setVisible(false)
    grid.setVisible(true)
    textField.setVisible(false)
    label.setVisible(false)
    buttonS.setVisible(false)
    buttonN.setVisible(false)
    buttonSW.setVisible(false)
    buttonSE.setVisible(false)
    buttonE.setVisible(false)
    buttonW.setVisible(false)
    buttonNE.setVisible(false)
    buttonNW.setVisible(false)
    LabelGameWon.setVisible(false)
    labelPontuacao.setVisible(false)
    finalPoints.setVisible(false)
    pointsLabel.setVisible(true)
    resetButton.setVisible(true)
    points.setVisible(true)
    voltarparatras.setVisible(false)
    labelPlayAgain.setVisible(false)
    playAgain.setVisible(false)
    repeatWord.setVisible(false)
    correct.setVisible(false)
    FxApp.selectedCoord = null
  }


  private def resetGame(): Unit = {
    FxApp.wordsFound = List[String]()
    FxApp.points = 0
    textField.clear()
    pointsLabel.setText(FxApp.points.toString)
    mistakeLabel.setVisible(false)
    grid.setVisible(true)
    textField.setVisible(false)
    label.setVisible(false)
    buttonS.setVisible(false)
    buttonN.setVisible(false)
    buttonSW.setVisible(false)
    buttonSE.setVisible(false)
    buttonE.setVisible(false)
    buttonW.setVisible(false)
    buttonNE.setVisible(false)
    buttonNW.setVisible(false)
    LabelGameWon.setVisible(false)
    labelPontuacao.setVisible(false)
    finalPoints.setVisible(false)
    voltarparatras.setVisible(false)
    labelPlayAgain.setVisible(false)
    playAgain.setVisible(false)
    pointsLabel.setVisible(true)
    resetButton.setVisible(true)
    points.setVisible(true)
    repeatWord.setVisible(false)
    correct.setVisible(false)
    FxApp.selectedCoord = null
  }


  private def showInputs(coord2D: Coord2D): Unit = {

    mistakeLabel.setVisible(false)
    buttonS.setVisible(true)
    buttonN.setVisible(true)
    buttonSW.setVisible(true)
    buttonSE.setVisible(true)
    buttonE.setVisible(true)
    buttonW.setVisible(true)
    buttonNE.setVisible(true)
    buttonNW.setVisible(true)
    grid.setVisible(false)
    textField.setVisible(true)
    label.setVisible(true)
    pointsLabel.setVisible(false)
    resetButton.setVisible(false)
    points.setVisible(false)
    voltarparatras.setVisible(true)
    labelPontuacao.setVisible(false)
    finalPoints.setVisible(false)
    labelPlayAgain.setVisible(false)
    playAgain.setVisible(false)
    repeatWord.setVisible(false)
    correct.setVisible(false)
    FxApp.selectedCoord = coord2D

  }

  private def gameWon(): Unit = {
    buttonS.setVisible(false)
    buttonN.setVisible(false)
    buttonSW.setVisible(false)
    buttonSE.setVisible(false)
    buttonE.setVisible(false)
    buttonW.setVisible(false)
    buttonNE.setVisible(false)
    buttonNW.setVisible(false)
    textField.setVisible(false)
    label.setVisible(false)
    LabelGameWon.setVisible(true)
    labelPontuacao.setVisible(true)
    finalPoints.setVisible(true)
    voltarparatras.setVisible(false)
    labelPlayAgain.setVisible(true)
    playAgain.setVisible(true)
    repeatWord.setVisible(false)
    correct.setVisible(false)

  }

  private def repeatedWord(): Unit = {
    mistake()
    repeatWord.setVisible(true)
    mistakeLabel.setVisible(false)

  }


  private def checkWord(direction: PPMGameUtils.Direction.Direction): Unit = {

    var word = textField.getText.toUpperCase

    textField.clear()

    val isWordFound = PPMGameUtils.play(word, FxApp.selectedCoord, direction, FxApp.filledBoard)

    if (isWordFound && FxApp.wordsToFind.contains(word)) {
      FxApp.wordsFound :+= word
      FxApp.points += 50
      updatePoints()

      if (PPMGameUtils.checkGameWon(FxApp.wordsFound, FxApp.wordsToFind)) {
        gameWon()

      } else {
        buttonS.setVisible(false)
        buttonN.setVisible(false)
        buttonSW.setVisible(false)
        buttonSE.setVisible(false)
        buttonE.setVisible(false)
        buttonW.setVisible(false)
        buttonNE.setVisible(false)
        buttonNW.setVisible(false)
        grid.setVisible(true)
        textField.setVisible(false)
        label.setVisible(false)
        resetButton.setVisible(true)
        pointsLabel.setVisible(true)
        points.setVisible(true)
        voltarparatras.setVisible(false)
        LabelGameWon.setVisible(false)
        labelPontuacao.setVisible(false)
        finalPoints.setVisible(false)
        labelPlayAgain.setVisible(false)
        playAgain.setVisible(false)
        repeatWord.setVisible(false)
        correct.setVisible(true)

      }
    } else {
      if(FxApp.wordsFound.contains(word)){
        repeatedWord()
      } else{
        mistake()
      }


    }

  }

  private def updatePoints(): Unit = {
    pointsLabel.setText(FxApp.points.toString)
    finalPoints.setText(FxApp.points.toString)
  }

  private def mistake(): Unit = {

    if (FxApp.points - 25 < 0) 0 else FxApp.points -= 25
    updatePoints()

    buttonS.setVisible(false)
    buttonN.setVisible(false)
    buttonSW.setVisible(false)
    buttonSE.setVisible(false)
    buttonE.setVisible(false)
    buttonW.setVisible(false)
    buttonNE.setVisible(false)
    buttonNW.setVisible(false)
    grid.setVisible(true)
    textField.setVisible(false)
    label.setVisible(false)
    mistakeLabel.setVisible(true)
    resetButton.setVisible(true)
    pointsLabel.setVisible(true)
    points.setVisible(true)
    voltarparatras.setVisible(false)
    LabelGameWon.setVisible(false)
    labelPontuacao.setVisible(false)
    finalPoints.setVisible(false)
    labelPlayAgain.setVisible(false)
    playAgain.setVisible(false)
    repeatWord.setVisible(false)
    correct.setVisible(false)

  }



}