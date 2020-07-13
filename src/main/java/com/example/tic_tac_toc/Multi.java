package com.example.tic_tac_toc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Multi extends AppCompatActivity implements DialogNewGame.DialogListner
{

    private int checker = 0;
    private xandO xo;
    TextView first1, first2,first3,second1,second2,second3,third1,third2,third3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        xo = new xandO();

        first1 = findViewById(R.id.firstfirst);
        first2 = findViewById(R.id.firstsecond);
        first3 = findViewById(R.id.firstthird);

        second1 = findViewById(R.id.secondfirst);
        second2 = findViewById(R.id.secondsecond);
        second3 = findViewById(R.id.secondthird);

        third1 = findViewById(R.id.thirdfirst);
        third2 = findViewById(R.id.thirdsecond);
        third3 = findViewById(R.id.thirdthird);

    }

    public void firstfirst(View view)
    {
        checker = xo.play(0,0);
        if (checker == 1)
            first1.setText("X");
        else if(checker == -1)
            first1.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();

    }

    public void firstsecond(View view)
    {
        checker = xo.play(0,1);
        if (checker == 1)
            first2.setText("X");
        else if(checker == -1)
            first2.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();
    }

    public void firstthird(View view)
    {
       checker = xo.play(0,2);
        if (checker == 1)
            first3.setText("X");
        else if(checker == -1)
            first3.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

       setWinner();
    }

    public void secondfirst(View view)
    {
       checker = xo.play(1,0);
        if (checker == 1)
            second1.setText("X");
        else if(checker == -1)
            second1.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();
    }

    public void secondsecond(View view)
    {
       checker = xo.play(1,1);
        if (checker == 1)
            second2.setText("X");
        else if(checker == -1)
            second2.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();
    }

    public void secondthird(View view)
    {
       checker = xo.play(1,2);
        if (checker == 1)
            second3.setText("X");
        else if(checker == -1)
            second3.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();
    }

    public void thirdfirst(View view)
    {
        checker = xo.play(2,0);
        if (checker == 1)
            third1.setText("X");
        else if(checker == -1)
            third1.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();
    }

    public void thirdsecond(View view)
    {
       checker = xo.play(2,1);
        if (checker == 1)
            third2.setText("X");
        else if(checker == -1)
            third2.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();
        setWinner();
    }

    public void thirdthird(View view)
    {
        checker = xo.play(2,2);
        if (checker == 1)
            third3.setText("X");
        else if(checker == -1)
            third3.setText("O");
        else if (checker == 100)
            Toast.makeText(this, "This is square is full", Toast.LENGTH_SHORT).show();

        setWinner();

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
        first1.setText("");
        first2.setText("");
        first3.setText("");

        second1.setText("");
        second2.setText("");
        second3.setText("");

        third1.setText("");
        third2.setText("");
        third3.setText("");

        xo.newGame();
    }

    @Override
    public void endGame() {
        startActivity(new Intent(Multi.this, MainActivity.class));
    }
}