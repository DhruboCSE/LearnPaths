package com.example.dhrubo.learnpaths;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalizedActivity extends Activity {

    private static final String TAG = "lastDay";
    public ArrayList<String> genLN = new ArrayList<String>();
    public ArrayList<String> actualLinks = new ArrayList<String>();
    ArrayAdapter<String> ad;
    int size =0;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_context, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.delete_id:
                String name = genLN.get(info.position);
                String pos = "";
                SharedPreferences sharedPref1 =  getSharedPreferences("name_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPref1.edit();
                Map<String, ?> allEntries = sharedPref1.getAll();
                for (Map.Entry<String, ?> entry: allEntries.entrySet()) {
                    if (name.equals(entry.getValue())) {
                        pos = entry.getKey();
                    }
                }
                editor1.putString(pos, "empty101");
                editor1.remove(pos);
                editor1.apply();
                genLN.remove(info.position);
                actualLinks.remove(info.position);
                ad.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalized);

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
        final ListAdapter genAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genLN);
        ListView genListview = (ListView) findViewById(R.id.gen_id);
        genListview.setAdapter(genAdapter);

        ad = new ArrayAdapter<String>(this, R.layout.coustom_row, R.id.textView, genLN);
        genListview.setAdapter(ad);
        registerForContextMenu(genListview);



        // load tasks from preference
        //Load from Saved
        SharedPreferences sharedPref1 =  getSharedPreferences("name_info", Context.MODE_PRIVATE);
        SharedPreferences sharedPref2 =  getSharedPreferences("address_info", Context.MODE_PRIVATE);
        SharedPreferences sharedPref3 =  getSharedPreferences("size_info", Context.MODE_PRIVATE);
        String SIZE = sharedPref3.getString("SIZE","");
        if(SIZE != ""){
            size = Integer.parseInt(SIZE);
        }

        for(int i=0; i<size+10;i++){
            String name = sharedPref1.getString(""+i,"");
            String link = sharedPref2.getString(""+i,"");
            if(name.equals("empty101")){
                genLN.add("empty101?? "+name);
                actualLinks.add(link);
            }
            else if(name.equals("")){
            }
            else{
                genLN.add(name);
                actualLinks.add(link);
            }
            ad.notifyDataSetChanged();
        }

        genListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String link = actualLinks.get(position);
                        Toast.makeText(PersonalizedActivity.this, link, Toast.LENGTH_SHORT).show();
                        Intent linkFinal = new Intent(getIntent().ACTION_VIEW, Uri.parse(link));
                        startActivity(linkFinal);
                    }
                }
        );

        //Default Button
        Button default_id = (Button) findViewById(R.id.default_id);
        default_id.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        SharedPreferences sharedPref1 =  getSharedPreferences("name_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = sharedPref1.edit();
                        editor1.clear();
                        editor1.commit();

                        SharedPreferences sharedPref2 =  getSharedPreferences("address_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sharedPref2.edit();
                        editor2.clear();
                        editor2.commit();

                        SharedPreferences sharedPref3 =  getSharedPreferences("size_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor3 = sharedPref3.edit();
                        editor3.clear();
                        editor3.commit();

                        genLN.clear();
                        actualLinks.clear();
                        size = 0;
                        ad.notifyDataSetChanged();
                    }
                }
        );


        final EditText txtname = (EditText) findViewById(R.id.name_txt);
        final EditText txtaddress = (EditText) findViewById(R.id.address_txt);
        Button add_btn = (Button) findViewById(R.id.add_btn);
        add_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        String newName = txtname.getText().toString();
                        if(newName.equals("")){
                            newName = "Wikipedia";
                        }
                        String newAddress = txtaddress.getText().toString();
                        if(newAddress.equals("https://")){
                            newAddress = "https://en.wikipedia.org/wiki/Main_Page";
                        }

                        // save the task list to preference
                        SharedPreferences sharedPref1 =  getSharedPreferences("name_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = sharedPref1.edit();
                        editor1.putString(""+size, newName);
                        editor1.commit();
                        genLN.add(newName);

                        SharedPreferences sharedPref2 =  getSharedPreferences("address_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sharedPref2.edit();
                        editor2.putString(""+size, newAddress);
                        editor2.commit();
                        actualLinks.add(newAddress);

                        size++;
                        SharedPreferences sharedPref3 =  getSharedPreferences("size_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor3 = sharedPref3.edit();
                        editor3.putString("SIZE", ""+size);
                        editor3.commit();

                        ad.notifyDataSetChanged();
                    }
                }
        );
    }
}
