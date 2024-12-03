package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import ProductManage.Product;
import ProductManage.ProductManageSystemImpl;

public class ProductFrame extends JFrame{
	private ProductManageSystemImpl system = new ProductManageSystemImpl();
	
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
		new ProductSection(ProductFrame.this);
		
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
		
		deleteProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDeleteDialog();
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
	
	private void showInsertPopupMenu(JButton button, JPopupMenu popupMenu) {
        popupMenu.show(button, 0, button.getHeight()); 
    }
	
    private void showDeleteDialog() {
        String name = JOptionPane.showInputDialog(null, "삭제할 물품의 이름을 입력하세요:");
        
        if (name != null && !name.trim().isEmpty()) {
            boolean error = system.deleteProduct(name);
            if (error) {
                JOptionPane.showMessageDialog(null, "물품을 찾을 수 없습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "성공적으로 삭제하였습니다.");
            }
        }
        refreshFrame();
    }
    
    public void refreshFrame() {
    	for (Component comp : getContentPane().getComponents()) {
	        if (comp instanceof JScrollPane) {
	            remove(comp);
	        }
	    }

		new ProductSection(ProductFrame.this);
		repaint();
		revalidate();
    }
}
