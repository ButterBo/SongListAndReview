package sg.edu.rp.c346.id21044912.p09_problemstatment_songlistreview;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public void setTitle(String title) { this.title = title; }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String toString() {
        String starRating = "";

        if (stars == R.id.star1) {
            starRating = "*";
        } else if (stars == R.id.star2) {
            starRating = "**";
        } else if (stars == R.id.star3) {
            starRating = "***";
        } else if (stars == R.id.star4) {
            starRating = "****";
        } else if (stars == R.id.star5) {
            starRating = "*****";
        }

        return title + "\n" + singers + " - " + year + "\n" + starRating;
    }
}
