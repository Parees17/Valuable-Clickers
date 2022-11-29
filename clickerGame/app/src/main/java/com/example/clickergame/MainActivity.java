package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity {

    private Button start, pause, resume,openingscreenbutton,powerUpStoreBtn,tntReducerBtn,pointsMultBn,timeAddBtn,playNxtLvlBtn;
    TextView timer;
    TextView score,targetScoreDisplay,resultScreenUserScore, resultScreenTargetScore,
            resultMessage,resultGemCount,timeAddPrice,timeAddLevel,pointsMultPrice,ptsMultLvl,
            tntReducerPrice, tntReducerLvl,powerUpStoreIntro, powerUpStoreGems;
    ImageView diamond,ruby,gold,emerald,tnt,dirt_one,dirt_two,dirt_three,
            star_one,star_two,star_three,star_four,wood_one,wood_two,wood_three;
    EditText pointsMutDescrp, timeAddDescrp, tntReduceDescrp;
    private boolean isPaused = false;
    private boolean isCanceled = false;
    private ConstraintLayout background; //this is the declaration of the id for the screen
    private ConstraintLayout.LayoutParams layoutParams; //this is the declaration of the layout that will be used for the dimensions of the ImageView
    private long timeRemaining = 0;
    private int targetScore = 200;
    private int playerScore = 0;
    private int playerLevel = 1;
    private int timeAddPriceVal = 100;
    private int pointsMultPriceVal = 150;
    private int tntReducePriceVal = 150;
    private int timeAddLvlVal = 0;
    private int pointsMultLvlVal = 0;
    private int tntReduceLvlVal = 0;
    int gems = 0;
    Valuable diamondVal = new Valuable("diamond", 50.0,3);
    Valuable goldVal = new Valuable("gold", 30.0,6);
    Valuable rubyVal = new Valuable("ruby", 20.0,5);
    Valuable emeraldVal = new Valuable("emerald", 40.0, 4);

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diamond = findViewById(R.id.imgDiamond);
        ruby = findViewById(R.id.imgRuby);
        gold = findViewById(R.id.imgGold);
        emerald = findViewById(R.id.imgEmerald);
        score = findViewById(R.id.textView);
        timer = (TextView) findViewById(R.id.timer);
        start = findViewById(R.id.start);
        resume = findViewById(R.id.resume);
        pause = findViewById(R.id.pause);
        dirt_one = findViewById(R.id.dirt_one);
        dirt_two = findViewById(R.id.dirt_two);
        dirt_three = findViewById(R.id.dirt_three);
        openingscreenbutton = findViewById(R.id.opening_screen_button);
        targetScoreDisplay = findViewById(R.id.textView2);
        powerUpStoreBtn = findViewById(R.id.powerUpStoreBtn);
        star_one = findViewById(R.id.star_one);
        star_two = findViewById(R.id.star_two);
        star_three = findViewById(R.id.star_three);
        star_four = findViewById(R.id.star_four);
        resultScreenTargetScore  = findViewById(R.id.resultScrnDisplayTarget);
        resultScreenUserScore = findViewById(R.id.resultScrnUserScore);
        resultGemCount = findViewById(R.id.resultGemCount);
        resultMessage = findViewById(R.id.resultMessages);

        tntReducerBtn = findViewById(R.id.buy_tntreducer);
        pointsMultBn = findViewById(R.id.buy_pointsmult);
        timeAddBtn = findViewById(R.id.buy_timebender);
        playNxtLvlBtn = findViewById(R.id.playNxtLevel);
        timeAddDescrp = findViewById(R.id.timeAddDes);
        pointsMutDescrp = findViewById(R.id.ptsMultDes);
        tntReduceDescrp = findViewById(R.id.tntReducDes);
        timeAddLevel = findViewById(R.id.level_timebender);
        timeAddPrice = findViewById(R.id.timebender_price);
        pointsMultPrice = findViewById(R.id.price_pointsmultiplier);
        ptsMultLvl = findViewById(R.id.level_pointsmultiplier);
        tntReducerLvl = findViewById(R.id.tntreducer_level);
        tntReducerPrice = findViewById(R.id.tntreducer_price);
        powerUpStoreIntro= findViewById(R.id.powerupintro);
        powerUpStoreGems = findViewById(R.id.gem_count_powerup);
        wood_one = findViewById(R.id.wood_one);
        wood_two = findViewById(R.id.wood_two);
        wood_three = findViewById(R.id.wood_three);
        background = findViewById(R.id.background); //Initializing the id for the screen
        layoutParams = new ConstraintLayout.LayoutParams(75,75); //initializing the layout for the ImageView. Width and height of ImageView are both 75 pixels

        openingscreenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diamond.setVisibility(View.VISIBLE);
                ruby.setVisibility(View.VISIBLE);
                gold.setVisibility(View.VISIBLE);
                emerald.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
                resume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                targetScoreDisplay.setVisibility(View.VISIBLE);
                dirt_one.setVisibility(View.VISIBLE);
                dirt_two.setVisibility(View.VISIBLE);
                dirt_three.setVisibility(View.VISIBLE);
                openingscreenbutton.setVisibility(View.INVISIBLE);

            }
        });

        playNxtLvlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timeAddBtn.setVisibility(View.INVISIBLE);
                pointsMultBn.setVisibility(View.INVISIBLE);
                pointsMutDescrp.setVisibility(View.INVISIBLE);
                pointsMultPrice.setVisibility(View.INVISIBLE);
                timeAddDescrp.setVisibility(View.INVISIBLE);
                timeAddPrice.setVisibility(View.INVISIBLE);
                timeAddLevel.setVisibility(View.INVISIBLE);
                tntReducerBtn.setVisibility(View.INVISIBLE);
                tntReducerPrice.setVisibility(View.INVISIBLE);
                tntReducerLvl.setVisibility(View.INVISIBLE);
                tntReduceDescrp.setVisibility(View.INVISIBLE);
                powerUpStoreGems.setVisibility(View.INVISIBLE);
                powerUpStoreBtn.setVisibility(View.INVISIBLE);
                powerUpStoreIntro.setVisibility(View.INVISIBLE);
                playNxtLvlBtn.setVisibility(View.INVISIBLE);
                wood_one.setVisibility(View.INVISIBLE);
                wood_two.setVisibility(View.INVISIBLE);
                wood_three.setVisibility(View.INVISIBLE);
                diamond.setVisibility(View.VISIBLE);
                ruby.setVisibility(View.VISIBLE);
                gold.setVisibility(View.VISIBLE);
                emerald.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
                resume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                targetScoreDisplay.setVisibility(View.VISIBLE);
                dirt_one.setVisibility(View.VISIBLE);
                dirt_two.setVisibility(View.VISIBLE);
                dirt_three.setVisibility(View.VISIBLE);
                playerScore = 0;
                targetScore +=100;

            }
        });

        powerUpStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                timeAddBtn.setVisibility(View.VISIBLE);
                pointsMultBn.setVisibility(View.VISIBLE);
                pointsMutDescrp.setVisibility(View.VISIBLE);
                pointsMultPrice.setVisibility(View.VISIBLE);
                timeAddDescrp.setVisibility(View.VISIBLE);
                timeAddPrice.setVisibility(View.VISIBLE);
                timeAddLevel.setVisibility(View.VISIBLE);
                tntReducerBtn.setVisibility(View.VISIBLE);
                tntReducerPrice.setVisibility(View.VISIBLE);
                tntReducerLvl.setVisibility(View.VISIBLE);
                tntReduceDescrp.setVisibility(View.VISIBLE);
                powerUpStoreGems.setVisibility(View.VISIBLE);
                powerUpStoreGems.setText("Gems: " + gems);
                powerUpStoreBtn.setVisibility(View.VISIBLE);
                powerUpStoreIntro.setVisibility(View.VISIBLE);
                playNxtLvlBtn.setVisibility(View.VISIBLE);
                wood_one.setVisibility(View.VISIBLE);
                wood_two.setVisibility(View.VISIBLE);
                wood_three.setVisibility(View.VISIBLE);
                powerUpStoreBtn.setVisibility(View.INVISIBLE);
                resultScreenTargetScore.setVisibility(View.INVISIBLE);
                resultScreenUserScore.setVisibility(View.INVISIBLE);
                resultMessage.setVisibility(View.INVISIBLE);
                resultGemCount.setVisibility(View.INVISIBLE);
                star_four.setVisibility(View.INVISIBLE);
                star_one.setVisibility(View.INVISIBLE);
                star_two.setVisibility(View.INVISIBLE);
                star_three.setVisibility(View.INVISIBLE);

            }
        });

        pointsMultBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pointsMultPriceVal < gems){

                    diamondVal.setValue(diamondVal.getValue() * 1.5);
                    rubyVal.setValue(rubyVal.getValue() * 1.5);
                    emeraldVal.setValue(emeraldVal.getValue() * 1.5);
                    goldVal.setValue(goldVal.getValue() * 1.5);
                    gems -= pointsMultPriceVal;
                    powerUpStoreGems.setText("Gems: " + gems);
                    pointsMultPriceVal += 100;
                    pointsMultLvlVal ++;

                }
            }
        });

        timeAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (timeAddPriceVal < gems){

                    diamondVal.setValue(diamondVal.getValue() * 1.5);
                    rubyVal.setValue(rubyVal.getValue() * 1.5);
                    emeraldVal.setValue(emeraldVal.getValue() * 1.5);
                    goldVal.setValue(goldVal.getValue() * 1.5);
                    gems -= pointsMultPriceVal;
                    powerUpStoreGems.setText("Gems: " + gems);
                    timeAddPriceVal += 100;
                    timeAddLvlVal ++;

                }
            }
        });

        diamond.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                playerScore += diamondVal.getValue();
                score.setText("Score: " + playerScore);
                diamond.setVisibility(View.INVISIBLE);

            }
        });

        ruby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                playerScore += rubyVal.getValue();
                score.setText("Score: " + playerScore);
                ruby.setVisibility(View.INVISIBLE);
            }
        });

        emerald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                playerScore += emeraldVal.getValue();
                score.setText("Score: " + playerScore);
                emerald.setVisibility(View.INVISIBLE);

            }
        });

        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerScore += goldVal.getValue();
                score.setText("Score: " + playerScore);
                gold.setVisibility(View.INVISIBLE);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountDownTimer();
            }
        });
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeCountDownTimer();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseCountDownTimer();
            }
        });

        playNxtLvlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                score.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
                resume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                targetScoreDisplay.setVisibility(View.VISIBLE);
                dirt_one.setVisibility(View.VISIBLE);
                dirt_two.setVisibility(View.VISIBLE);
                dirt_three.setVisibility(View.VISIBLE);
                timeAddBtn.setVisibility(View.INVISIBLE);
                pointsMultBn.setVisibility(View.INVISIBLE);
                pointsMutDescrp.setVisibility(View.INVISIBLE);
                pointsMultPrice.setVisibility(View.INVISIBLE);
                timeAddDescrp.setVisibility(View.INVISIBLE);
                timeAddPrice.setVisibility(View.INVISIBLE);
                timeAddLevel.setVisibility(View.INVISIBLE);
                tntReducerBtn.setVisibility(View.INVISIBLE);
                tntReducerPrice.setVisibility(View.INVISIBLE);
                tntReducerLvl.setVisibility(View.INVISIBLE);
                tntReduceDescrp.setVisibility(View.INVISIBLE);
                powerUpStoreGems.setVisibility(View.INVISIBLE);
                powerUpStoreBtn.setVisibility(View.INVISIBLE);
                powerUpStoreIntro.setVisibility(View.INVISIBLE);
                diamond.setVisibility(View.VISIBLE);
                ruby.setVisibility(View.VISIBLE);
                gold.setVisibility(View.VISIBLE);
                emerald.setVisibility(View.VISIBLE);

            }
        });

    }

    public void pauseCountDownTimer() {
        isPaused = true;
        resume.setEnabled(true);
        start.setEnabled(false);
        pause.setEnabled(false);
    }

    public void resumeCountDownTimer() {
        isPaused = false;
        isCanceled = false;
        start.setEnabled(false);
        resume.setEnabled(false);
        pause.setEnabled(true);

        //start a new CountDownTimer instance with time remaining as millisInFuture
        new CountDownTimer(timeRemaining, 100) {
            public void onTick(long millisUntilFinished) {
                if (isPaused || isCanceled) {
                    // runs If user requested to pause or cancel the count down timer
                    cancel();
                } else {
                    timer.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                    if ((timeRemaining/1000) % diamondVal.getTimeInterval() == 0){
                        changeImageLocation(diamond);
                    }
                    if ((timeRemaining/1000) % emeraldVal.getTimeInterval() == 0){
                        changeImageLocation(emerald);

                    }
                    if ((timeRemaining/1000) % rubyVal.getTimeInterval() == 0){
                        changeImageLocation(ruby);
                    }
                    if ((timeRemaining/1000) % goldVal.getTimeInterval() == 0){
                        changeImageLocation(gold);
                    }
                }
            }

            public void onFinish() {
                //Do something when count down finished
                timer.setText("Done");
                pause.setEnabled(false);
                resume.setEnabled(false);
                start.setEnabled(true);
                if (playerScore >= targetScore){

                    playerLevel++;
                    gems += (100 * playerLevel) + ((playerScore - targetScore) * 0.5);
                    score.setText("Score: " + playerScore);
                }
                powerUpStoreBtn.setVisibility(View.VISIBLE);
                resultScreen();
            }
        }.start();
    }

    public void resultScreen(){

        leaveGameScreen();
        resultScreenTargetScore.setVisibility(View.VISIBLE);
        resultScreenUserScore.setVisibility(View.VISIBLE);
        resultMessage.setVisibility(View.VISIBLE);
        resultGemCount.setVisibility(View.VISIBLE);
        resultScreenTargetScore.setText(" Target Score: " + targetScore);
        resultScreenUserScore.setText("Your Score! : " + playerScore);
        resultGemCount.setText("Gems: " + gems);
        star_four.setVisibility(View.VISIBLE);
        star_one.setVisibility(View.VISIBLE);
        star_two.setVisibility(View.VISIBLE);
        star_three.setVisibility(View.VISIBLE);

    }


    public void leaveGameScreen(){
        diamond.setVisibility(View.INVISIBLE);
        ruby.setVisibility(View.INVISIBLE);
        gold.setVisibility(View.INVISIBLE);
        emerald.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        start.setVisibility(View.INVISIBLE);
        resume.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.INVISIBLE);
        targetScoreDisplay.setVisibility(View.INVISIBLE);
        dirt_one.setVisibility(View.INVISIBLE);
        dirt_two.setVisibility(View.INVISIBLE);
        dirt_three.setVisibility(View.INVISIBLE);
    }

    public void startCountDownTimer() {

        targetScoreDisplay.setText("Target Score: " + targetScore);
        isPaused = false;
        isCanceled = false;
        start.setEnabled(false);
        resume.setEnabled(false);
        pause.setEnabled(true);


        // countDownInterval: how often onTick is called, so 2000ms = onTick called every 2 second
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (isPaused || isCanceled) {
                    // runs if the user requests to cancel or paused the CountDownTimer-- cancels the current instance
                    cancel();
                } else {
                    //Display the remaining seconds to app interface + 1 second = 1000 milliseconds
                    timer.setText("" + millisUntilFinished / 1000);

                    //Put remaining time in a variable in order to start new timer with previous state for pause
                    timeRemaining = millisUntilFinished;
                    System.out.println(timeRemaining/1000);
                    if ((timeRemaining/1000) % diamondVal.getTimeInterval() == 0){
                        changeImageLocation(diamond);
                    }
                    if ((timeRemaining/1000) % emeraldVal.getTimeInterval() == 0){
                        changeImageLocation(emerald);

                    }
                    if ((timeRemaining/1000) % rubyVal.getTimeInterval() == 0){
                        changeImageLocation(ruby);
                    }
                    if ((timeRemaining/1000) % goldVal.getTimeInterval() == 0){
                        changeImageLocation(gold);
                    }
                }
            }

            public void onFinish() {
                //Do something when count down finished
                timer.setText("Done");
                start.setEnabled(true);
                pause.setEnabled(false);
                resume.setEnabled(false);
                if (playerScore >= targetScore){

                    playerLevel++;
                    gems += (100 * playerLevel) + ((playerScore - targetScore) * 0.5);
                    resultMessage.setText(" Great Job On the Victory!");
                } else{
                    resultMessage.setText("Good try, give it another shot!");
                }

                powerUpStoreBtn.setVisibility(View.VISIBLE);
                resultScreen();
            }
        }.start();

    }

    //this button will create a new ImageView with random x and y coordinates
    public void changeImageLocation(ImageView tempImage){

        if (tempImage.equals(diamond)){
            diamond.setLayoutParams(layoutParams);
            diamond.setX(getRNum(0,background.getWidth()-layoutParams.width));
            diamond.setY(getRNum(0,background.getHeight()-layoutParams.height));
            diamond.setVisibility(View.VISIBLE);
        }

        if (tempImage.equals(gold)){
            gold.setLayoutParams(layoutParams);
            gold.setX(getRNum(0,background.getWidth()-layoutParams.width));
            gold.setY(getRNum(0,background.getHeight()-layoutParams.height));
            gold.setVisibility(View.VISIBLE);
        }

        if (tempImage.equals(ruby)){
            ruby.setLayoutParams(layoutParams);
            ruby.setX(getRNum(0,background.getWidth()-layoutParams.width));
            ruby.setY(getRNum(0,background.getHeight()-layoutParams.height));
            ruby.setVisibility(View.VISIBLE);
        }

        if (tempImage.equals(emerald)){
            emerald.setLayoutParams(layoutParams);
            emerald.setX(getRNum(0,background.getWidth()-layoutParams.width));
            emerald.setY(getRNum(0,background.getHeight()-layoutParams.height));
            emerald.setVisibility(View.VISIBLE);

        }


    }

    //gets a random number between bound1 and bound2
    public int getRNum(int bound1, int bound2){
        return (int) Math.floor(Math.random()*(bound2 - bound1 + 1))+bound1;
    }
}
