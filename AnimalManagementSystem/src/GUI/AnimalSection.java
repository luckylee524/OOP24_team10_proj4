package GUI;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;


public class AnimalSection extends JPanel{
	private ArrayList <AnimalList> animalList = new ArrayList<AnimalList>(); 
	
	public AnimalSection(MainFrame parentFrame) {
		ArrayList<JPanel> animalPanels = new ArrayList<JPanel>();
		
		////////////////////////////////////////////////////
		//***connection here(Animal ArrayList 활용한 Panel 생성)
		////////////////////////////////////////////////////
		/*for(int i = 0; i < animalList.size(); i++) {
			animalPanels.add(new AnimalPanel(animalList.get(i), parentFrame));
		}
		
		if(picturePanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(picturePanels.size(),1,0,10));*/
		setLayout(new GridLayout(3,1,0,10));
		
		animalPanels.add(new AnimalPanel(parentFrame));
		
		JScrollPane animalScroll = new JScrollPane(this);
		animalScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		parentFrame.add(animalScroll , BorderLayout.CENTER);
				
		/*for(int i = 0; i < animalList.size(); i++) {
			add(animalPanels.get(i));
		}*/
		add(animalPanels.get(0));
		
	}
}



