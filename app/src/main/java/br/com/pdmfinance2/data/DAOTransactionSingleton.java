package br.com.pdmfinance2.data;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.com.pdmfinance2.model.Transaction;

public class DAOTransactionSingleton {
    private static DAOTransactionSingleton INSTANCE;
    private ArrayList<Transaction> transactions;
    private FileManager fileManager;

    private DAOTransactionSingleton(){
        this.transactions= new ArrayList<>();
        this.fileManager=null;
    }

    public static DAOTransactionSingleton getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new DAOTransactionSingleton();
        return INSTANCE;
    }

    private FileManager initializeFileManager(Context context) throws IOException {
        if (this.fileManager == null) {
            this.fileManager = new FileManager(context);
            this.transactions = this.fileManager.load();
        }
        return this.fileManager;
    }

    public ArrayList<Transaction> getTransactions(Context context) {
        try {
            this.initializeFileManager(context);
        } catch (IOException e) {
            Toast.makeText(context, "FileErr: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return this.transactions;
    }

    public void addTransaction(Context context, Transaction transaction) {
        this.transactions.add(transaction);
    }
}
