package ProductManage;

public class Food extends Product{
	String expirationDate;
	
	public Food(String name, int stock, String image, String expirationDate){
		super(name, stock, image);
		this.expirationDate = expirationDate;
		
	}
	
	public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
