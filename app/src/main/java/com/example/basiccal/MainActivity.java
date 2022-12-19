package com.example.basiccal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    volatile Boolean operatorClicked=false;
    volatile Boolean equalClicked=false;
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
        this.operatorClicked=false;
        this.equalClicked=false;
        this.currentText=null;
    }

    public void functionKeyPress(View view){
        currentTextView= findViewById(R.id.textView);
        currentText =currentTextView.getText().toString();

            switch (view.getId()){
                case R.id.btn_clear:
                    clear();
                    break;
                case R.id.btn_backspace:
                    if (currentText.equals("0")||currentText.equals("-")||currentText.length()==1){
                        currentTextView.setText("0");
                    }
                    else {
                        currentTextView.setText(currentText.substring(0,(currentText.length()-1)));
                    }
                    break;
                case R.id.btn_history:


                    break;

            }
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

    public void mathKeyPress(View view){
        currentTextView= findViewById(R.id.textView);
        currentText =currentTextView.getText().toString();

            switch (view.getId()){

                case R.id.btn_multiply:
                    if(!operatorClicked&&!equalClicked&&answer!=null){
                        answer=cal(answer,Float.valueOf(currentText));
                    }else{
                        answer=Float.valueOf(currentText);
                    }
                    mathOperator="*";
                    operatorClicked=true;
                    equalClicked=false;
                    writeToTextView(answer);
                    break;
                case R.id.btn_divide:
                    if(!operatorClicked&&!equalClicked&&answer!=null){
                        answer=cal(answer,Float.valueOf(currentText));
                    }else{
                        answer=Float.valueOf(currentText);
                    }
                    mathOperator="/";
                    operatorClicked=true;
                    equalClicked=false;
                    writeToTextView(answer);

                    break;
                case R.id.btn_plus:
                    if(!operatorClicked&&!equalClicked&&answer!=null){
                        answer=cal(answer,Float.valueOf(currentText));
                    }else{
                        answer=Float.valueOf(currentText);
                    }
                    mathOperator="+";
                    operatorClicked=true;
                    equalClicked=false;
                    writeToTextView(answer);
                    break;
                case R.id.btn_minus:
                    if(!operatorClicked&&!equalClicked&&answer!=null){
                        answer=cal(answer,Float.valueOf(currentText));
                    }else{
                        answer=Float.valueOf(currentText);
                    }
                    mathOperator="-";
                    operatorClicked=true;
                    equalClicked=false;
                    writeToTextView(answer);
                    break;
                case R.id.btn_equal:
                    if(answer==null&&!operatorClicked){
                        answer= Float.valueOf(currentText);
                    }
                    if(!operatorClicked&&!equalClicked){
                        operand_1=Float.valueOf(currentText);
                        operatorClicked=false;
                    }
                    if (!equalClicked){
                        answer=cal(answer,Float.valueOf(currentText));
                    }else{

                        answer=cal(answer,operand_1);
                    }
                    equalClicked=true;
                    writeToTextView(answer);
                    break;

            }

    }

    public void numberKeyPress(View view){
        currentTextView= findViewById(R.id.textView);
        currentText =currentTextView.getText().toString();

            switch (view.getId()){
                case R.id.btn_0:
                    if (!currentText.equals("0")&&!operatorClicked&&!equalClicked){
                        currentTextView.append("0");
                    }else {currentTextView.setText("0");}
                    operatorClicked=false;
                    equalClicked=false;
                    break;
                case R.id.btn_plusminus:
                    if (Float.valueOf(currentText)>0){
                        currentTextView.setText("-"+currentText);
                    }
                    if (Float.valueOf(currentText)<0){
                        currentTextView.setText(currentText.substring(1));
                    }
                    operatorClicked=false;
                    equalClicked=false;
                    break;
                case R.id.btn_dot:
                    if(!equalClicked&&!operatorClicked&&!currentText.contains(".")) {
                        currentTextView.append(".");
                    }
                    if(operatorClicked||equalClicked) {
                        currentTextView.setText("0.");
                    }
                    operatorClicked=false;
                    equalClicked=false;
                    break;
                default:
                    if (currentText.equals("0")||operatorClicked||equalClicked){
                        currentTextView.setText(view.getTag().toString());
                    }
                    else {
                        currentTextView.append(view.getTag().toString());
                    }
                    operatorClicked=false;
                    equalClicked=false;
                    break;

            }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}