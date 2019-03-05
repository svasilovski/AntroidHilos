package com.example.anrtrapped;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView label;
    private EditText txtValue;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.label = (TextView) findViewById(R.id.label);
        this.txtValue = (EditText)findViewById(R.id.et_value);
        this.btnCalcular=(Button)findViewById(R.id.btn_calc);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hideKeyBoard();
                int value = Integer.parseInt(txtValue.getText().toString());
                new CalculateTask(v.getContext(), progressBar, label, value).execute();
            }
        });
    }

    private void hideKeyBoard()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if( imm != null )
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
