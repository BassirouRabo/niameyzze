package niameyzze.apkode.net.niameyzze.manga;

import java.io.Serializable;

/**
 * Created by brabo on 6/3/16.
 */
public class MangaObject implements Serializable {
    private String image;

    public MangaObject(String image) {
        this.image = image;
    }

    public MangaObject() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
