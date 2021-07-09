package br.com.pdmfinance2.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.pdmfinance2.R;
import br.com.pdmfinance2.data.DAOTransactionSingleton;
import br.com.pdmfinance2.model.Transaction;

public class TransactionActivity extends Fragment implements View.OnClickListener{
    private Activity activity;
    private EditText edtDescription;
    private EditText edtPrice;
    private Spinner spinner;

    private Button btnSave;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtDescription = view.findViewById(R.id.edtDescription);
        edtPrice= view.findViewById(R.id.edtValue);
        btnSave=view.findViewById(R.id.btnSave);
        activity=getActivity();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Description = edtDescription.getText().toString();
                String PriceSt = edtPrice.getText().toString();
                String sopc= spinner.getSelectedItem().toString();
                if(Description.isEmpty()||PriceSt.isEmpty())
                {
                    return;
                }
                float Price = Float.parseFloat(PriceSt);
                if(sopc.equals("Debito"))
                {
                    Price= Price*-1;
                }
                String mostrar=String.valueOf(Price);
                Transaction transaction = new Transaction(Description, sopc,Price);
                Toast.makeText(activity.getApplicationContext(), mostrar, Toast.LENGTH_LONG).show();
                DAOTransactionSingleton.getINSTANCE().addTransaction(view.getContext(), transaction);
                getActivity();
            }
        });

        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(getActivity(), R.array.opc, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onClick(View v) {

    }


}