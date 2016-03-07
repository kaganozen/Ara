package example.kagan.ara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    Button bregister;
    EditText id,nickname,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        id = (EditText) findViewById(R.id.txt_regStudentid);
        nickname = (EditText) findViewById(R.id.txt_regNickname);
        email = (EditText) findViewById(R.id.txt_regEmail);
        password = (EditText) findViewById(R.id.txt_regPassword);
        bregister = (Button) findViewById(R.id.btn_registerSend);
    }

    public void Register (View View){

    }


}
