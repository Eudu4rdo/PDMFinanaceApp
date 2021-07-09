package br.com.pdmfinance2.ui.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import br.com.pdmfinance2.R;
import br.com.pdmfinance2.data.DAOTransactionSingleton;
import br.com.pdmfinance2.lists.builder.TransactionListBuilder;
import br.com.pdmfinance2.model.Transaction;

public class ListActivity extends Fragment  implements View.OnClickListener{
    private BottomNavigationView navigationView;
    private float saldo;
    private TextView txtSaldo;
    private RecyclerView rvTransaction;
    private ArrayList<Transaction> transactions;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtSaldo= view.findViewById(R.id.txtSaldo);
        new TransactionListBuilder(view,R.id.rvTransaction).load(DAOTransactionSingleton.getINSTANCE().getTransactions(this.getContext()));
        transactions=DAOTransactionSingleton.getINSTANCE().getTransactions(this.getContext());
        for(int i =0; i<transactions.size();i++)
        {
            saldo= saldo+ transactions.get(i).getValue();
        }
        txtSaldo.setText("R$"+String.valueOf(saldo));
//        navigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavigationView);
//        this.navigationView.setOnClickListener(this);
//        navigationView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
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
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
