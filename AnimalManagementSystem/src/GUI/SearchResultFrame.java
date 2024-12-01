package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SearchResultFrame extends JFrame{
	private ArrayList <AnimalList> animalList = new ArrayList<AnimalList>(); 
	
	public SearchResultFrame(MainFrame parentFrame) {
		super("Search Result");
		setLayout(new BorderLayout());
		
		JPanel searchSection = new JPanel(new BorderLayout());
		
		ArrayList<JPanel> animalPanels = new ArrayList<JPanel>();
		
		
		////////////////////////////////////////////////////
		//***connection here(Animal ArrayList 활용한 Panel 생성)
		////////////////////////////////////////////////////
		/*for(int i = 0; i < animalList.size(); i++) {
			animalPanels.add(new AnimalPanel(animalList.get(i), parentFrame));
		}
		
		if(picturePanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(picturePanels.size(),1,0,10));*/
		searchSection.setLayout(new GridLayout(3,1,0,10));
		
		animalPanels.add(new AnimalPanel());
		
		JScrollPane pictureScroll = new JScrollPane(searchSection);
		pictureScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(pictureScroll , BorderLayout.CENTER);
				
		/*for(int i = 0; i < animalList.size(); i++) {
			add(animalPanels.get(i));
		}*/
		
		searchSection.add(animalPanels.get(0));
		
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
