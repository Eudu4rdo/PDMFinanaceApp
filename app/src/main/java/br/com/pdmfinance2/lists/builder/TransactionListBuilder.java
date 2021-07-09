package br.com.pdmfinance2.lists.builder;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.pdmfinance2.model.Transaction;
import br.com.pdmfinance2.lists.transactions.TransactionsAdapter;

public class TransactionListBuilder {

    private RecyclerView rvTransactions;
    private LinearLayoutManager layoutManager;
    private TransactionsAdapter adapter;
    private ArrayList<Transaction> transactions;

    public TransactionListBuilder(View view, @IdRes int idRv) {
        this.rvTransactions = view.findViewById(idRv);
        this.layoutManager = new LinearLayoutManager(view.getContext());
        this.rvTransactions.setLayoutManager(this.layoutManager);
    }

    public TransactionListBuilder load(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        this.adapter = new TransactionsAdapter(this.transactions);
        this.rvTransactions.setAdapter(this.adapter);
        return this;
    }
}
