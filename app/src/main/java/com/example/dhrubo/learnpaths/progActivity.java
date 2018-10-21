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

public class progActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog);

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
        String[] genLN= {"HTML & CSS", "JAVA", "C", "C++", "Python", "JavaScript", "SQL"};
        ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] actualLinks = {"http://learn.shayhowe.com/html-css/","https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28",
                                "http://www.learn-c.org/","http://www.learncpp.com/","https://learnpythonthehardway.org/book/",
                                "https://www.codecademy.com/learn/javascript","https://www.codecademy.com/learn/learn-sql"
                                };
                        String link = actualLinks[position];
                        Toast.makeText(progActivity.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );
    }
}

