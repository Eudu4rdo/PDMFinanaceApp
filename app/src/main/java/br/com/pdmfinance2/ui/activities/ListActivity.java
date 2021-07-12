package br.com.pdmfinance2.ui.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.com.pdmfinance2.R;
import br.com.pdmfinance2.data.DAOTransactionSingleton;

import br.com.pdmfinance2.lists.builder.TransactionListBuilder;
import br.com.pdmfinance2.model.Transaction;

public class ListActivity extends Fragment  implements View.OnClickListener{
    private FloatingActionButton fabRelatory;
    private float saldo;
    private TextView txtSaldo;
    private RecyclerView rvTransaction;
    private ArrayList<Transaction> transactions;
    private TextView listavazia;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtSaldo= view.findViewById(R.id.txtSaldo);
        listavazia= view.findViewById(R.id.listavazia);
        new TransactionListBuilder(view,R.id.rvTransaction).load(DAOTransactionSingleton.getINSTANCE().getTransactions(this.getContext()));
        transactions=DAOTransactionSingleton.getINSTANCE().getTransactions(this.getContext());
        for(int i =0; i<transactions.size();i++)
        {
            saldo= saldo+ transactions.get(i).getValue();
        }
        txtSaldo.setText("R$"+String.valueOf(saldo));
        fabRelatory = view.findViewById(R.id.fabRelatorio);
        this.fabRelatory.setOnClickListener(this);
        fabRelatory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.stg_relatory1);
                builder.setMessage(R.string.stg_relatory2)
                        .setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(getActivity().getApplicationContext(), "O relatorio foi gerado automaticamente", Toast.LENGTH_LONG).show();
                                // AQUI ADICONARIA AS TRANSAÇÕES ATRAVES DO BOTAO NO csv, POREM OPTEI POR FAZER O SALVAMENTO AUTOMATICO PARA AJUDAR NA PERSISTENCIA
                                //for(int i =0; i<transactions.size();i++)
                                //{
                                //    DAOTransactionSingleton.getINSTANCE().addTransaction(view.getContext(), transactions.get(i));
                                //}
                            }
                        })
                        .setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
            }
        });
        if(transactions.isEmpty())
        {
                //SUMI COM O BOTÃO
               fabRelatory.setVisibility(View.GONE);
               //MOSTRAR O TEXTO
               listavazia.setVisibility(View.VISIBLE);
        }else
            {
                //SUMI COM O BOTÃO
                fabRelatory.setVisibility(View.VISIBLE);
                //MOSTRAR O TEXTO
                listavazia.setVisibility(View.GONE);

            }

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
