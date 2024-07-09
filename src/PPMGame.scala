import PPMGameUtils.{Board, Direction}

import java.util.{Timer, TimerTask}
import scala.annotation.tailrec
import scala.Console

object Game extends App {

  //Run the timer for 5 minutes, if they go by, the game is lost!

  val timer = new Timer()
  val gameDuration = 5 * 60 * 1000 // 5 minutes in milliseconds

  println("Bem vindo ao SOPA DE LETRAS ZIG ZAG!")
  println("")
  println("Tem 5 MINUTOS para encontrar todas as palavras, VAMOS!!!")
  println("")


  timer.schedule(new TimerTask {
    def run(): Unit = {
      println("GAME OVER! O tempo terminou!")
      System.exit(0)
    }
  }, gameDuration)


  val r = MyRandom(System.nanoTime())
  val initialBoard: PPMGameUtils.Board = List.fill(5)(List.fill(5)(' '))

  val filePath = "C:\\Users\\Miguel Brito\\Desktop\\PROJETOPPMMMMM\\untitled\\src\\words.txt"
  val wordsAndCoords = PPMGameUtils.readWordsAndCoordsFromFile(filePath)
  val boardWithWords = PPMGameUtils.setBoardWithWords(initialBoard, wordsAndCoords.map(_._1), wordsAndCoords.map(_._2))

  val filledBoard = PPMGameUtils.completeBoardRandomly(boardWithWords, r, PPMGameUtils.nextChar)._1

  val points = 0

  mainloop(filledBoard, points, wordsAndCoords.map(_._1), List())

  def mainloop(board: PPMGameUtils.Board, points: Int, wordsToFind: List[String], wordsFound: List[String]): Unit = {

    //Validar a board
    if (!PPMGameUtils.validateBoard(board, wordsToFind)) {
      println("A lista de palavras a encontrar não não foi corretamente validada na board, carregue o jogo com uma lista válida.")
      System.exit(0)
    }

    //Ver se o jogo está ganho
    if(PPMGameUtils.checkGameWon(wordsToFind, wordsFound)) {
      println(" ")
      println("PARABÉNS, VENCEU O JOGO!!!")
      println("Score: " + points + " pontos")
      System.exit(0)

    } else {

      PPMGameUtils.printBoard(filledBoard)

      println()
      println("Score atual: " + points + " pontos")
      println()


      println("Insira a palavra que deseja procurar:")
      val palavra = scala.io.StdIn.readLine().toUpperCase()

      println("Insira a coordenada da primeira letra (linha, coluna):")
      val coordenadas = scala.io.StdIn.readLine().split(",").map(_.trim.toInt)
      if (coordenadas.length != 2) {
        println("Coordenadas inválidas. Tente novamente.")
      } else {
        val (linha, coluna) = (coordenadas(0), coordenadas(1))

        println("Insira a direção até a segunda letra (North, South, East, West, NorthEast, NorthWest, SouthEast, SouthWest):")
        val direcaoString = scala.io.StdIn.readLine().toLowerCase()
        val direcao = direcaoString match {
          case "north" => Direction.North
          case "south" => Direction.South
          case "east" => Direction.East
          case "west" => Direction.West
          case "northeast" => Direction.NorthEast
          case "northwest" => Direction.NorthWest
          case "southeast" => Direction.SouthEast
          case "southwest" => Direction.SouthWest
          case _ => throw new IllegalArgumentException("Direção inválida")
        }

        val isWordFound = PPMGameUtils.play(palavra, (linha, coluna), direcao, filledBoard) && wordsToFind.contains(palavra)

        val alreadyFound = wordsFound.contains(palavra)

        if (isWordFound) {


          if (alreadyFound) {
            println("Esta palavra já foi encontrada!")
            println("")


          } else {
            println("Você acertou! A palavra que escreveu está no tabuleiro.")
            println("")
          }


          mainloop(board,if(alreadyFound) points else points + 50 , wordsToFind, if(alreadyFound) wordsFound else palavra::wordsFound)


        } else {
          println("Palavra não encontrada. Tente novamente.")
          println("")
          println("")

          //continuamos o jogo e retiramos 25 pontos
          mainloop(board,if(points-25<0) 0 else points-25, wordsToFind, wordsFound)
        }
      }


    }

  }




}