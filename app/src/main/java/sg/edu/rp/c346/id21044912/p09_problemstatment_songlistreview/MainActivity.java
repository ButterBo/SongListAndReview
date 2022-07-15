package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    RadioGroup radioGroup;
    RadioButton radio1,radio2,radio3,radio4,radio5;
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
        radio1 = findViewById(R.id.radiobtn1);
        radio2 = findViewById(R.id.radiobtn2);
        radio3 = findViewById(R.id.radiobtn3);
        radio4 = findViewById(R.id.radiobtn4);
        radio5 = findViewById(R.id.radiobtn5);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int review = 0;
                if (radio1.isChecked()){
                    review = 1;
                } else if (radio2.isChecked()){
                    review = 2;
                } else if (radio3.isChecked()){
                    review = 3;
                } else if (radio4.isChecked()){
                    review = 4;
                } else if (radio5.isChecked()){
                    review = 5;
                } else {
                    review = 0;
                }
                if (!TextUtils.isEmpty(title)){
                    if (!TextUtils.isEmpty(singer)){
                        if ((year >= 1888) || (year != 0)){
                            if (review > -1){
                                DBHelper dbh = new DBHelper(MainActivity.this);
                                long inserted_id = dbh.insertSong(title, singer, year, review);

                                if (inserted_id != -1){
                                    al.clear();
                                    al.addAll(dbh.getAllSong());
                                    aa.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_SHORT).show();
                            } else {
                                    Toast.makeText(MainActivity.this, "Insertion failed, please try again", Toast.LENGTH_SHORT).show();
                                }
                        } else {
                                //should not be possible ow that I think about it.
                                Toast.makeText(MainActivity.this, "Invalid Star, please try again", Toast.LENGTH_SHORT).show();
                            }
                    } else {
                            Toast.makeText(MainActivity.this, "Invalid year, please enter year that is greater or equal to 1888", Toast.LENGTH_SHORT).show();
                        }
                } else {
                        Toast.makeText(MainActivity.this, "Please enter the name of the singer", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "{Please enter a song's title}", Toast.LENGTH_SHORT).show();
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