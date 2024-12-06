package ProductManage;

import java.io.*;
import java.util.*;

public class ProductManageSystemImpl implements ProductManageSystem{
	
	public boolean insertFood(Food food) {
	    boolean error = false;
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);
	    boolean isDuplicate = false;

	    try (BufferedReader reader = new BufferedReader(new FileReader(file));
	         BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] productDetails = line.split(" / ");
	            if (productDetails.length >= 2 && productDetails[1].equals(food.getName())) {
	                isDuplicate = true;
	                break;
	            }
	        }

	        if (isDuplicate) {
	            error = true;
	        } else {
	            // 파일이 비어있지 않으면 newLine()을 호출하여 줄바꿈 추가
	            if (file.length() > 0) {
	                writer.newLine();
	            }
	            // 데이터를 파일에 기록
	            writer.write("Food" + " / " + food.getName() + " / " + food.getStock() + " / " + food.getImage() + " / " + food.getExpirationDate());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        error = true;
	    }
	    return error;
	}
	
	public boolean insertMedicine(Medicine medicine) {
	    boolean error = false;
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);
	    boolean isDuplicate = false;

	    try (BufferedReader reader = new BufferedReader(new FileReader(file));
	         BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] productDetails = line.split(" / ");
	            if (productDetails.length >= 2 && productDetails[1].equals(medicine.getName())) {
	                isDuplicate = true;
	                break;
	            }
	        }

	        if (isDuplicate) {
	            error = true;
	        } else {
	            // 파일이 비어있지 않으면 newLine()을 호출하여 줄바꿈 추가
	            if (file.length() > 0) {
	                writer.newLine();
	            }
	            // 데이터를 파일에 기록
	            writer.write("Medicine" + " / " + medicine.getName() + " / " + medicine.getStock() + " / " + medicine.getImage() + " / " + medicine.getInstruction());
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	        error = true;
	    }
	    return error;
	}

	public boolean deleteProduct(String name) {
	    boolean error = false;
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);

	    try {
	        List<String> lines = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                lines.add(line);
	            }
	        }
	        boolean found = false;
	        for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
	            String line = iterator.next();
	            String[] productDetails = line.split(" / ");
	            if (productDetails.length >= 2 && productDetails[1].equals(name)) {
	                iterator.remove();
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            error = true;
	        } else {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	                for (String line : lines) {
	                    writer.write(line);
	                    writer.newLine();
	                }
	            }
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        error = true;
	    }
	    return error;
	}
	
	public void sortion(int option) {
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        List<String> medicines = new ArrayList<>();
	        List<String> foods = new ArrayList<>();
	        
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Medicine")) {
	                medicines.add(line);
	            } else if (line.startsWith("Food")) {
	                foods.add(line);
	            }
	        }
	        
	        Collections.sort(medicines); 
	        Collections.sort(foods); 
	        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            if (option == 1) {
	                for (String medicine : medicines) {
	                    writer.write(medicine);
	                    writer.newLine();
	                }
	                for (String food : foods) {
	                    writer.write(food);
	                    writer.newLine();
	                }
	            } else if (option == 2) {
	                for (String food : foods) {
	                    writer.write(food);
	                    writer.newLine();
	                }
	                for (String medicine : medicines) {
	                    writer.write(medicine);
	                    writer.newLine();
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void stockPlus(String name) {
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);

	    try {
	        List<String> lines = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                lines.add(line);
	            }
	        }
	        for (int i = 0; i < lines.size(); i++) {
	            String line = lines.get(i);
	            String[] productDetails = line.split(" / ");
	        
	            if (productDetails.length >= 3 && productDetails[1].equals(name)) {
	                int stock = Integer.parseInt(productDetails[2]);
	                stock++;
	                productDetails[2] = Integer.toString(stock);
	                lines.set(i, String.join(" / ", productDetails));
	                break;
	            }
	        }
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

	
	public void stockMinus(String name) {
	    String filePath = "src/Repository/Productlist.txt";
	    File file = new File(filePath);

	    try {
	        List<String> lines = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                lines.add(line);
	            }
	        }
	        for (int i = 0; i < lines.size(); i++) {
	            String line = lines.get(i);
	            String[] productDetails = line.split(" / ");
	            if (productDetails.length >= 3 && productDetails[1].equals(name)) {
	                int stock = Integer.parseInt(productDetails[2]);
	                if (stock > 0) stock--;
	                productDetails[2] = Integer.toString(stock);
	                lines.set(i, String.join(" / ", productDetails));
	                break;
	            }
	        }
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
}
