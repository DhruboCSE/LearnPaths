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

public class ChemistryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

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
        String[] genLN= {"Periodic Table", "Royal Society of Chemistry",
                "LearnChem", "KhanAcademy: Chemistry",
                "Virtual Organic Chemistry", "Tips"};
        ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] actualLinks = {"http://www.ptable.com/",
                                "http://www.rsc.org/",
                                "http://www.learnchem.net/",
                                "https://www.khanacademy.org/science/chemistry",
                                "https://www2.chemistry.msu.edu/faculty/reusch/virttxtjml/intro1.htm",
                                "http://www.wikihow.com/Learn-Chemistry"};
                        String link = actualLinks[position];
                        Toast.makeText(ChemistryActivity.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );
    }
}
