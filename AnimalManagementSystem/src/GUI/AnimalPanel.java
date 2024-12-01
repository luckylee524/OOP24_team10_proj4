package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import AnimalManage.Animal;

public class AnimalPanel extends JPanel{
	private static AnimalPanel lastClickedPanel = null;
	private MainFrame parentFrame;
	private Animal animal;
	
	public AnimalPanel(MainFrame parentFrame) {
		
		setLayout(new BorderLayout(5,5));
		setBorder(new LineBorder(Color.gray));
		
		Font textFont = new Font("Verdana", Font.BOLD,15);
		Font contentFont = new Font("SansSerif", Font.PLAIN,15);
		
		
		/////////////////////////////
		//***connection here(이미지 로드)
		/////////////////////////////
		//WEST
		ImageIcon iconTemp = new ImageIcon("C:\\lion.jpg");
		Image originalImage = iconTemp.getImage();
		Image resizedImage = originalImage.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		
		JLabel imageLabel = new JLabel(resizedImageIcon);
		imageLabel.addMouseListener(new ClickListener(this));
		add(imageLabel,BorderLayout.WEST);
		
		//EAST
		//Animal content
		JPanel east = new JPanel();
		east.addMouseListener(new ClickListener(this));
		east.setLayout(new BorderLayout(5,5));
		east.setBorder(new LineBorder(new Color(100, 180, 240)));
		
		JPanel animalInfo = new JPanel();
		animalInfo.setLayout(new GridLayout(5, 2));
		JLabel species = new JLabel("• SPECIES");
		JLabel name = new JLabel("• NAME");
		JLabel age = new JLabel("• AGE");
		JLabel gender = new JLabel("• GENDER");
		JLabel foundLocation = new JLabel("• FOUND LOCATION    ");
		species.setFont(textFont);
		name.setFont(textFont);
		age.setFont(textFont);
		gender.setFont(textFont);
		foundLocation.setFont(textFont);
		
		/////////////////////////////////
		//***connection here(Animal 객체 정보)
		/////////////////////////////////
		JLabel speciesContent = new JLabel("Lion");
		JLabel nameContent = new JLabel("Cooma");
		JLabel ageContent = new JLabel("13");
		JLabel genderContent = new JLabel("male");
		JLabel foundLocationContent = new JLabel("Africa");
		speciesContent.setFont(contentFont);
		nameContent.setFont(contentFont);
		ageContent.setFont(contentFont);
		genderContent.setFont(contentFont);
		foundLocationContent.setFont(contentFont);
		
		animalInfo.add(species);
		animalInfo.add(speciesContent);
		animalInfo.add(name);
		animalInfo.add(nameContent);
		animalInfo.add(age);
		animalInfo.add(ageContent);
		animalInfo.add(gender);
		animalInfo.add(genderContent);
		animalInfo.add(foundLocation);
		animalInfo.add(foundLocationContent);
		
		
		//Adopt Content
		JPanel eastPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.insets = new Insets(5, 5, 5, 5);

        
        JLabel adoptionStatus = new JLabel("adoption Status");
        JLabel vaccinationStatus = new JLabel("Vaccination Status");
        adoptionStatus.setFont(textFont);
        vaccinationStatus.setFont(textFont);
        
        
        JButton btn1 = new JButton("Processing");
        btn1.setBackground(new Color(192, 192, 192));
        JButton btn2 = new JButton("Approved");
        btn2.setBackground(new Color(192, 192, 192));
        JButton btn3 = new JButton("Adopted");
        btn3.setBackground(new Color(192, 192, 192));
        JButton btn4 = new JButton("YES");
        btn4.setBackground(new Color(192, 192, 192));
        JButton btn5 = new JButton("NO");
        btn5.setBackground(new Color(192, 192, 192));
        
        JPanel adoptionButton = new JPanel(new GridLayout(1,3,5,5));
        adoptionButton.add(btn1);
        adoptionButton.add(btn2);
        adoptionButton.add(btn3);
        
        JPanel vaccinationButton = new JPanel(new GridLayout(1,2,5,5));
        vaccinationButton.add(btn4);
        vaccinationButton.add(btn5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        eastPanel.add(adoptionStatus, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        eastPanel.add(adoptionButton, gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        eastPanel.add(vaccinationStatus, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        eastPanel.add(vaccinationButton, gbc);

        
        east.add(animalInfo,BorderLayout.WEST);
        east.add(eastPanel, BorderLayout.CENTER);
		add(east,BorderLayout.CENTER);
        		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setBackground(new Color(108, 108, 108));
				btn2.setBackground(new Color(192, 192, 192));
				btn3.setBackground(new Color(192, 192, 192));
				JOptionPane.showMessageDialog(parentFrame, "STATUS UPDATED!", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setBackground(new Color(108, 108, 108));
				btn1.setBackground(new Color(192, 192, 192));
				btn3.setBackground(new Color(192, 192, 192));
				JOptionPane.showMessageDialog(parentFrame, "STATUS UPDATED!", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(new Color(108, 108, 108));
				btn1.setBackground(new Color(192, 192, 192));
				btn2.setBackground(new Color(192, 192, 192));
				JOptionPane.showMessageDialog(parentFrame, "STATUS UPDATED!", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setBackground(new Color(108, 108, 108));
				btn5.setBackground(new Color(192, 192, 192));
				JOptionPane.showMessageDialog(parentFrame, "STATUS UPDATED!", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setBackground(new Color(108, 108, 108));
				btn4.setBackground(new Color(192, 192, 192));
				JOptionPane.showMessageDialog(parentFrame, "STATUS UPDATED!", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
	
	public AnimalPanel() {
		setLayout(new BorderLayout(5,5));
		setBorder(new LineBorder(Color.gray));
		
		Font textFont = new Font("Verdana", Font.BOLD,15);
		Font contentFont = new Font("SansSerif", Font.PLAIN,15);
		
		
		/////////////////////////////
		//***connection here(이미지 로드)
		/////////////////////////////
		//WEST
		ImageIcon iconTemp = new ImageIcon("C:\\lion.jpg");
		Image originalImage = iconTemp.getImage();
		Image resizedImage = originalImage.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		
		JLabel imageLabel = new JLabel(resizedImageIcon);
		imageLabel.addMouseListener(new ClickListener(this));
		add(imageLabel,BorderLayout.WEST);
		
		//EAST
		//Animal content
		JPanel east = new JPanel();
		east.addMouseListener(new ClickListener(this));
		east.setLayout(new BorderLayout(5,5));
		east.setBorder(new LineBorder(new Color(100, 180, 240)));
		
		JPanel animalInfo = new JPanel();
		animalInfo.setLayout(new GridLayout(5, 2));
		JLabel species = new JLabel("• SPECIES");
		JLabel name = new JLabel("• NAME");
		JLabel age = new JLabel("• AGE");
		JLabel gender = new JLabel("• GENDER");
		JLabel foundLocation = new JLabel("• FOUND LOCATION    ");
		species.setFont(textFont);
		name.setFont(textFont);
		age.setFont(textFont);
		gender.setFont(textFont);
		foundLocation.setFont(textFont);
		
		///////////////////////////////////
		//***connection here(Animal 객체 정보)
		///////////////////////////////////
		JLabel speciesContent = new JLabel("Lion");
		JLabel nameContent = new JLabel("Cooma");
		JLabel ageContent = new JLabel("13");
		JLabel genderContent = new JLabel("male");
		JLabel foundLocationContent = new JLabel("Africa");
		speciesContent.setFont(contentFont);
		nameContent.setFont(contentFont);
		ageContent.setFont(contentFont);
		genderContent.setFont(contentFont);
		foundLocationContent.setFont(contentFont);
		
		animalInfo.add(species);
		animalInfo.add(speciesContent);
		animalInfo.add(name);
		animalInfo.add(nameContent);
		animalInfo.add(age);
		animalInfo.add(ageContent);
		animalInfo.add(gender);
		animalInfo.add(genderContent);
		animalInfo.add(foundLocation);
		animalInfo.add(foundLocationContent);
		
		
		//Adopt Content
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.insets = new Insets(5, 5, 5, 5);

        
        JLabel adoptionStatus = new JLabel("adoption Status");
        JLabel vaccinationStatus = new JLabel("Vaccination Status");
        adoptionStatus.setFont(textFont);
        vaccinationStatus.setFont(textFont);
        
        
        JButton btn1 = new JButton("Processing");
        btn1.setBackground(new Color(192, 192, 192));
        JButton btn2 = new JButton("Approved");
        btn2.setBackground(new Color(192, 192, 192));
        JButton btn3 = new JButton("Adopted");
        btn3.setBackground(new Color(192, 192, 192));
        JButton btn4 = new JButton("YES");
        btn4.setBackground(new Color(192, 192, 192));
        JButton btn5 = new JButton("NO");
        btn5.setBackground(new Color(192, 192, 192));
        
        JPanel adoptionButton = new JPanel(new GridLayout(1,3,5,5));
        adoptionButton.add(btn1);
        adoptionButton.add(btn2);
        adoptionButton.add(btn3);
        
        JPanel vaccinationButton = new JPanel(new GridLayout(1,2,5,5));
        vaccinationButton.add(btn4);
        vaccinationButton.add(btn5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(adoptionStatus, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(adoptionButton, gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(vaccinationStatus, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(vaccinationButton, gbc);

        
        east.add(animalInfo,BorderLayout.WEST);
        east.add(mainPanel, BorderLayout.CENTER);
		add(east,BorderLayout.CENTER);
	}
	
	private class ClickListener extends MouseAdapter{
		private AnimalPanel panel;
		
		public ClickListener(AnimalPanel panel) {
			this.panel = panel;
		};
		
		public void mouseClicked(MouseEvent e) {
			if (lastClickedPanel != null) {
                lastClickedPanel.setBorder(new LineBorder(Color.gray));
            }
            panel.setBorder(new LineBorder(Color.RED));
            lastClickedPanel = panel;
            parentFrame.setSelectedPicturePanel(lastClickedPanel.animal);
		}
	}
}


