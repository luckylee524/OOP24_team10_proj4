package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ProductManage.Product;

public class ProductFrame extends JFrame{
	private Product selectedProduct;
	
	ProductFrame(){
		super("PRODUCT INFOMATION");
		setLayout(new BorderLayout(5,5));
		
		//FONT
		Font textFont = new Font("Tahoma", Font.BOLD,13);
		Font buttonFont = new Font("Tahoma", Font.BOLD,13);
		
		//North
		JButton animalButton = new JButton("ANIMAL");
		animalButton.setFont(buttonFont);
				
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout());
		JButton insertProduct = new JButton("INSERT PRODUCT");
		insertProduct.setFont(buttonFont);
		southPanel.add(insertProduct);
		JButton deleteProduct = new JButton("DELETE PRODUCT");
		deleteProduct.setFont(buttonFont);
		southPanel.add(deleteProduct);
		JButton sortingOption = new JButton("SORTING OPTION");
		sortingOption.setFont(buttonFont);
		southPanel.add(sortingOption);
		
		JPopupMenu insertPopupMenu = new JPopupMenu();
        JMenuItem option1 = new JMenuItem("INSERT MEDICINE");
        JMenuItem option2 = new JMenuItem("INSERT FOOD");
        
        insertPopupMenu.add(option1);
        insertPopupMenu.add(option2);

      
		
		//CENTER
		add(new ProductSection(ProductFrame.this),BorderLayout.CENTER);
		
		add(animalButton, BorderLayout.NORTH);
		add(southPanel,BorderLayout.SOUTH);
		
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		animalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				dispose();
			}
		});
		
		insertProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Dimension buttonSize = insertProduct.getSize(); 
                insertPopupMenu.setPreferredSize(new Dimension(buttonSize.width, insertPopupMenu.getPreferredSize().height)); 
                showInsertPopupMenu(insertProduct, insertPopupMenu); 
            }
        });
		
		sortingOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductSortingFrame(ProductFrame.this);
			}
		});
		
		option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new InsertProductFrame(ProductFrame.this, false);
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new InsertProductFrame(ProductFrame.this, true);
            }
        });
	}
	
	public void setSelectedPicturePanel(Product product) {
		this.selectedProduct = product;
	}
	
	private void showInsertPopupMenu(JButton button, JPopupMenu popupMenu) {
        popupMenu.show(button, 0, button.getHeight()); 
    }
}
