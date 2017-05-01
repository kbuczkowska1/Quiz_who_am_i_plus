package com.example.android.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    //This method plays an audio clip of the dog sound.
    public void play1(View view) {

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.dog);

        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }

    //This method plays an audio clip of the cat sound.
    public void play2(View view) {

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.cat);

        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }

    //This method plays an audio clip of the pig sound.
    public void play3(View view) {

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.pig);

        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }

    // This method plays an audio clip of the sheep sound.
    public void play4(View view) {

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.sheep);

        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // show Toast.
    public void score(View view) {

        RadioButton correct1 = (RadioButton) findViewById(R.id.cat_radio_button);
        boolean dog_Correct = correct1.isChecked();

        RadioButton correct2 = (RadioButton) findViewById(R.id.dog2_radio_button);
        boolean cat_Correct = correct2.isChecked();

        RadioButton correct3 = (RadioButton) findViewById(R.id.pig3_radio_button);
        boolean pig_Correct = correct3.isChecked();

        RadioButton correct4 = (RadioButton) findViewById(R.id.sheep4_radio_button);
        boolean sheep_Correct = correct4.isChecked();

        CheckBox correct5 = (CheckBox) findViewById(R.id.checkbox1);
        boolean carrot_Correct = correct5.isChecked();
        CheckBox correct6 = (CheckBox) findViewById(R.id.checkbox3);
        boolean grass_Correct = correct6.isChecked();

        EditText checkEditText = (EditText) findViewById(R.id.cow);
        String cow_Correct = checkEditText.getText().toString();

        showFinalResult(calculateResult(dog_Correct, cat_Correct, pig_Correct, sheep_Correct, carrot_Correct, grass_Correct, cow_Correct));
    }

    // Toast message.
    public void showFinalResult(int result) {
        int totalResult = 7;
        if (result == 0) {
            CharSequence text = getString(R.string.resultFinal) + result + "/" + totalResult;
            text = text + "\n" + getString(R.string.zero);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
        if (result <= 2) {
            CharSequence text = getString(R.string.resultFinal) + result + "/" + totalResult;
            text = text + "\n" + getString(R.string.lowResult);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
        if ((result <= 4)) {
            CharSequence text = getString(R.string.resultFinal) + result + "/" + totalResult;
            text = text + "\n" + getString(R.string.medResult);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
        if (result <= 6) {
            CharSequence text = getString(R.string.resultFinal) + result + "/" + totalResult;
            text = text + "\n" + getString(R.string.almostResult);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
        if (result == 7) {
            CharSequence text = getString(R.string.resultFinal) + result + "/" + totalResult;
            text = text + "\n" + getString(R.string.wellDoneResult);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
    }

    // calculateResult is used to calculate the final result of the user depending on whether or not they selected the correct answers
    private int calculateResult(boolean dog, boolean cat, boolean pig, boolean sheep, boolean carrot, boolean grass, String cow) {

        int final_result = 0;

        if (cow.equals("cow") || cow.equals("Cow") || cow.equals("COW"))

        {
            final_result += 1;
        }

        if (dog) {
            final_result += 1;
        }

        if (cat) {
            final_result += 1;
        }

        if (pig) {
            final_result += 1;
        }

        if (sheep) {
            final_result += 1;
        }
        if (carrot) {
            final_result += 1;
        }
        if (grass) {
            final_result += 1;
        }

        return final_result;
    }

    // It resets and returns to the start window.
    public void playAgain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    // Return to the previous activity.
    public void Back(View v) {
        startActivity(new Intent(Main2Activity.this, MainActivity.class));

    }
}

