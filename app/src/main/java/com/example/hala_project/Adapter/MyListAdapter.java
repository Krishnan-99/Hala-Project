package com.example.hala_project.Adapter;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hala_project.Contact.ContactDetailActivity;
import com.example.hala_project.Model.ContactDetails;
import com.example.hala_project.R;

import java.util.List;

/**
 * Created by Belal on 9/14/2017.
 */

//we need to extend the ArrayAdapter class as we are building an adapter
public class MyListAdapter extends ArrayAdapter<ContactDetails> {

    //the list values in the List of type hero
    List<ContactDetails> contactDetails;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<ContactDetails> contactDetails) {
        super(context, resource, contactDetails);
        this.context = context;
        this.resource = resource;
        this.contactDetails = contactDetails;
    }

    //this will return the ListView Item as a View
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        RelativeLayout mRelative=view.findViewById(R.id.relativeHeader);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewRole = view.findViewById(R.id.textViewRole);
        TextView textViewCompany = view.findViewById(R.id.textViewCompany);

        //getting the hero of the specified position
        ContactDetails contactList = contactDetails.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(contactList.getImage()));
        textViewName.setText(contactList.getName());
        textViewRole.setText(contactList.getRole());
        textViewCompany.setText(contactList.getCompany());

        //adding a click listener to the button to remove item from the list
        mRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ContactDetailActivity.class);
                intent.putExtra("name",contactList.getName());
                intent.putExtra("role",contactList.getRole());
                intent.putExtra("education",contactList.getEducation());
                context.startActivity(intent);
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
            }
        });

        //finally returning the view
        return view;
    }

    //this method will remove the item from the list
}
