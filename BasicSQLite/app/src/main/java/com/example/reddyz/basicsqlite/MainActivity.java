package com.example.reddyz.basicsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView outputText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText)findViewById(R.id.inputText);
        outputText = (TextView)findViewById(R.id.dbText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDb();
    }

    public void printDb() {
        String dbString = dbHandler.dbToString();
        outputText.setText(dbString);
        inputText.setText("");
    }

    public void addButtonClicked(View v) {
        Products prod = new Products(inputText.getText().toString());
        dbHandler.addProduct(prod);
        printDb();
    }

    public void deleteButtonClicked(View v) {
        String text = inputText.getText().toString();
        dbHandler.deleteProduct(text);
        printDb();
    }
}
