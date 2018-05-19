package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /** Tag for the log messages */
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the new at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_element, parent, false);
        }

        // Find the new at the given position in the list of news
        News currentNew = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current new in that TextView
        titleView.setText(currentNew.getTitle());

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the title of the current new in that TextView
        sectionView.setText(currentNew.getSectionName());
        // Set the proper background color on the section name view.
        setSectionColor(sectionView, currentNew.getSectionName());

        if(currentNew.getAuthor()!=null) {
            // Find the TextView with view ID author
            TextView authorView = (TextView) listItemView.findViewById(R.id.author);
            // Display the author of the current new in that TextView
            authorView.setText(currentNew.getAuthor());
        }

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(currentNew.getDate());
            SimpleDateFormat newformat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
            String finalDateString = newformat.format(convertedDate);
            // Display the date of the current new in that TextView
            dateView.setText(finalDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the color for the new square based on the type of the section.
     *
     * @param sectionView of the new
     * @param sectionName of the new
     */
    private void setSectionColor(TextView sectionView, String sectionName) {
        if(sectionName.equals("World news")){
            sectionView.setBackgroundResource(R.color.sectionColorWorld);
        }
        else if(sectionName.equals("Science")){
            sectionView.setBackgroundResource(R.color.sectionColorScience);
        }
        else if(sectionName.equals("Society")){
            sectionView.setBackgroundResource(R.color.sectionColorSociety);
        }
        else if(sectionName.equals("News")){
            sectionView.setBackgroundResource(R.color.sectionColorNews);
        }
        else if(sectionName.equals("Politics")){
            sectionView.setBackgroundResource(R.color.sectionColorPolitics);
        }
        else if(sectionName.equals("Music")){
            sectionView.setBackgroundResource(R.color.sectionColorMusic);
        }
        else if(sectionName.equals("Technology")){
            sectionView.setBackgroundResource(R.color.sectionColorTechnology);
        }
        else if(sectionName.equals("Teacher Network")){
            sectionView.setBackgroundResource(R.color.sectionColorTeacherNetwork);
        }
        else
            sectionView.setBackgroundResource(R.color.sectionColorOther);

    }
}
