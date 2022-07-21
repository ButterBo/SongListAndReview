package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    Button btn5, btnRetrieve, btnGoToInsert;
    Spinner spin;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    CustomAdapter customList;

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
        customList = new CustomAdapter(this, R.layout.row,al);
//        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(customList);

        btnGoToInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(ShowList.this, MainActivity.class);
                startActivity(s);
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowList.this);
                al.clear();
                //al.addAll(dbh.getAllNotes());
                al.addAll(dbh.getAllSong());

                customList.notifyDataSetChanged();
            }
        });

        btn5.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowList.this);
                al.clear();
                //al.addAll(dbh.getAllNotes());
                al.addAll(dbh.getAll5Stars());
                customList.notifyDataSetChanged();
                Toast.makeText(ShowList.this, "Displaying all 5 star songs!", Toast.LENGTH_LONG).show();
            }
        }));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(ShowList.this, EditSong.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        DBHelper dbh = new DBHelper(ShowList.this);
        al.clear();
        al.addAll(dbh.getAllSong());
        customList.notifyDataSetChanged();
    }
}