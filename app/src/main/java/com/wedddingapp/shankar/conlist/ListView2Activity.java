package com.wedddingapp.shankar.conlist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * Created by shan on 12/10/2017.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListView2Activity extends Activity {
    /**
     * Called when the activity is first created.
     */

    ListView lview;
    ListViewAdapter lviewAdapter;

    private final static String month[] = {"Shankar", "Kannan", "Swapnil", "Hitesh", "Suresh",
            "Anil", "Megha", "Mohhamed", "Kiran", "Kishore", "Urvin", "Jaswanth"};

    private final static String number[] = {"983432343", "9834312334", "9842342343",
            "934832343", "934322343", "9343242334",
            "934324343", "9342341123", "934834333",
            "982343434", "903432211", "8054234234"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lview = (ListView) findViewById(R.id.listView2);
        lviewAdapter = new ListViewAdapter(this, month, number);

        System.out.println("adapter => " + lviewAdapter.getCount());

        lview.setAdapter(lviewAdapter);

        registerForContextMenu(lview);


    }





    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, 1, 1, "Call");//groupId, itemId, order, title
        menu.add(0, 2, 2, "SMS");
    }




    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==1 && item.getGroupId()==0) {

            Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:983432343"));
            try {
                startActivity(in);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "Could not find an activity to place the call.", Toast.LENGTH_SHORT).show();
            }


        }

        if(item.getItemId()==2 && item.getGroupId()==0) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(intent);


        }

        return true;
    }




}


