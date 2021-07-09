package br.com.pdmfinance2.lists.transactions;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import br.com.pdmfinance2.R;
import br.com.pdmfinance2.model.Transaction;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsViewHolder> {

    private ArrayList<Transaction> transactions;
    public TransactionsAdapter(ArrayList<Transaction> transactions)
    {
        this.transactions=transactions;
    }
    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_view_transaction, parent, false);
        return new TransactionsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder holder, int position) {
        holder.bind(this.transactions.get(position));
    }

    @Override
    public int getItemCount() {
        return this.transactions.size();
    }
}
