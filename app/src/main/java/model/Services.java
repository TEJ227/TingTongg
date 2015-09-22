package model;

/**
 * Created by TEJ's on 9/22/2015.
 */
public class Services {
    private String title, thumbnailUrl;

    private String details;

    public Services() {
    }

    public Services(String name, String thumbnailUrl, String details
                 ) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String  details) {
        this.details = details;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


}
