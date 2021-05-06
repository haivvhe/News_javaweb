/*
*Copyright(C) 2021, Digital News .
* J3.L.P0004:
* Digital News
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2020-2-23       1.0                 HaiVV          control result search page
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The entity class contains constructor ,all properties of article and getter
 * ,setter method
 *
 * @author Vu Van Hai
 */
public class Article {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private String shortDes;
    private Date timePost;

    /**
     * Constructor default
     *
     *
     */
    public Article() {
    }

    /**
     * Constructor
     *
     * @param id  <code>int</code>
     * @param title  <code>String</code>
     * @param description <code>String</code>
     * @param image <code>String</code>
     * @param author  <code>String</code>
     * @param timePost  <code>Date</code>
     * @param shortDes <code>string</code>
     */
    public Article(int id, String title, String description, String image, String author, Date timePost, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    /**
     * Method convert format of date using simple date format
     *
     * @return date <code>String</code>
     */
    public String getDateConvert() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy - hh:mm:");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("a");
        String date = dateFormat1.format(this.timePost) + dateFormat2.format(this.timePost).toLowerCase();
        return date;
    }

    /**
     * Method to get value of Id
     *
     * @return id type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Method to set value of id
     *
     * @param id <code>int</code>
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method to get value of title
     *
     * @return title <code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to set value of title
     *
     * @param title <code>String</code>
     *
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method to get value of description
     *
     * @return description <code>String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set value of description
     *
     * @param description <code>String</code>
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get value of image
     *
     * @return image <code>String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Method to set value of image
     *
     * @param image <code>String</code>
     *
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Method to get value of author
     *
     * @return author <code>String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Method to set value of author
     *
     * @param author  <code>String<code>
     *
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Method to get value of timePost
     *
     * @return timePost  <code>Date</code>
     */
    public Date getTimePost() {
        return timePost;
    }

    /**
     * Method to set value of timePost
     *
     * @param timePost <code>Date</code>
     *
     */
    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    /**
     * Method to get value of shortDes
     *
     * @return shortDes  <code>String</code>
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Method to set value of shortDes
     *
     * @param shortDes <code>String</code>
     *
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

}
