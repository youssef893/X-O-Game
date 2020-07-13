package com.example.tic_tac_toc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Single extends AppCompatActivity implements DialogNewGame.DialogListner
{
    boolean check;
    private int [] position;
    int checker = 0;
    private xandO xo;
    TextView txt00, txt01,txt02,txt10,txt11,txt12,txt20,txt21,txt22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        xo = new xandO();
        position = new int[2];


        txt00 = findViewById(R.id.one);
        txt01 = findViewById(R.id.two);
        txt02 = findViewById(R.id.three);

        txt10 = findViewById(R.id.four);
        txt11 = findViewById(R.id.five);
        txt12 = findViewById(R.id.six);

        txt20 = findViewById(R.id.seven);
        txt21 = findViewById(R.id.eight);
        txt22 = findViewById(R.id.nine);

    }

    public void computer()
    {
        check = xo.isEndGame();
        if (!check)
        {
            position = xo.computer();

            if (position[0] == 0 && position[1] <= 2 && position[1] >= 0)
                setTexts();
            else if (position[0] == 1 && position[1] <= 2&& position[1] >= 0)
                setTexts1();
            else if (position[0] == 2 && position[1] <= 2&& position[1] >= 0)
                seTexts2();

            setWinner();
        }

    }

    public void setTexts()
    {
        if (position[0] == 0 && position[1] == 0)
        {
            if (!txt00.getText().equals("X") || !txt00.getText().equals("O"))
                txt00.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 0 && position[1] == 1)
        {
            if (!txt01.getText().equals("X") || !txt01.getText().equals("O"))
                txt01.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 0 && position[1] == 2)
        {
            if (!txt02.getText().equals("X") || !txt02.getText().equals("O"))
                txt02.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
    }

    public void setTexts1()
    {
        if (position[0] == 1 && position[1] == 0)
        {
            if (!txt10.getText().equals("X") || !txt10.getText().equals("O"))
                txt10.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 1 && position[1] == 1)
        {
            if (!txt11.getText().equals("X") || !txt11.getText().equals("O"))
                txt11.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 1 && position[1] == 2)
        {
            if (!txt12.getText().equals("X") || !txt12.getText().equals("O"))
                txt12.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
    }

    public void seTexts2()
    {
        if (position[0] == 2 && position[1] == 0)
        {
            if (!txt20.getText().equals("X") || !txt20.getText().equals("O"))
                txt20.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 2 && position[1] == 1)
        {
            if (!txt21.getText().equals("X") || !txt21.getText().equals("O"))
                txt21.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }
        else if (position[0] == 2 && position[1] == 2)
        {
            if (!txt22.getText().equals("X") || !txt22.getText().equals("O"))
                txt22.setText("O");
            else
            {
                Toast.makeText(this, "This square is full", Toast.LENGTH_SHORT).show();
                position = xo.computer();
                computer();
            }
        }

    }

    public void one(View view)
    {
            checker = xo.play(0, 0);
            if (checker == 1)
            {
                txt00.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void two(View view)
    {
            checker = xo.play(0,1);
            if (checker == 1)
            {
                txt01.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void three(View view)
    {
            checker = xo.play(0,2);
            if (checker == 1)
            {
                txt02.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void four(View view)
    {
            checker = xo.play(1,0);
            if (checker == 1)
            {
                txt10.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void five(View view)
    {
            checker = xo.play(1,1);
            if (checker == 1)
            {
                txt11.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void six(View view)
    {
            checker = xo.play(1,2);
            if (checker == 1)
            {
                txt12.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void seven(View view)
    {
            checker = xo.play(2,0);
            if (checker == 1)
            {
                txt20.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void eight(View view)
    {
            checker = xo.play(2,1);
            if (checker == 1)
            {
                txt21.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void nine(View view)
    {
            checker = xo.play(2,2);
            if (checker == 1)
            {
                txt22.setText("X");
                setWinner();
                if (!xo.isEndGame())
                    computer();
            }
            else if (checker == 100)
                Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
    }

    public void setWinner()
    {
        if (xo.isWinner().equals("X") || xo.isWinner().equals("O"))
            displayDialog("The Winner is "+ xo.isWinner());
        else if (xo.checkDraw())
            displayDialog("Draw");

    }

    public void displayDialog(String  winner)
    {

        DialogNewGame exampleDialog = new DialogNewGame(winner);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void startEewGame() {
        txt00.setText("");
        txt01.setText("");
        txt02.setText("");

        txt10.setText("");
        txt11.setText("");
        txt12.setText("");

        txt20.setText("");
        txt21.setText("");
        txt22.setText("");

        xo = new xandO();

    }


    @Override
    public void endGame() {
        startActivity(new Intent(Single.this, MainActivity.class));
    }
}