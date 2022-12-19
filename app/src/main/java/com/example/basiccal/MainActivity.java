package com.example.basiccal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    volatile String mathOperator=null;
    volatile Float answer=null;
    volatile Float operand_1=null;
    TextView currentTextView ;
    volatile String  currentText;
    volatile boolean error=false;

    public void sleep(Long mili){
        try{
            Thread.sleep(mili);
        }catch (Exception e){}
    }

    public void writeToTextView(Float answer){

        try {
            if(answer.equals(Float.valueOf("Infinity"))){
                currentTextView.setText(String.valueOf(answer));
                error=true;
            }
            if(answer.intValue()==answer){
                currentTextView.setText(String.valueOf(answer.intValue()));
            }else{
                currentTextView.setText(String.valueOf(answer));
            }


        } catch (Exception e){currentTextView.setText(String.valueOf(answer));}
    }

    public void clear(){
        this.currentTextView.setText("0");
        this.mathOperator=null;
        this.operand_1=null;
        this.answer=null;
        this.currentText=null;
    }



    public Float cal(Float n1, Float n2) {
        if (mathOperator != null) {
            switch (String.valueOf(mathOperator)) {
                case "+":
                    return n1 + n2;
                case "-":
                    return n1 - n2;
                case "*":
                    return n1 * n2;
                case "/":
                    return n1 / n2;
            }
        }return answer;
    }



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
                    if(!currentText.contains(".")) {
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