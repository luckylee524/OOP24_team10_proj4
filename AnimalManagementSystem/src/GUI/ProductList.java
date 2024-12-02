package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ProductManage.Product;
import ProductManage.Medicine;
import ProductManage.Food;

public class ProductList {
	///////////////////////////////////////////////
	//***connection here(Product 객체를 다루는 ArrayList)
	///////////////////////////////////////////////
	private ArrayList<Product> products;

	public ProductList() {
	    products = new ArrayList<>();
	    
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] details = line.split(" / ");
	            if (details[0].equals("Food")) {
	                // "Food" 라인일 경우 Food 객체 생성
	                Food food = new Food(details[1], Integer.parseInt(details[2]), details[3]);
	                products.add(food);  // 제품 리스트에 Food 객체 추가
	            } else if (details[0].equals("Medicine")) {
	                // "Medicine" 라인일 경우 Medicine 객체 생성
	                Medicine medicine = new Medicine(details[1], Integer.parseInt(details[2]), details[3]);
	                products.add(medicine);  // 제품 리스트에 Medicine 객체 추가
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public ArrayList<Product> getProducts() {
        return products;
    }
    
}
