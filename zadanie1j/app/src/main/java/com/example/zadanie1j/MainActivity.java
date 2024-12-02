package com.example.zadanie1j;
import com.example.zadanie1j.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText przychodEditText = findViewById(R.id.przychodEditText);
        EditText stawkaEditText = findViewById(R.id.stawkaEditText);
        TextView wynikTextView = findViewById(R.id.wynikTextView);

        Button obliczButton = findViewById(R.id.obliczButton);
        obliczButton.setOnClickListener(v -> {
            String przychodText = przychodEditText.getText().toString();
            String stawkaText = stawkaEditText.getText().toString();
            if (!przychodText.isEmpty() && !stawkaText.isEmpty()) {
                double przychod = Double.parseDouble(przychodText);
                double stawka = Double.parseDouble(stawkaText);
                double ryczalt = przychod * (stawka / 100);
                wynikTextView.setText(String.format("Ryczałt: %.2f zł", ryczalt));
            } else {
                wynikTextView.setText("Proszę podać poprawne wartości");
            }
        });
    }
}
