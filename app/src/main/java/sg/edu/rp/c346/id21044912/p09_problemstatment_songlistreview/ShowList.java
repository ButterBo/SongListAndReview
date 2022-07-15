package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    Button btn5, btnRetrieve, btnGoToInsert;
    Spinner spin;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        btn5 = findViewById(R.id.btn5stars);
        btnRetrieve = findViewById(R.id.btnList);
        btnGoToInsert = findViewById(R.id.btnInsert);
        spin = findViewById(R.id.spinner);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        Intent intentReceived = getIntent();

        btnGoToInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowList.this);
                al.clear();
                //al.addAll(dbh.getAllNotes());
                al.addAll(dbh.getAllSong());

                aa.notifyDataSetChanged();
            }
        });

        btn5.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowList.this);
                al.clear();
                //al.addAll(dbh.getAllNotes());
                int filterText = 5;
                al.addAll(dbh.getAllSong(filterText));
                aa.notifyDataSetChanged();
            }
        }));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(ShowList.this,
                        EditSong.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
}