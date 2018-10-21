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

public class MathsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

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
        String[] genLN= {"Grade 1-12", "Intuitive Trigonometry", "Wolframalpha Maths",
                "Plot Graphs", "Basic Maths Practice", "SAT Math practice"};
        ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] actualLinks = {"https://ca.ixl.com/promo?partner=google&campaign=1305&adGroup=IXL+-+URL+-+General&gclid=Cj0KEQiAtK3DBRCBxt-Yxduq5p4BEiQAbFiaPemTKeD--kjE7ovoArGvyUUktuTGf982_qMKAlmsBEgaAgjZ8P8HAQ",
                                "https://betterexplained.com/articles/intuitive-trigonometry/",
                                "https://www.wolframalpha.com/examples/Math.html",
                                "https://www.desmos.com/calculator",
                                "http://www.math.com/students/practice.html",
                                "https://www.khanacademy.org/test-prep/sat/sat-math-practice"};
                        String link = actualLinks[position];
                        Toast.makeText(MathsActivity.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );
    }
}
