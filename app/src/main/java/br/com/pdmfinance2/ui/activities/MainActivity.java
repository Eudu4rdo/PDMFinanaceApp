package br.com.pdmfinance2.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.pdmfinance2.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                public Dialog onCreateDialog (Bundle savedInstanceState)  {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                    builder.setMessage(R.string.stg_relatory1)
//                            .setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    // FIRE ZE MISSILES!
//                                }
//                            })
//                            .setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                }
//                            });
//                    // Create the AlertDialog object and return it
//                    return builder.create();
//                }
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frl, new ListActivity())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.list: {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frl, new ListActivity())
                        .commit();
                //Toast.makeText(getApplicationContext(), "list", Toast.LENGTH_LONG).show();

                break;
            }
            case R.id.transaction: {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frl, new TransactionActivity())
                        .commit();
                //Toast.makeText(getApplicationContext(), "transação", Toast.LENGTH_LONG).show();
                break;
            }
        }
        return true;
    }
}

