package com.example.u7k4r5h.contactsreaderexamle;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Cursor query = getContentResolver()
                .query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                                null,
                        null,
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        listView.setAdapter(new SimpleCursorAdapter(MainActivity.this,
                android.R.layout.simple_list_item_2,
                query,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER},
                new int[]{android.R.id.text1, android.R.id.text2}));

    }
}
