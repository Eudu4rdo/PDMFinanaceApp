package br.com.pdmfinance2.lists.transactions;

import android.annotation.SuppressLint;
import android.media.Image;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.pdmfinance2.model.Transaction;
import br.com.pdmfinance2.R;

public class TransactionsViewHolder extends RecyclerView.ViewHolder{

    private final TextView txtDescription;
    private final TextView txtValue;
    private final TextView txtSaldo;
    private final View img;

    private Transaction currentTransaction;


    public TransactionsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtDescription = itemView.findViewById(R.id.txtDescription);
        this.txtValue = itemView.findViewById(R.id.txtValue);
        this.txtSaldo = itemView.findViewById(R.id.txtSaldo);
        this.img=       itemView.findViewById(R.id.img);

    }

    public void bind(Transaction transaction) {
        this.txtDescription.setText(transaction.getDescription());
        this.txtValue.setText("R$ "+transaction.getValue().toString());
        if(transaction.getTipo().equals("Debito"))
        {
            this.img.setBackgroundColor(0xFFFF0303);
        }
        this.currentTransaction = transaction;

    }
}
