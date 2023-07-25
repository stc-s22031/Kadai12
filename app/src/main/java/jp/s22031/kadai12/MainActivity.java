package jp.s22031.kadai12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();

        //ボタン・オブジェクトの用意
        Button btSend = findViewById(R.id.btSend);
        //ボタンにリスナを設定
        btSend.setOnClickListener(listener);

        //確認ボタンであるButtonオブジェクトを取得
        Button btConfirm = findViewById(R.id.btConfirm);
        //確認ボタンにリスナを設定
        btConfirm.setOnClickListener(listener);

        //クリアボタンであるButtonオブジェクトを取得
        Button btClear = findViewById(R.id.btClear);
        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //名前入力欄であるedittextオブジェクトを取得
            EditText input1 = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etTitle);
            EditText input3 = findViewById(R.id.etMail);
            EditText input4 = findViewById(R.id.etComment);


            //タップされた画面部分のidのRを取得
            int id = view.getId();
            //idのR値に応じて処理を分岐


            //表示ボタンの場合
            if(id==R.id.btSend) {
                //入力された名前文字列を取得
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String inputStr3 = input3.getText().toString();
                String inputStr4 = input4.getText().toString();

                //メッセージを表示
                String show = "送信しました。　内容\n" + "名前：" + inputStr1 + "\nタイトル「" + inputStr2 + "」"
                        +"\nメールアドレス:" + inputStr3 + "\n質問内容：" + inputStr4;
                //Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                Snackbar.make(view,show,Snackbar.LENGTH_LONG).show();

            }

            //確認ボタンの場合
            if(id==R.id.btConfirm){
                OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");

                //入力された名前文字列を取得
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String inputStr3 = input3.getText().toString();
                String inputStr4 = input4.getText().toString();

                //メッセージを表示
                String show = "名前：" + inputStr1 + "\nタイトル「" + inputStr2 + "」"
                        +"\nメールアドレス:" + inputStr3 + "\n質問内容：" + inputStr4;
                //Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                Snackbar.make(view,show,Snackbar.LENGTH_LONG).show();
            }

            //クリアボタンの場合
            if(id==R.id.btClear) {
                //名前入力欄を空文字に設定
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");

            }
        }
    }
}