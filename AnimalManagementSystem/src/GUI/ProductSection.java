package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductSection extends JPanel{
	private ArrayList <ProductList> productList = new ArrayList<ProductList>(); 
	
	public ProductSection(ProductFrame parentFrame) {
		ArrayList<JPanel> productPanels = new ArrayList<JPanel>();
		
		
		////////////////////////////////////////////////////
		//***connection here(Animal ArrayList 활용한 Panel 생성)
		////////////////////////////////////////////////////
		/*for(int i = 0; i < animalList.size(); i++) {
			animalPanels.add(new AnimalPanel(animalList.get(i), parentFrame));
		}
	
		if(picturePanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(picturePanels.size(),1,0,10));*/
		setLayout(new GridLayout(3,1,0,10));
		
		productPanels.add(new ProductPanel(parentFrame));

		
		JScrollPane productScroll = new JScrollPane(this);
		productScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		parentFrame.add(productScroll , BorderLayout.CENTER);
		
		/*for(int i = 0; i < animalList.size(); i++) {
			add(animalPanels.get(i));
		}*/	
		
		add(productPanels.get(0));
	}

}
