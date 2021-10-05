package com.example.tictactoe

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
STATUS -> Won = 1,Ongoing = 0,Draw = 2
ButtonValues -> X - 1 , O - 2
*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playerOne = findViewById<TextView>(R.id.playerOneName)
        val playerTwo = findViewById<TextView>(R.id.playerTwoName)

        var playerOneName = playerOne.text.toString()
        if (playerOneName.isBlank()){
            playerOneName = playerOne.hint.toString()
        }
        var playerTwoName = playerTwo.text.toString()
        if (playerTwoName.isBlank()){
            playerOneName = playerTwo.hint.toString()
        }
        //println (playerOneName)
        //println (playerTwoName)
        var turn = 'O'
        var totalMoves = 0;
        var status = 0
        var buttonArray = Array(3) { Array(3) { 0 } }

        val button1 = findViewById<ImageView>(R.id.button1)
        val button2 = findViewById<ImageView>(R.id.button2)
        val button3 = findViewById<ImageView>(R.id.button3)
        val button4 = findViewById<ImageView>(R.id.button4)
        val button5 = findViewById<ImageView>(R.id.button5)
        val button6 = findViewById<ImageView>(R.id.button6)
        val button7 = findViewById<ImageView>(R.id.button7)
        val button8 = findViewById<ImageView>(R.id.button8)
        val button9 = findViewById<ImageView>(R.id.button9)
        val resetButton = findViewById<Button>(R.id.resetButton)

        fun gameReset() {
            buttonArray = Array(3) { Array(3) { 0 } }
            turn = 'O'
            status = 0
            totalMoves = 0;
            button1.setImageResource(R.drawable.background);
            button2.setImageResource(R.drawable.background);
            button3.setImageResource(R.drawable.background);
            button4.setImageResource(R.drawable.background);
            button5.setImageResource(R.drawable.background);
            button6.setImageResource(R.drawable.background);
            button7.setImageResource(R.drawable.background);
            button8.setImageResource(R.drawable.background);
            button9.setImageResource(R.drawable.background);

        }

        fun checkWon(turnValue: Int,name : String) {
            var won = 0
            if (totalMoves >= 3) {
                // Checking all the rows
                for (i in 0 until 3) {
                    var won1 = 1;
                    for (j in 0 until 3) {
                        if (buttonArray[i][j] != turnValue) {
                            won1 = 0;
                            break;
                        }
                    }
                    if (won1 == 1) {
                        won = 1;
                        break;
                    }
                }
                if (won == 1) {
                    status = 1
                    Toast.makeText(this, "${name} won the game", Toast.LENGTH_LONG).show()
                    gameReset()
                }
                // Checking all the coloumns
                for (i in 0 until 3) {
                    var won2 = 1;
                    for (j in 0 until 3) {
                        if (buttonArray[j][i] != turnValue) {
                            won2 = 0;
                            break;
                        }
                    }
                    if (won2 == 1) {
                        won = 1;
                        break;
                    }
                }
                if (won == 1) {
                    status = 1;
                    Toast.makeText(this, "$name won the game", Toast.LENGTH_LONG).show()
                    gameReset()
                }
                // Check Diagonals
                var won3 = 1;
                var won4 = 1;
                var a = 0;
                var b = 0;
                var c = 2;
                while ((a < 3)) {
                    if (buttonArray[a][a] != turnValue) {
                        won3 = 0;
                        break;
                    }
                    a++;
                }
                while (b < 3 && c >= 0) {
                    if (buttonArray[b][c] != turnValue) {
                        won4 = 0;
                        break;
                    }
                    b++;
                    c--;
                }
                if (won3 == 1 || won4 == 1) {
                    won = 1;
                }
                if (won == 1) {
                    status = 1;
                    Toast.makeText(this, "$name won the game", Toast.LENGTH_LONG).show()
                    gameReset()
                }
            }
        }

        fun checkDraw() {
            if (totalMoves == 9) {
                status = 2
                Toast.makeText(this, "Game is Draw, Resetting Game", Toast.LENGTH_LONG).show()
                gameReset()
            }
        }

        fun toggleTurn(turnChar: Char) {
            if (turnChar == 'O') {
                turn = 'X'
            } else {
                turn = 'O'
            }
        }


        button1.setOnClickListener {
            if (buttonArray[0][0] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button1.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[0][0] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button1.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[0][0] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button2.setOnClickListener {
            if (buttonArray[0][1] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button2.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[0][1] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button2.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[0][1] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button3.setOnClickListener {
            if (buttonArray[0][2] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button3.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[0][2] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button3.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[0][2] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button4.setOnClickListener {
            if (buttonArray[1][0] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button4.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[1][0] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button4.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[1][0] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button5.setOnClickListener {
            if (buttonArray[1][1] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button5.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[1][1] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button5.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[1][1] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button6.setOnClickListener {
            if (buttonArray[1][2] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button6.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[1][2] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button6.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[1][2] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button7.setOnClickListener {
            if (buttonArray[2][0] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button7.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[2][0] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button7.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[2][0] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button8.setOnClickListener {
            if (buttonArray[2][1] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button8.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[2][1] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button8.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[2][1] = 2
                    checkWon(2,playerOneName)
                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        button9.setOnClickListener {
            if (buttonArray[2][2] == 0) {
                totalMoves++;
                if (turn == 'X') {
                    button9.setImageResource(R.drawable.cross)
                    toggleTurn(turn)
                    buttonArray[2][2] = 1
                    checkWon(1, playerTwoName)
                    checkDraw()
                } else {
                    button9.setImageResource(R.drawable.circle)
                    toggleTurn(turn)
                    buttonArray[2][2] = 2
                    checkWon(2,playerOneName)

                    checkDraw()
                }
            } else {
                Toast.makeText(this, "Invalid Move! Try again", Toast.LENGTH_LONG).show()
            }
        }
        resetButton.setOnClickListener {
            Toast.makeText(this, "Game is reset", Toast.LENGTH_SHORT).show()
            gameReset()
        }
    }
}