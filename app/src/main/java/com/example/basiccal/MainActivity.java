package com.example.basiccal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    TextView currentTextView ;
    volatile String  currentText;
   











    public void numberKeyPress(View view){
        currentTextView= findViewById(R.id.textView);
        currentText =currentTextView.getText().toString();

            switch (view.getId()){
                case R.id.btn_0:
                    if (!currentText.equals("0")){
                        currentTextView.append("0");
                    }else {currentTextView.setText("0");}

                    break;
                case R.id.btn_plusminus:
                    if (Float.valueOf(currentText)>0){
                        currentTextView.setText("-"+currentText);
                    }
                    if (Float.valueOf(currentText)<0){
                        currentTextView.setText(currentText.substring(1));
                    }

                    break;
                case R.id.btn_dot:
                    if(currentText.contains(".")) {
                        currentTextView.append(".");
                    }

                    break;
                default:
                    if (currentText.equals("0")){
                        currentTextView.setText(view.getTag().toString());
                    }
                    else {
                        currentTextView.append(view.getTag().toString());
                    }

                    break;

            }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}