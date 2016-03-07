package example.kagan.ara;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kagan on 22.01.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "Ara";
    private static final int DBVERSION='1';



    private static final String CREATE_MESSAGETB=
            "CREATE TABLE " + Values.UserMessage.TBMESSAGE+"("+ Values.UserMessage.MESSAGEID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.UserMessage.MESSAGEOWNER+" TEXT,"+ Values.UserMessage.MESSAGEOWNERID+" TEXT NOT NULL,"+ Values.UserMessage.MESSAGETEXT+" TEXT NOT NULL);";

    private static final String CREATE_REGISTERTB=
            "CREATE TABLE " + Values.Register.TBREGISTER+"("+ Values.Register.STUDENTID+" PRIMARY KEY, "+
                    Values.Register.STUDENTNICKNAME+" TEXT NOT NULL,"+ Values.Register.STUDENTEMAIL+" TEXT NOT NULL,"+ Values.Register.STUDENTPASSWORD+" TEXT NOT NULL);";

    public DBHelper (Context context){

        super(context, DBNAME, null, DBVERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REGISTERTB);
        db.execSQL(CREATE_MESSAGETB);

        Log.e("DATABASE OPERATIONS","Tables created");

    }

    public void addMessage(String owner, String ownerid, String message, SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.UserMessage.MESSAGEOWNER, owner);
        cv.put(Values.UserMessage.MESSAGEOWNERID, ownerid);
        cv.put(Values.UserMessage.MESSAGETEXT, message);

        db.insert(Values.UserMessage.TBMESSAGE, null, cv);
        Log.e("DATABASE OPERATIONS", "Message row inserted");

    }

    public void addUser(String id, String nickname, String email,String password, SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.Register.STUDENTID, id);
        cv.put(Values.Register.STUDENTNICKNAME, nickname);
        cv.put(Values.Register.STUDENTEMAIL, email);
        cv.put(Values.Register.STUDENTPASSWORD, password);

        db.insert(Values.Register.TBREGISTER, null, cv);
        Log.e("DATABASE OPERATIONS", "User added");

    }

    public Cursor getMessage (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] userinfo = {Values.UserMessage.MESSAGEOWNER, Values.UserMessage.MESSAGEOWNERID, Values.UserMessage.MESSAGETEXT};
        cursor = db.query(Values.UserMessage.TBMESSAGE, userinfo,null,null,null,null,null);
        return cursor;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
