package com.example.zadanie3;
import com.example.zadanie3.R;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View kwadrat = findViewById(R.id.kwadrat);
        Button przyciskStart = findViewById(R.id.przyciskStart);

        przyciskStart.setOnClickListener(v -> {
            ObjectAnimator animacja = ObjectAnimator.ofFloat(kwadrat, "rotation", 0f, 360f);
            animacja.setDuration(1000);
            animacja.start();
        });
    }
}
