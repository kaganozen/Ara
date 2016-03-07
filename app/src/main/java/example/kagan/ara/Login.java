package example.kagan.ara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Button blogin;
    EditText name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.txt_NameLogin);
        password = (EditText) findViewById(R.id.txt_PasswordLogin);
        blogin = (Button) findViewById(R.id.btn_login);


    }

    public void login(View view)
    {
        Intent intent = new Intent (this,Timeline.class);
        startActivity(intent);
    }

    public void onRegister(View view)
    {
        Intent intent = new Intent (this,Register.class);
        startActivity(intent);
    }
}
