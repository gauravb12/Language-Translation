package com.example.rkrmills.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RKRMILLS on 11-01-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //resource id for backgroud color of this list of words
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {
        super(context,0, words);
        mColorResourceId=colorResourceId;
    }

    @Override
       public View getView(int position, View convertView, ViewGroup parent) {
                // Check if the existing view is being reused, otherwise inflate the view
                      View listItemView = convertView;
               if(listItemView == null) {
                       listItemView = LayoutInflater.from(getContext()).inflate(
                                        R.layout.list__item, parent, false);
                    }

                        // Get the {@link AndroidFlavor} object located at this position in the list
                                Word currentWord = getItem(position);

                        // Find the TextView in the list_item.xml layout with the ID version_name
                                TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
               // Get the version name from the current AndroidFlavor object and
                        // set this text on the name TextView
                              miwokTextView.setText(currentWord.getMiwokTranslation());

                        // Find the TextView in the list_item.xml layout with the ID version_number
                                TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
                // Get the version number from the current AndroidFlavor object and
                        // set this text on the number TextView
                               defaultTextView.setText(currentWord.getDefaultTranslation());

                       //find the imageview in the list_item.xml layout with id image
                                ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);

                                if(currentWord.hasImage()){
                                    imageView.setImageResource(currentWord.getImageResourceId());

                                    //MAKE SURE VIEW IS VISIBLE
                                    imageView.setVisibility(View.VISIBLE);
                                }
                                else{
                                    //OTHERWISE HIDE THE IMAGEVIEW(set visibility to gone)
                                    imageView.setVisibility(View.GONE);
                                }

        //see the theme color for the list item
        View textContainer=listItemView.findViewById(R.id.text_container);

        //find the color that resouce id maps to
        int color= ContextCompat.getColor(getContext(),mColorResourceId);

        //set the background color of the text container view
        textContainer.setBackgroundColor(color);
                         // so that it can be shown in the ListView
                                       return listItemView;


            }

}