package fi.arcada.codechallenge;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;

    TextView outputCalculate;
    double[] values = {3.5, 4.4, 9.0, 1.2, 6.5, 12.0};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);

        outputText.setText("Min app funkar!");

        outputCalculate = findViewById(R.id.outputCalculate);
        outputCalculate.setText("Medeltalet är...");


    }

    public void buttonHandler(View view) {
        String text = inputText.getText().toString();
        outputText.setText(text);
    }

    public void calculate(View view) {
        double summa = 0;
        for (int i = 0; i < values.length; i++) {
            summa = summa + values[i];
        }

        double medeltal = summa / values.length;
        outputCalculate.setText(String.format("Medeltalet är %.2f", medeltal));
    }

}