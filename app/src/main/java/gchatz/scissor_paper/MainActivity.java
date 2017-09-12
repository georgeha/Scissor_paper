package gchatz.scissor_paper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int achoice;

    HashMap<Integer,String>  choices = new HashMap<>();



    /*
      0 : paper
      1: scissors
      2: rock

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choices.put(0,"Paper");
        choices.put(1,"Scissors");
        choices.put(2,"Rock");

        setChoice();

    }


    public  void setChoice(){
        Random rand= new Random();

        achoice =rand.nextInt(3);

    }

    public void onClickPapper(View view){

        // Paper wins rock and loses from  scissors
        if  (choices.get(achoice).equals("Rock") ) {
            Toast.makeText(this, "You won the Rock!", Toast.LENGTH_SHORT).show();
        }
        else if (achoice==1) {
            Toast.makeText(this, "You lost from the Scissors!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"AI chose Paper, it's a Draw!",Toast.LENGTH_SHORT).show();

        }
        setChoice();


    }

    public void onClickRock(View view){

        // Rock wins Scissors and loses from  paper
        if  (achoice==1) {
            Toast.makeText(this, "You won the Scissors!", Toast.LENGTH_SHORT).show();
        }
        else if (achoice==0) {
            Toast.makeText(view.getContext(), "You lost from the Paper!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(view.getContext(),"AI chose Rock, it's a Draw!",Toast.LENGTH_SHORT).show();

        }
        setChoice();


    }

    public void onClickScissors(View view){

        // Scissors wins Paper and loses from  Rock
        if  (achoice==0) {
            Toast.makeText(this, "You won the Paper!", Toast.LENGTH_SHORT).show();
        }
        else if (achoice==2) {
            Toast.makeText(this, "You lost from the Rock!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"AI chose Scissors, it's a Draw!",Toast.LENGTH_SHORT).show();

        }
        setChoice();


    }






}




