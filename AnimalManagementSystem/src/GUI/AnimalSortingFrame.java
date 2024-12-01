package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalSortingFrame extends JFrame{
	public AnimalSortingFrame(MainFrame parentFrame) {
		super("Sorting Option");
		setLayout(new BorderLayout());
		
		Font buttonFont = new Font("Tahoma", Font.BOLD,13);
		
		JRadioButton option1 = new JRadioButton("Sort By Age");
	    JRadioButton option2 = new JRadioButton("Sort By Species");
	    JRadioButton option3 = new JRadioButton("Sort By Name");
		
		ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(option1);
        buttonPanel.add(option2);
        buttonPanel.add(option3);
        
        JPanel selectPanel = new JPanel(new GridLayout(1,3));
        JButton selectButton = new JButton("select");
        JLabel blank1 = new JLabel();
        JLabel blank2 = new JLabel();
        selectPanel.add(blank1);
        selectPanel.add(selectButton);
        selectPanel.add(blank2);
        selectButton.setFont(buttonFont);
        
        add(selectPanel,BorderLayout.SOUTH);
        add(buttonPanel,BorderLayout.CENTER);
        
        //////////////////////////////////////////
        //***connection here(정렬 기준 선택에 따른 정렬 수행)
        //////////////////////////////////////////
        selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (option1.isSelected()) {
                } else if (option2.isSelected()) {
                } else if (option3.isSelected()) {
                }
			}
		});
        
        setSize(400,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
