package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    RadioGroup radioGroup;
    RadioButton radio1,radio2,radio3,radio4,radio5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        radioGroup = findViewById(R.id.radioGroup1);
        radio1 = findViewById(R.id.radiobtn1);
        radio2 = findViewById(R.id.radiobtn2);
        radio3 = findViewById(R.id.radiobtn3);
        radio4 = findViewById(R.id.radiobtn4);
        radio5 = findViewById(R.id.radiobtn5);
    }
}