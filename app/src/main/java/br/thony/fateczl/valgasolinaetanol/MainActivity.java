package br.thony.fateczl.valgasolinaetanol;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     /*
     *@author:<Anthony Siqueira>
     *@RA:<	1110482313032>
     */

    private EditText txtGasolina;
    private EditText txtEtanol;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtGasolina = findViewById(R.id.txtGasolina);
        txtGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtEtanol = findViewById(R.id.txtEtanol);
        txtEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        lblResultado = findViewById(R.id.lblResultado);
        lblResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calcular());

    }
        private void calcular() {
            float gasolina = Float.parseFloat(txtGasolina.getText().toString());
            float etanol = Float.parseFloat(txtEtanol.getText().toString());

            if (etanol > gasolina * 0.7) {
                lblResultado.setText("Abasteça com gasolina");
            } else if (etanol <= gasolina * 0.7) {
                lblResultado.setText("Abasteça com etanol");
            } else {
                lblResultado.setText("Insira um valor válido");
            }

            txtGasolina.setText("");
            txtEtanol.setText("");
        }

    }