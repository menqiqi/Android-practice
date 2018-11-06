package com.example.administrator.zuoye1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuoye1);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        Button button = (Button)findViewById(R.id.button);
        final TextView textView = (TextView)findViewById(R.id.textView);
        String string = (String) spinner.getSelectedItem();

        //建立数据源
        String[] list = getResources().getStringArray(R.array.subjects);
        //建立Adapter并且绑定数据源
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //绑定Adapter控件
        spinner.setAdapter(adapter);

        //缺省值设置
        spinner.setSelection(3,true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] subjects = getResources().getStringArray(R.array.subjects);
               Toast.makeText(MainActivity.this,subjects[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String string = (String)spinner.getSelectedItem();
               textView.setText(string);
            }
        });
    }
}
