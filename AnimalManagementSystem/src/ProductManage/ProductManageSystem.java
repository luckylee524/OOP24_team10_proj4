package ProductManage;

public interface ProductManageSystem {
	public boolean insertFood(Food food);
	public boolean insertMedicine(Medicine medicine);
	public boolean deleteProduct(String name);
	public void sortion(int option);
}
