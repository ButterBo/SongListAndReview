package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditSong extends AppCompatActivity {

    EditText etSongTitle, etSinger, etYear;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDel);
        btnCancel = findViewById(R.id.btnCancel);
        etSongTitle = findViewById(R.id.editTitle);
        etSinger = findViewById(R.id.editSinger);
        etYear = findViewById(R.id.editYear);
        rgStars = findViewById(R.id.editRadioStars);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etSongTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYear() + "");
        rgStars.check(data.getStars());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                data.setTitle(etSongTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setStars(rgStars.getCheckedRadioButtonId());

                dbh.updateSong(data);
                dbh.close();

                Intent i = new Intent(EditSong.this, ShowList.class);
                startActivity(i);
                Toast.makeText(EditSong.this, etSongTitle.getText() + " has been updated successfully!", Toast.LENGTH_LONG).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                dbh.deleteSong(data.get_id());

                Intent i = new Intent(EditSong.this, ShowList.class);
                startActivity(i);
                Toast.makeText(EditSong.this, etSongTitle.getText() + " has been deleted", Toast.LENGTH_LONG).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditSong.this, ShowList.class);
                startActivity(i);
            }
        });
    }
}