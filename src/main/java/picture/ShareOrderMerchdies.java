package picture;

public class ShareOrderMerchdies {
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品简称
     */
    private String abbreviation;
    /**
     * 价格
     */
    private String price;
    /**
     * 图片地址
     */
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
