package example.kagan.ara;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Timeline extends AppCompatActivity {
    EditText Message;
    TextView name,id;

    LDAtimeline listDataAdapter;
    ListView listView;
    Cursor cursor;
    Context context = this;
    DBHelper messageDbHelper;
    SQLiteDatabase sqLiteDatabase;

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        name = (TextView) findViewById(R.id.txt_namepush);
        id = (TextView) findViewById(R.id.txt_idpush);
        Message = (EditText) findViewById(R.id.txt_writemessage);
        listView = (ListView) findViewById(R.id.lv_timeline);

        name.setText("Bilal Emmi");
        id.setText("@tunguskan");


        name.setVisibility(View.GONE);
        id.setVisibility(View.GONE);

        listDataAdapter = new LDAtimeline(getApplicationContext(),R.layout.actionbox);
        listView.setAdapter(listDataAdapter);
        messageDbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = messageDbHelper.getReadableDatabase();
        cursor = messageDbHelper.getMessage(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String namepush,idpush,messagepush;
                namepush = cursor.getString(0);
                idpush = cursor.getString(1);
                messagepush = cursor.getString(2);

                DPtimeline dataProviderTimeline = new DPtimeline(namepush,idpush,messagepush);
                listDataAdapter.add(dataProviderTimeline);

            }while (cursor.moveToNext());
        }
    }

    public void sendMessage (View view)
    {
        String namepus = name.getText().toString();
        String idpus = id.getText().toString();
        String message = Message.getText().toString();

        messageDbHelper = new DBHelper(context);
        sqLiteDatabase = messageDbHelper.getWritableDatabase();
        messageDbHelper.addMessage(namepus, idpus, message, sqLiteDatabase);
        messageDbHelper.close();
        listView.invalidateViews();
        listDataAdapter.clear();
        listDataAdapter.addAll(sqLiteDatabase.isReadOnly());
        listDataAdapter.notifyDataSetChanged();
        listView.invalidateViews();
        listView.refreshDrawableState();
        finish();
        Intent intent = new Intent (this,Timeline.class);
        startActivity(intent);
    }

    public void profileKaan (View view)
    {
        Intent intent = new Intent (this,Profile.class);
        startActivity(intent);
    }

}
