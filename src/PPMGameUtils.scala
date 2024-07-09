import PPMGameUtils.Direction.Direction

import scala.io.Source

object PPMGameUtils {

  type Board = List[List[Char]]

  type Coord2D = (Int, Int) //(row, column)

  object Direction extends Enumeration {
    type Direction = Value
    val North, South, East, West,
    NorthEast, NorthWest, SouthEast, SouthWest = Value
  }

  def printBoard(board: Board): Unit = {
    def printRow(row: List[Char]): Unit = row match {
      case Nil => println()
      case head :: tail =>
        print(head + " ")
        printRow(tail)
    }

    board match {
      case Nil =>
      case head :: tail =>
        printRow(head)
        printBoard(tail)
    }
  }

  //T1
  def nextChar(r: RandomWithState): (Char, RandomWithState) = {
    val (i, nextRandom) = r.nextInt(26)
    i match {
      case 0 => ('A', nextRandom)
      case 1 => ('B', nextRandom)
      case 2 => ('C', nextRandom)
      case 3 => ('D', nextRandom)
      case 4 => ('E', nextRandom)
      case 5 => ('F', nextRandom)
      case 6 => ('G', nextRandom)
      case 7 => ('H', nextRandom)
      case 8 => ('I', nextRandom)
      case 9 => ('J', nextRandom)
      case 10 => ('K', nextRandom)
      case 11 => ('L', nextRandom)
      case 12 => ('M', nextRandom)
      case 13 => ('N', nextRandom)
      case 14 => ('O', nextRandom)
      case 15 => ('P', nextRandom)
      case 16 => ('Q', nextRandom)
      case 17 => ('R', nextRandom)
      case 18 => ('S', nextRandom)
      case 19 => ('T', nextRandom)
      case 20 => ('U', nextRandom)
      case 21 => ('V', nextRandom)
      case 22 => ('W', nextRandom)
      case 23 => ('X', nextRandom)
      case 24 => ('Y', nextRandom)
      case 25 => ('Z', nextRandom)
    }
  }

  //T2
  def fillOneCell(board: Board, letter: Char, coord: Coord2D): Board = {

    board match {
      case Nil => board
      case head::tail =>
        if(coord._1 > 0)
          head::fillOneCell(board, letter, (coord._1-1, coord._2))
        else
          processRow(letter, coord._2, head)::tail
    }

  }

  //T2 AUX
  def processRow(letter: Char, position: Int, row: List[Char]): List[Char] = {

    row match {
      case Nil => row
      case head::tail =>
        if(position > 0)
          head::processRow(letter, position-1, tail)
        else
          letter::tail
    }

  }

  //T3
  def setBoardWithWords(board: Board, words: List[String], positions: List[List[Coord2D]]): Board = {
    words.zip(positions).foldLeft(board) {
      case (board, (word, positions)) => addWordToBoard(board, word, positions)
    }
  }
  //T3 AUX
  def addWordToBoard(board: Board, word: String, coords: List[Coord2D]): Board = {
    coords match {
      case Nil => board
      case (row, col) :: tail =>
        val updatedRow = board(row).updated(col, word.head)
        val updatedBoard = board.updated(row, updatedRow)
        addWordToBoard(updatedBoard, word.tail, tail)
    }
  }


  def readWordsAndCoordsFromFile(filePath: String): List[(String, List[Coord2D])] = {
    val lines = Source.fromFile(filePath).getLines().toList
    lines.map { line =>
      val parts = line.split(" ")
      val word = parts.head
      val coords = parts.tail.map { coordStr =>
        val Array(row, col) = coordStr.split(",")
        (row.toInt, col.toInt)
      }.toList
      (word, coords)
    }
  }

  //T4
  def completeBoardRandomly(board: Board, r: MyRandom, f: RandomWithState => (Char, RandomWithState)): (Board, RandomWithState) = {
    board match {
      case Nil => (board, r)
      case head :: tail =>
        val (filledRow, updatedRandom) = completeRowRandomly(head, r, f)
        val (filledTail, finalRandom) = completeBoardRandomly(tail, updatedRandom.asInstanceOf[MyRandom], f)
        (filledRow :: filledTail, finalRandom)
    }
  }

  def completeRowRandomly(row: List[Char], r: MyRandom, f: RandomWithState => (Char, RandomWithState)): (List[Char], RandomWithState) = {
    row match {
      case Nil => (row, r)
      case head :: tail if head != ' ' =>
        val (filledCell, updatedRandom) = f(r)
        val (filledTail, finalRandom) = completeRowRandomly(tail, updatedRandom.asInstanceOf[MyRandom], f)
        (head :: filledTail, finalRandom)
      case _ :: tail =>
        val (filledCell, updatedRandom) = f(r)
        val (filledTail, finalRandom) = completeRowRandomly(tail, updatedRandom.asInstanceOf[MyRandom], f)
        (filledCell :: filledTail, finalRandom)
    }
  }


  //T5
  def play(word: String, position: Coord2D, direction: Direction.Direction, board: Board): Boolean = {


    def checkWord(coord: Coord2D, remainingWord: String, turn: Int): Boolean = {


      remainingWord match {
        case "" => true
        case _ =>
          coord match {
            case (r, c) if r < 0 || r >= board.length || c < 0 || c >= board(0).length => false
            case (r, c) if board(r)(c) != remainingWord.head => false
            case _ =>
              // Avança para a próxima posição na direção especificada
              val nextCoord = direction match {
                case Direction.North => (coord._1 - 1, coord._2)
                case Direction.South => (coord._1 + 1, coord._2)
                case Direction.East => (coord._1, coord._2 + 1)
                case Direction.West => (coord._1, coord._2 - 1)
                case Direction.NorthEast => (coord._1 - 1, coord._2 + 1)
                case Direction.NorthWest => (coord._1 - 1, coord._2 - 1)
                case Direction.SouthEast => (coord._1 + 1, coord._2 + 1)
                case Direction.SouthWest => (coord._1 + 1, coord._2 - 1)
              }

              if (turn > 0) {
                //Quando a segunda letra é encontrada, passa a pesquisar em todas as direções a próxima letra
                isWordFoundFromCoord(remainingWord, coord, board)

              } else {checkWord(nextCoord, remainingWord.tail, turn + 1)}


          }
      }
    }
    checkWord(position, word, 0)
  }


  def isWordFoundFromCoord(word: String, startCoord: Coord2D, board: Board): Boolean = {
    def searchFrom(coord: Coord2D, remainingWord: String, visited: Set[Coord2D]): Boolean = {
      if (remainingWord.isEmpty) return true
      val (row, col) = coord
      if (row < 0 || col < 0 || row >= board.length || col >= board.head.length || visited.contains(coord) || board(row)(col) != remainingWord.head)
        return false

      val directions = List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))
      directions.exists { case (dr, dc) =>
        val nextCoord = (row + dr, col + dc)
        searchFrom(nextCoord, remainingWord.tail, visited + coord)
      }
    }

    searchFrom(startCoord, word, Set.empty)
  }

  //T6
  def validateBoard(board: Board, wordList: List[String]): Boolean = {

    wordList match {
      case Nil => true
      case a :: b =>
        if (isWordFoundWholeBoard(a, board))
          validateBoard(board, b)
        else
          false
    }
  }

  def isWordFoundWholeBoard(word: String, board: Board): Boolean = {
    def searchFrom(coord: Coord2D, word: String, visited: Set[Coord2D]): Boolean = {
      if (word.isEmpty) return true
      val (row, col) = coord
      if (row < 0 || col < 0 || row >= board.length || col >= board.head.length || visited.contains(coord) || board(row)(col) != word.head
      )
        return false

      val directions = List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))
      directions.exists { case (dr, dc) =>
        searchFrom((row + dr, col + dc), word.tail, visited + coord)
      }
    }

    board.indices.exists(row =>
      board(row).indices.exists(col =>
        searchFrom((row, col), word, Set.empty)
      )
    )
  }


  def checkGameWon(a: List[String], b: List[String]): Boolean = {

    return a.toSet == b.toSet

  }


} //final parenthesis