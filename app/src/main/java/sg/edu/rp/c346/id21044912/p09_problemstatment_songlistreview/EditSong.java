package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditSong extends AppCompatActivity {

    EditText title, name, year;
    RadioGroup radioGroup2;
    RadioButton r1,r2,r3,r4,r5;
    Button btnUpd, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        title = findViewById(R.id.etTitle);
        name = findViewById(R.id.etSinger);
        year = findViewById(R.id.etYear);
        radioGroup2 = findViewById(R.id.radioGroup2);
        r1 = findViewById(R.id.btn1);
        r2 = findViewById(R.id.btn2);
        r3 = findViewById(R.id.btn3);
        r4 = findViewById(R.id.btn4);
        r5 = findViewById(R.id.btn5);
        btnUpd=findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDel);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        title.setText(data.getTitle());
        name.setText(data.getSingers());
        year.setText(data.getYear());
        int star = data.getStars();
        if (star==5){
            r5.setChecked(true);
            r4.setChecked(false);
            r3.setChecked(false);
            r2.setChecked(false);
            r1.setChecked(false);
        } else if (star == 4){
            r5.setChecked(false);
            r4.setChecked(true);
            r3.setChecked(false);
            r2.setChecked(false);
            r1.setChecked(false);
        } else if (star == 3){
            r5.setChecked(false);
            r4.setChecked(false);
            r3.setChecked(true);
            r2.setChecked(false);
            r1.setChecked(false);
        } else if (star == 2){
            r5.setChecked(false);
            r4.setChecked(false);
            r3.setChecked(false);
            r2.setChecked(true);
            r1.setChecked(false);
        } else {
            r5.setChecked(false);
            r4.setChecked(false);
            r3.setChecked(false);
            r2.setChecked(false);
            r1.setChecked(true);
        }
    }
}