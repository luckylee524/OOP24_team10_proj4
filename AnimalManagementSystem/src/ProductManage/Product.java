package ProductManage;

public class Product {
    private String name;
    private int stock;
    private String image;

    public Product(String name, int stock, String image) {
        this.name = name;
        this.stock = stock;
        this.image = image;
    }

    public String getImage() {
    	return image;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
