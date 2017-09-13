package gchatz.scissor_paper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
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
        setChoices();
        setSpinner();




        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                String player = (String) adapterView.getItemAtPosition(pos);
                String AI = choices.get(achoice);
                if (pos!=0) {
                    //prepare toast
                    Toast toast = new Toast(getBaseContext());
                    LinearLayout toastLayout = new LinearLayout(getBaseContext());
                    toastLayout.setOrientation(LinearLayout.VERTICAL);
                    ImageView paperIm = new ImageView(getBaseContext());
                    TextView text = new TextView(getBaseContext());

                    if (player.equals("Rock")) {

                        if (AI.equals("Paper")) {

                        /*Toast toast = new Toast(getBaseContext());
                        LinearLayout toastLayout = new LinearLayout(getBaseContext());
                        toastLayout.setOrientation(LinearLayout.VERTICAL);
                        ImageView paperIm = new ImageView(getBaseContext());
                        TextView text = new TextView(getBaseContext());
                        */

                            text.setText("AI chose " + AI + "  and Won!");
                            paperIm.setImageResource(R.drawable.paper);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();


                        } else if (AI.equals("Scissors")) {

                            //Toast.makeText(getBaseContext(),"You  Won! ",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + "  and Lost!");
                            paperIm.setImageResource(R.drawable.scissors);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            //Toast.makeText(getBaseContext(),"AI chose " + AI +" too, it's a Draw!",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + " too, it's a Draw!");
                            paperIm.setImageResource(R.drawable.therock);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else if (player.equals("Paper")) {

                        if (AI.equals("Scissors")) {
                            //Toast.makeText(getBaseContext(),"AI chose " + AI +"  and Won!",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + "  and Won!");
                            paperIm.setImageResource(R.drawable.scissors);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();

                        } else if (AI.equals("Rock")) {
                            // Toast.makeText(getBaseContext(),"You  Won!",Toast.LENGTH_SHORT).show();

                            text.setText("You  Won!");
                            paperIm.setImageResource(R.drawable.therock);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            //  Toast.makeText(getBaseContext(),"AI chose " + AI +" too, it's a Draw!",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + " too, it's a Draw!");
                            paperIm.setImageResource(R.drawable.paper);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();

                        }


                    } else {  // player chose Scissors

                        if (AI.equals("Rock")) {
                            // Toast.makeText(getBaseContext(),"AI chose " + AI +"  and Won!",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + "  and Won!");
                            paperIm.setImageResource(R.drawable.therock);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        } else if (AI.equals("Paper")) {
                            //  Toast.makeText(getBaseContext(),"You  Won!",Toast.LENGTH_SHORT).show();

                            text.setText("You  Won!");
                            paperIm.setImageResource(R.drawable.paperlost);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            //  Toast.makeText(getBaseContext(),"AI chose " + AI +" too, it's a Draw!",Toast.LENGTH_SHORT).show();

                            text.setText("AI chose " + AI + " too, it's a Draw!");
                            paperIm.setImageResource(R.drawable.scissors);
                            toastLayout.addView(paperIm);
                            toastLayout.addView(text);
                            toast.setView(toastLayout);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                    setChoice();
                    spinner.setSelection(0);  // reset spinner
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Another interface callback


            }
        });


    }


    public  void setChoice(){
        Random rand= new Random();
        achoice =rand.nextInt(3);

    }

    private void setChoices(){
        choices.put(0,"Paper");
        choices.put(1,"Scissors");
        choices.put(2,"Rock");

    }




    public void setSpinner(){

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choices_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
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




