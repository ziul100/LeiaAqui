package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Clientes extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        //spinner categoria de leitor
        Spinner spinner = findViewById(R.id.txtCategoriaCliente);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.catLeitores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //fim spinner



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_clientes);
            Button cadCliente = (Button)findViewById(R.id.btnCadastrarCliente);

            cadCliente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BancoController crud = new BancoController(getBaseContext());
                    EditText nome = (EditText) findViewById(R.id.txtNomeCliente);
                    EditText Email = (EditText)findViewById((R.id.txtEmailCliente));
                    EditText CPF = (EditText)findViewById(R.id.txtCPFCliente);
                    EditText Endereço = (EditText)findViewById(R.id.txtEnderecoCliente);
                    EditText Celular = (EditText)findViewById(R.id.txtCelularCliente);
                    EditText DataNasc = (EditText)findViewById(R.id.txtDataNascCliente);
                    Spinner CatCliente = (Spinner) findViewById(R.id.txtCategoriaCliente);
                    String NOME_CLIENTE = nome.getText().toString();
                    String ENDERECO_CLIENTE = Endereço.getText().toString();
                    String CELULAR_CLIENTE = Celular.getText().toString();
                    String EMAIL_CLIENTE = Email.getText().toString();
                    String CPF_CLIENTE = CPF.getText().toString();
                    String DATANASC_CLIENTE = DataNasc.getText().toString();
                    String IDCATEGORIALEITOR_FK = CatCliente.getText().toString();
                    String resultado;
                    resultado = crud.insereDadosCliente(int id, String NOME_CLIENTE, String ENDERECO_CLIENTE, String CELULAR_CLIENTE,
                            String EMAIL_CLIENTE, String CPF_CLIENTE, String DATANASC_CLIENTE,
                            String IDCATEGORIALEITOR_FK);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                }
            });
            cadCliente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Clientes.this, MenuClientes.class);
                    startActivity(intent);
                }
            });
        }
    }


