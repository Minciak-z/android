package com.example.zadanie5j;
import com.example.zadanie5j.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText elementText;
    private ListView listaZakupow;
    private Button dodajPrzycisk;
    private ArrayList<String> zakupy;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementText = findViewById(R.id.elementText);
        listaZakupow = findViewById(R.id.listaZakupow);
        dodajPrzycisk = findViewById(R.id.dodajPrzycisk);

        zakupy = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, zakupy);
        listaZakupow.setAdapter(adapter);

        dodajPrzycisk.setOnClickListener(v -> {
            String element = elementText.getText().toString();
            if (!element.isEmpty()) {
                zakupy.add(element);
                elementText.setText("");
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Wpisz nazwę elementu", Toast.LENGTH_SHORT).show();
            }
        });

        listaZakupow.setOnItemClickListener((parent, view, position, id) -> {
            zakupy.remove(position);
            adapter.notifyDataSetChanged();
        });
    }
}
