package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import AnimalManage.Animal;

public class MainFrame extends JFrame{
	private Animal selectedAnimal;

	public MainFrame() {
		super("ANIMAL INFOMATION");
		setLayout(new BorderLayout(5,5));
	
		
		//Font
		Font textFont = new Font("Tahoma", Font.BOLD,13);
		Font buttonFont = new Font("Tahoma", Font.BOLD,13);
		
		//South Panel
		JPanel southPanel = new JPanel(new FlowLayout());
		JButton insertAnimal = new JButton("INSERT ANIMAL");
		insertAnimal.setFont(buttonFont);
		southPanel.add(insertAnimal);
		JButton deleteAnimal = new JButton("DELETE ANIMAL");
		deleteAnimal.setFont(buttonFont);
		southPanel.add(deleteAnimal);
		JButton search = new JButton("SEARCH");
		search.setFont(buttonFont);
		southPanel.add(search);
		JButton sortingOption = new JButton("SORTING OPTION");
		sortingOption.setFont(buttonFont);
		southPanel.add(sortingOption);

		
		add(southPanel, BorderLayout.SOUTH);
		
		//North Panel
		JButton productButton = new JButton("PRODUCT");
		productButton.setFont(buttonFont);
		
		add(productButton, BorderLayout.NORTH);
		
		
		//Center Panel
		new AnimalSection(MainFrame.this);
		
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductFrame();
				dispose();
			}
		});
		
		insertAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertAnimalFrame(MainFrame.this);
			}
		});
		
		////////////////////////////////////////////////////
		//***connection here(selected 객체를 ArrayList에서 찾아 삭제)
		////////////////////////////////////////////////////
		deleteAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchFrame(MainFrame.this);
			}
		});
		
		sortingOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnimalSortingFrame(MainFrame.this);
			}
		});
		
	}
	
	public void setSelectedPicturePanel(Animal animal) {
		this.selectedAnimal = animal;
	}

}
