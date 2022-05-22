package com.example.hala_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hala_project.Adapter.MyListAdapter;
import com.example.hala_project.Model.ContactDetails;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactPageActivity extends AppCompatActivity {
    List<ContactDetails> contactDetailsList;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadJSONFromAsset();
        Config.arrayList.clear();
        String jsonString = loadJSONFromAsset();
        if(jsonString != null){
            try {
                JSONArray userArray = new JSONArray(jsonString);
                for(int i=0;i<userArray.length();i++){
                    ContactDetails list=new ContactDetails();
                    JSONObject obj=userArray.getJSONObject(i);
                    JSONObject jsonCompany = obj.getJSONObject("job");
                    JSONObject jsonContact=obj.getJSONObject("contact");
                    list.setName(obj.getString("first_name")+ " " +obj.getString("last_name"));
                    list.setRole(jsonCompany.getString("role"));
                    list.setCompany(jsonCompany.getString("company"));
                    list.setEmailID(jsonContact.getString("email"));
                    list.setPhoneNumber(jsonContact.getString("phone_number"));
                    list.setAddress(jsonContact.getString("address"));
                    list.setEducation(obj.getString("education"));
                    list.setDOB(obj.getString("birth_day"));
                    list.setCountry(obj.getString("education"));
                    Config.arrayList.add(list);



                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        listView = (ListView) findViewById(R.id.listView);

        //adding some values to our list

        //creating the adapter
        MyListAdapter adapter = new MyListAdapter(this, R.layout.list_row, Config.arrayList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("contacts.json"); // your file name
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}