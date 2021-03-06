package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper  {
    Context context;
    DB myHelper;

    public DataBaseHelper(Context context)
    {
        this.context = context;
        myHelper = new DB(context);

        //Content value class has to be instanticated
        //ContentValues contentValues = new ContentValues();


    }

    public long insertData(PersonDetails personDetails)
    {
        SQLiteDatabase db = myHelper.getWritableDatabase();

        //Content value class has to be instanticated
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB.name,personDetails.getName());
        contentValues.put(DB.email,personDetails.getEmail());
        contentValues.put(DB.phone,personDetails.getPhone());
        contentValues.put(DB.adress,personDetails.getAdress());
        contentValues.put(DB.password,personDetails.getPassword());
        long id = db.insert(DB.db_TableName,null,contentValues);

        return  id;

    }


    public class DB extends SQLiteOpenHelper {

        private static final String db_name = "PersonDB";
        private static final String db_TableName = "PersonTable";
        private static final int db_version = 1;
        private static final String uid = "_id";
        private static final String name = "Name";
        private static final String email = "Email";
        private static final String phone = "Phone";
        private static final String adress = "Adress";
        private static final String password = "Password";
        Context context;


        String createTable = "Create Table " + db_TableName + " ( " + uid + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + name + " VARCHAR(255) ,"
                + email + " VARCHAR(25) ,"
                + phone + " VARCHAR(12) ,"
                + adress + " VARCHAR(255) , "
                + password + " VARCHAR(255));";

        String dropTable = "Drop Table if EXISTS " + db_TableName;


        public DB(@Nullable Context context) {
            super(context, db_name, null, db_version);
            this.context = context;

            //the version change will be monired by creation of constructor!

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //create Table for DB
            try {
                sqLiteDatabase.execSQL(createTable);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context,"Table created",Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newversion) {
            try
            {
                sqLiteDatabase.execSQL(dropTable);
                onCreate(sqLiteDatabase);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
