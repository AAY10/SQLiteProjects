package com.example.sqliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INT)");   //VARCHAR = String

            //database.execSQL("INSERT INTO musicians(name,age) VALUES('Lars',60)");   //INSERT INTO = Bir şeyin içerisine yerleştirmek
            //database.execSQL("INSERT INTO musicians(name,age) VALUES('James',50)");   //INSERT INTO = Bir şeyin içerisine yerleştirmek
            //database.execSQL("INSERT INTO musicians(name,age) VALUES('Kirk',55)");

            //database.execSQL("UPDATE musicians SET age=61 WHERE name='Lars'");  //UPDATE = Veriyi güncellemek. Örnek : name='Lars' olanın yaşını 61 yap.
            //database.execSQL("UPDATE musicians SET name='Sawyer' WHERE id=3");  //WHERE = Filtreleme işlemi için kullanılır. Örnek : id = 3 olanın ismini Sawyer yap.

            //database.execSQL("DELETE FROM musicians  WHERE id=2"); //DELETE = Veriyi silmek.

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE age>52",null); // Cursor = verileri okumak için kullanılır , * = her şey demek
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'S%'",null);  //İsmi S ile başlayanları al. Eğer s% olaydı ismi s ile bitenleri alacaktı.
            Cursor cursor = database.rawQuery("SELECT * FROM musicians ",null); // Cursor = verileri okumak için kullanılır , * = her şey demek

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getString(ageIx));
                System.out.println("Id: " + cursor.getString(idIx));
            }
            cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }



















    }
}