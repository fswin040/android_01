package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //    private Button button;
//    private TextView view;
    private Button bt;
    private TextView loww;
    private EditText ett;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        button = (Button)findViewById(R.id.button);
//        view = (TextView)findViewById(R.id.view);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                view.setText("你的號碼"+(int)(Math.random()*49+1));
//            }

//        });
//       開始程式  //
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);
        loww = (TextView) findViewById(R.id.loww);
        answer = createAnswer(3);
        ett = (EditText) findViewById(R.id.ett);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobt();
            }
        });


    }

    private void dobt() {
        String strInput = ett.getText().toString();
        String result = checkAB(answer, strInput);
        loww.append(strInput + ":" + result + "\n");
        ett.setText("");
    }

    static String createAnswer(int n) {
        // 洗牌
        int[] poker = new int[n];
        for (int i = 0; i < poker.length; i++) {
            int temp;
            // 檢查機制
            boolean isRepeat;
            do {
                temp = (int) (Math.random() * 10);
                isRepeat = false;
                for (int j = 0; j < i; j++) {
                    if (temp == poker[j]) {
                        isRepeat = true;
                        break;
                    }
                }
            } while (isRepeat);
            poker[i] = temp;
        }
        String ret = "";
        for (int p : poker) ret += p;

        return ret;
    }

    static String checkAB(String a, String g) {
        int A, B;
        A = B = 0;
        for (int i = 0; i < g.length(); i++) {
            if (g.charAt(i) == a.charAt(i)) {
                A++;
            } else if (a.indexOf(g.charAt(i)) != -1) {
                B++;
            }
        }
        return A + "A" + B + "B";

    }
}
