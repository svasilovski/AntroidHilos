package com.example.anrtrapped;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateTask extends AsyncTask<Void, Void, Integer> {
    private Context context;

    private ProgressBar progressBar;
    private TextView label;

    private int number;

    public CalculateTask (Context context, ProgressBar progresBar, TextView textView, int number){
        this.context = context;
        this.progressBar = progresBar;
        this.label = textView;
        this.number = number;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(this.label!=null) {
            this.label.setVisibility(View.GONE);
        }
        if(this.progressBar!=null) {
            this.progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        int result = this.factorial();
        return result;
    }

    private int factorial () {
        int factorial = 1;
        int sumaDeFactoriales = 0;
        for(int i=1;i<= this.number ;i++){
            factorial=1;
            for(int j=1;j<i;j++){
                factorial*=j;
            }
            sumaDeFactoriales+=factorial;
        }
        return sumaDeFactoriales;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(this.progressBar!=null) {
            this.progressBar.setVisibility(View.GONE);
        }

        if(this.label!=null) {
            this.label.setVisibility(View.VISIBLE);
            this.label.setText("El factorial de 39999 es " + integer);
        }

        Toast.makeText(this.context,"El factorial de 39999 es " + integer, Toast.LENGTH_LONG).show();
    }
}
