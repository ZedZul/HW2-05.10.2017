package com.zedzul.github.hw2_05102017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final ICalculator mCalculator = new Calculator();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View pSolveButton = findViewById(R.id.solve_button);
        final EditText pInputEditText = (EditText) findViewById(R.id.input_edit_text);
        final TextView pResultTextView = (TextView) findViewById(R.id.result_text_view);

        pSolveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                pResultTextView.setText(mCalculator.solve(pInputEditText.getText().toString()));
            }
        });
    }
}
