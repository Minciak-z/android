package com.example.zadanie2j;
import com.example.zadanie2j.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView obrazekGlowny;
    int[] obrazy = {R.drawable.img1, R.drawable.img2};
    int aktualnyObraz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obrazekGlowny = findViewById(R.id.obrazekGlowny);
        Button przyciskTyl = findViewById(R.id.przyciskTyl);
        Button przyciskPrzod = findViewById(R.id.przyciskPrzod);

        obrazekGlowny.setImageResource(obrazy[aktualnyObraz]);

        przyciskTyl.setOnClickListener(v -> {
            if (aktualnyObraz > 0) {
                aktualnyObraz--;
                obrazekGlowny.setImageResource(obrazy[aktualnyObraz]);
            }
        });

        przyciskPrzod.setOnClickListener(v -> {
            if (aktualnyObraz < obrazy.length - 1) {
                aktualnyObraz++;
                obrazekGlowny.setImageResource(obrazy[aktualnyObraz]);
            }
        });
    }
}
