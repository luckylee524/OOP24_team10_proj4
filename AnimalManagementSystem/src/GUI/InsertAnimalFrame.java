package GUI;

import AnimalManage.Animal;
import AnimalManage.AnimalManageSystem;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class InsertAnimalFrame extends JFrame{
	private File imageFile;
	
	public InsertAnimalFrame(AnimalManageSystem animalManageSystem, AnimalSection animalSection, MainFrame parentFrame) {
		super("Insert New Animal");
		setLayout(new BorderLayout(5,5));
		
		Font textFont = new Font("Tahoma", Font.BOLD,13);
		Font buttonFont = new Font("Tahoma", Font.BOLD,13);

		
		//SOUTH
		JPanel southPanel = new JPanel(new GridLayout(1,3));
		
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JButton insert = new JButton("INSERT");
		
		insert.setFont(buttonFont);
		
		southPanel.add(blank1);
		southPanel.add(insert);
		southPanel.add(blank2);
		
		//WEST
		JPanel westPanel = new JPanel(new GridLayout(1,1));
		JButton imageBtn = new JButton("	Select Image File	");
		
		westPanel.add(imageBtn);
		
		//EAST
		JPanel eastPanel = new JPanel(new GridLayout(7,2));
		
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
		
		eastPanel.add(species);
		eastPanel.add(speciesText);
		eastPanel.add(name);
		eastPanel.add(nameText);
		eastPanel.add(age);
		eastPanel.add(ageText);
		eastPanel.add(gender);
		eastPanel.add(genderText);
		eastPanel.add(foundLocation);
		eastPanel.add(foundLocationText);
		eastPanel.add(adoptionStatus);
		eastPanel.add(adoptionStatusText);
		eastPanel.add(vaccinationStatus);
		eastPanel.add(vaccinationText);
		
		add(westPanel,BorderLayout.CENTER);
		add(eastPanel,BorderLayout.EAST);
		add(southPanel,BorderLayout.SOUTH);
		
		imageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");
				fileChooser.setFileFilter(filter);
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					imageFile = selectedFile;
	                ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
	                Image image = imageIcon.getImage().getScaledInstance(200, 140, Image.SCALE_SMOOTH);
	                JLabel imageLabel = new JLabel();
	                imageLabel.setIcon(new ImageIcon(image));
	                westPanel.remove(imageBtn);
	                westPanel.add(imageLabel,BorderLayout.WEST);
	                add(westPanel,BorderLayout.CENTER);
	                repaint();
	                revalidate();
				}
			}
		});
		
		
		/////////////////////////////////////////////
		//***connection here(텍스트 필드의 정보로 새로운 객체 생성)
		/////////////////////////////////////////////
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String imageGet = null;
				try {
					imageGet = imageFile.getCanonicalPath();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Boolean error = animalManageSystem.insertAnimalFile(new Animal(speciesText.getText(),nameText.getText(),
						Integer.parseInt(ageText.getText()),genderText.getText(),foundLocationText.getText(),adoptionStatusText.getText(),
						vaccinationText.getText(),imageGet));
				if (error) {
					JOptionPane.showMessageDialog(null, "오류가 발생하였습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "정상적으로 입력되었습니다.", "입력 성공", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}

				animalSection.ChangeAnimalSection();
			}
		});
		
		
		
		setSize(600,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	

}
