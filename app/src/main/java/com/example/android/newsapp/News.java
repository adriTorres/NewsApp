package com.example.android.newsapp;

/**
 * An {@link News} object contains information related to a single new.
 */
public class News {

    /** Section name of the new */
    private String sectionName;

    /** Title of the new */
    private String title;

    /** Date of the new */
    private String date;

    /** Website URL of the new */
    private String url;

    /**
     * Constructs a new {@link News} object.
     *
     * @param sectionName is the section name of the new
     * @param title is the title of the new
     * @param date is the time when the new was published
     * @param url is the website URL to find more details about the new
     */
    public News(String sectionName, String title, String date, String url) {
        this.sectionName = sectionName;
        this.title = title;
        this.date = date;
        this.url = url;
    }

    /**
     * Returns the section name of the new.
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * Returns the title of the new.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the time of the new.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the website URL to find more information about the new.
     */
    public String getUrl() {
        return url;
    }
}
