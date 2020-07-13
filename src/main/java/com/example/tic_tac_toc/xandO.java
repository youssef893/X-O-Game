package com.example.tic_tac_toc;

import android.util.Log;

import java.util.Random;

public class xandO
{
    private static final Random RANDOM = new Random();
    private int [][] game;
    private boolean endGame;
    private final static int X = 1, O = -1, size = 3;
    private int player;

    public boolean isEndGame()
    {
        return endGame;
    }

    public xandO()
    {
        game = new int[size][size];
        newGame();
    }

    public int play(int i, int j)
    {
        int choice = 0;

        if (game[i][j] == 1 || game[i][j] == -1)
            return 100;

        if(i < size && j < size && i >= 0 && j >= 0 && !endGame)
        {
            game[i][j] = player; // add play to position
            if(player == X)
                choice = X; // to return player name is x to appear in ui
            else if(player == O)
                choice = O; // to return player name is o to appear in ui
            player = -player; // change player

        }

        return choice;
    }

    public void newGame()
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                game[i][j] = 0; // reset the position
        player = X; // let x to start

    }

    public String isWinner()
    {
        // check who is winner. check the the win places directly.
        String  checker;
        if ((game[0][0] == 1 && game[0][1] == 1 && game[0][2] == 1)
            || (game[1][0] == 1 && game[1][1] == 1 && game[1][2] == 1)
            || (game[2][0] == 1 && game[2][1] == 1 && game[2][2] == 1)
            || (game[0][0] == 1 && game[1][1] == 1 && game[2][2] == 1)
            || (game[0][2] == 1 && game[1][1] == 1 && game[2][0] == 1)
            || (game[0][0] == 1 && game[1][0] == 1 && game[2][0] == 1)
            || (game[0][1] == 1 && game[1][1] == 1 && game[2][1] == 1)
            || (game[0][2] == 1 && game[1][2] == 1 && game[2][2] == 1))
        {
            checker = "X";
            endGame = true;
        }
        else if ((game[0][0] == -1 && game[0][1] == -1 && game[0][2] == -1)
                || (game[1][0] == -1 && game[1][1] == -1 && game[1][2] == -1)
                || (game[2][0] == -1 && game[2][1] == -1 && game[2][2] == -1)
                || (game[0][0] == -1 && game[1][1] == -1 && game[2][2] == -1)
                || (game[0][2] == -1 && game[1][1] == -1 && game[2][0] == -1)
                || (game[0][0] == -1 && game[1][0] == -1 && game[2][0] == -1)
                || (game[0][1] == -1 && game[1][1] == -1 && game[2][1] == -1)
                || (game[0][2] == -1 && game[1][2] == -1 && game[2][2] == -1))
        {
            checker = "O";
            endGame = true;
        }
        else
            {
                checker = "y"; // to prevent return null
                endGame = false;
            }
        return checker;
    }

    public boolean checkDraw()
    {
        int counter = 0;
        boolean check = false;

        // check if all places is full then the game is finished without winner.
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if(game[i][j] == 1 || game[i][j] == -1)
                    counter++;

          if (counter == 9)
          {
              check = true;
              endGame = true;
          }
          return check;
    }

    public int[] computer()
    {
        int[] position;
        position = new int[3];
        if (player == O)
        {
            // let to play with computer
            if(!endGame)
            {
                position[0] = -3;
                position[1] = -3;
                position[2] = player;
                do {
                    position[0] = RANDOM.nextInt(3); // computer generate randomly numbers
                    position[1] = RANDOM.nextInt(3);
                    Log.d("in loop", "in loop");

                }while (game[position[0]][position[1]] != 0);
                Log.d("out loop", "out loop");
                position[2] = play(position[0], position[1]);
            }

        }
        return position;
    }
}
