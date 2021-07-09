package br.com.pdmfinance2.data;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.pdmfinance2.model.Transaction;

class FileManager {
    /* CSV - Comma Separated Values (formato estruturado de dados de arquivo)
    Divida com agiota; -R$;30000\n
    Venda de produtos duvidosos;R$;800\n
     */
    private static final Date data = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataFormatada = dateFormat.format(data);
    String nome = dataFormatada.toString()+".csv";
    private final String FILENAME = "nome";
    private File file;

    FileManager(Context context) {
        this.file = new File(context.getFilesDir(), FILENAME);
    }

    private void write(String stream) throws IOException {
        BufferedWriter bfwriter = new BufferedWriter(new FileWriter(this.file, true));
        bfwriter.write(stream);
        bfwriter.close();
    }

    private ArrayList<Transaction> read() throws IOException {
        BufferedReader bfreader = new BufferedReader(new FileReader(this.file));
        ArrayList<Transaction> transactions = new ArrayList<>();
        String line;
        while((line = bfreader.readLine()) != null) {
            transactions.add(this.csvRowToTransaction(line));
        }
        bfreader.close();
        return transactions;
    }

    private Transaction csvRowToTransaction(String row) {
        String[] transStr = row.split(";");
        String desc = transStr[0];
        String opc= transStr[1];
        float value = Float.parseFloat(transStr[2]);
        return new Transaction(desc, opc, value);
    }

    private String transactionToCsvRow(Transaction transaction) {
        return transaction.getDescription()+";"+transaction.getTipo()+";"+transaction.getValue()+"\n";
    }

    protected void save(Transaction transaction) throws IOException {
        String row = this.transactionToCsvRow(transaction);
        this.write(row);
    }

    protected ArrayList<Transaction> load() throws IOException {
        return this.read();
    }

}
