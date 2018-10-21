package com.example.dhrubo.learnpaths;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class General extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        //Back Button
        Button pro_back = (Button) findViewById(R.id.pro_back);
        pro_back.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();
                    }
                }
        );

        //List Of Links
        String[] genLN= {"Wikipedia", "Tedtalk", "Edx", "MIT CourseWare", "KhanAcademy", "Coursera"};
        ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] actualLinks = {"https://en.wikipedia.org/wiki/Main_Page", "http://ed.ted.com/","https://www.edx.org/",
                                "https://ocw.mit.edu/index.htm","https://www.khanacademy.org/", "https://www.coursera.org/"};
                        String link = actualLinks[position];
                        Toast.makeText(General.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );
    }
}
