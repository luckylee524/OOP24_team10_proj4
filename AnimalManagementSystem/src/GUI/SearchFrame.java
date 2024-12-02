package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchFrame extends JFrame{
	
	public SearchFrame(MainFrame parentFrame) {
		super("Search Animal");
		setLayout(new BorderLayout(5,5));
		
		Font textFont = new Font("Tahoma", Font.BOLD,13);
		Font buttonFont = new Font("Tahoma", Font.BOLD,13);
		
		//WEST and EAST
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		
		//SOUTH
		JPanel southPanel = new JPanel(new GridLayout(1,3));
		
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JButton search = new JButton("SEARCH");
		
		search.setFont(buttonFont);
		
		southPanel.add(blank1);
		southPanel.add(search);
		southPanel.add(blank2);
		
		
		//CENTER
		JPanel centerPanel = new JPanel(new GridLayout(7,2));
		
		JLabel species = new JLabel("SPECIES :");
		JLabel name = new JLabel("NAME :");
		JLabel age = new JLabel("AGE :");
		JLabel gender = new JLabel("GENDER :");
		JLabel foundLocation = new JLabel("FOUND LOCATION :   ");
		JLabel adoptionStatus = new JLabel("ADOPTION STATUS :   ");
		JLabel vaccinationStatus = new JLabel("VACCINATION STATUS :   ");
		
		species.setFont(textFont);
		name.setFont(textFont);
		age.setFont(textFont);
		gender.setFont(textFont);
		foundLocation.setFont(textFont);
		adoptionStatus.setFont(textFont);
		vaccinationStatus.setFont(textFont);
		
		JTextField speciesText = new JTextField(15);
		JTextField nameText = new JTextField(15);
		JTextField ageText = new JTextField(15);
		JTextField genderText = new JTextField(15);
		JTextField foundLocationText = new JTextField(15);
		JTextField adoptionStatusText = new JTextField(15);
		JTextField vaccinationText = new JTextField(15);
		
		centerPanel.add(species);
		centerPanel.add(speciesText);
		centerPanel.add(name);
		centerPanel.add(nameText);
		centerPanel.add(age);
		centerPanel.add(ageText);
		centerPanel.add(gender);
		centerPanel.add(genderText);
		centerPanel.add(foundLocation);
		centerPanel.add(foundLocationText);
		centerPanel.add(adoptionStatus);
		centerPanel.add(adoptionStatusText);
		centerPanel.add(vaccinationStatus);
		centerPanel.add(vaccinationText);
		
		//JPanel 
		add(westPanel,BorderLayout.WEST);
		add(eastPanel,BorderLayout.EAST);
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		
		
		/////////////////////////////////////////
		//***connection here(정렬 기준 선택에 따른 정렬 수행)
		/////////////////////////////////////////
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SearchResultFrame(parentFrame);
			}
		});
		
		
		setSize(600,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
