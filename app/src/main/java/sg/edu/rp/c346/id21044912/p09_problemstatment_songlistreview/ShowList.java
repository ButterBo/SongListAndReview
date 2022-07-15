package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class ShowList extends AppCompatActivity {

    Button btn5, btnGoToInsert;
    Spinner spin;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        btn5 = findViewById(R.id.btn5stars);
        btnGoToInsert = findViewById(R.id.btnInsert);
        spin = findViewById(R.id.spinner);
        lv = findViewById(R.id.lv);

        Intent intentReceived = getIntent();

    }
}