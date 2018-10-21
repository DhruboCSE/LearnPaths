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

public class PhysicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

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
        String[] genLN= {"Physics Org.", "Elementary Einstein", "PHET", "Astronomy", "Hubblesite", "Documentaries"};
        ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] actualLinks = {"http://www.physics.org/",
                                "http://www.einstein-online.info/elementary",
                                "https://phet.colorado.edu/en/simulations/category/physics",
                                "http://www.astronomy.com/",
                                "http://hubblesite.org/explore_astronomy/",
                                "https://cosmolearning.org/physics/documentaries/"};
                        String link = actualLinks[position];
                        Toast.makeText(PhysicsActivity.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );
    }
}
