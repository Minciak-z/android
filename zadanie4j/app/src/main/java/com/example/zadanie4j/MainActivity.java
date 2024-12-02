package com.example.zadanie4j;
import com.example.zadanie4j.R;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progresBar;
    private Button przyciskStart;
    private Handler handler = new Handler();
    private int progres = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progresBar = findViewById(R.id.progresBar);
        przyciskStart = findViewById(R.id.przyciskStart);

        przyciskStart.setOnClickListener(v -> {
            progres = 0;
            progresBar.setProgress(progres);
            new Thread(this::aktualizujProgres).start();
        });
    }

    private void aktualizujProgres() {
        while (progres < 100) {
            progres++;
            handler.post(() -> progresBar.setProgress(progres));
            try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
