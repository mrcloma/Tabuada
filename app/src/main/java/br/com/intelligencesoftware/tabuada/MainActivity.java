package br.com.intelligencesoftware.tabuada;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private ListView listViewTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonShowTable = findViewById(R.id.buttonShowTable);
        listViewTable = findViewById(R.id.listViewTable);

        // Definir o filtro de tamanho máximo para 8 dígitos
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(8);
        editTextNumber.setFilters(filters);

        buttonShowTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTable();
            }
        });
    }

    private void showTable() {
        String inputText = editTextNumber.getText().toString();
        if (inputText.isEmpty()) {
            return;
        }

        int number = Integer.parseInt(inputText);
        ArrayList<String> tableItems = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            tableItems.add(number + " x " + i + " = " + result);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tableItems
        );
        listViewTable.setAdapter(adapter);
    }
}
