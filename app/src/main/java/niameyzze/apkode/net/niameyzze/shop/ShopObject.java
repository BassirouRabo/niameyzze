package niameyzze.apkode.net.niameyzze.shop;

import java.io.Serializable;

/**
 * Created by brabo on 6/3/16.
 */
public class ShopObject implements Serializable {
    private String image;

    public ShopObject(String image) {
        this.image = image;
    }

    public ShopObject() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
