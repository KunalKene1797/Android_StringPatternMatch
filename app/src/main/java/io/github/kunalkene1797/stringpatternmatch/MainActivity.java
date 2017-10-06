package io.github.kunalkene1797.stringpatternmatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    Button chkbtn;
    EditText sone,stwo;
    TextView rslt;
    String a = null;
    String b = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkbtn = (Button)findViewById(R.id.chkbtn);
        sone = (EditText)findViewById(R.id.sone);
        stwo = (EditText)findViewById(R.id.stwo);
        rslt = (TextView)findViewById(R.id.rslt);
        rslt.setText("Result will Appear Here!");
        chkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = sone.getText().toString();
                b = stwo.getText().toString();
                if(strpattern(a,b)){
                    rslt.setTextColor(getResources().getColor(R.color.green));
                    rslt.setText("Strings Show a Pattern");
                    YoYo.with(Techniques.Bounce).duration(700).playOn(findViewById(R.id.sone));
                    YoYo.with(Techniques.Bounce).duration(700).playOn(findViewById(R.id.stwo));
                }else{
                    if(sone.length()==0 || stwo.length()==0){
                        rslt.setTextColor(getResources().getColor(R.color.red));
                        rslt.setText("Stop Being Lazy! Type Something!");
                        YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.sone));
                        YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.stwo));
                    }else if(rslt.getText()==""){
                        rslt.setTextColor(getResources().getColor(R.color.red));
                        rslt.setText("Strings Don't Have A Pattern!");
                        YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.sone));
                        YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.stwo));
                    }
                }
            }
        });
    }
    public boolean strpattern(String a, String b){
        boolean match=false,sizeequal;
        rslt.setText("");
        sizeequal = a.length() == b.length();
        if(sizeequal){
            for (int i = 0; i < a.length() ; i++) {
                if(a.charAt(i)==b.charAt(i) || a.charAt(i)=='?' || b.charAt(i)=='?' || a.charAt(i)=='*' || b.charAt(i)=='*'){
                    match = true;
                }else{
                    match = false;
                    break;
                }
            }
        }else {
            rslt.setTextColor(getResources().getColor(R.color.red));
            rslt.setText("Error: String Lenght Should Be The Same!");
            YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.sone));
            YoYo.with(Techniques.Shake).duration(700).playOn(findViewById(R.id.stwo));
        }
        return match;
    }
}
