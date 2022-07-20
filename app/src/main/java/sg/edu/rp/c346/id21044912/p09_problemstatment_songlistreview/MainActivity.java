package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    RadioGroup radioGroup;
    Button btnAdd, btnShow;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnReturn);
        radioGroup = findViewById(R.id.radioGroup1);
        //lv = findViewById(R.id.lv);

//        al = new ArrayList<Song>();
//        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
//        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                String yearText = etYear.getText().toString();
                int year = Integer.parseInt(yearText);
                int review = radioGroup.getCheckedRadioButtonId();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long insert_id = dbh.insertSong(title, singer, year, review);

                if (insert_id != -1) {
                    Toast.makeText(MainActivity.this, "Added" + title + " to the Song list successfully", Toast.LENGTH_LONG).show();

                    etTitle.setText("");
                    etSinger.setText("");
                    etYear.setText("");
                    radioGroup.clearCheck();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showi = new Intent(MainActivity.this, ShowList.class);
                startActivity(showi);
            }
        });

    }
}