package GUI;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import ProductManage.Product;
import ProductManage.Food;
import ProductManage.Medicine;
import ProductManage.ProductManageSystemImpl;

public class InsertProductFrame extends JFrame{
	private File imageFile;
	private Product product;
	private ProductManageSystemImpl system = new ProductManageSystemImpl();

	public InsertProductFrame(ProductFrame parentFrame, boolean isFood) {
		super("Insert New Food");
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
		JPanel eastPanel = new JPanel(new GridLayout(5,2));
		
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		JLabel blank5 = new JLabel();
		JLabel blank6 = new JLabel();

		JLabel name = new JLabel("NAME :");
		JLabel stock = new JLabel("Quantity :");
		JLabel expiration = new JLabel("EXPIRATION :");
		if(!(isFood)) expiration = new JLabel("INSTRUCTION :");
		
		name.setFont(textFont);
		stock.setFont(textFont);
		expiration.setFont(textFont);
		
		JTextField nameText = new JTextField(15);
		JTextField stockText = new JTextField(15);
		JTextField expirationText = new JTextField(15);
		
		
		eastPanel.add(blank3);
		eastPanel.add(blank4);
		eastPanel.add(name);
		eastPanel.add(nameText);
		eastPanel.add(stock);
		eastPanel.add(stockText);
		eastPanel.add(expiration);
		eastPanel.add(expirationText);
		eastPanel.add(blank5);
		eastPanel.add(blank6);

		
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
		
		////////////////////////////////////////////
		//***connection here(텍스트 필드 정보로 새로운 객체 생성)
		////////////////////////////////////////////
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			    if(imageFile == null || (nameText.getText()).isEmpty() || (stockText.getText()).isEmpty() || (expirationText.getText()).isEmpty()) {
			    	JOptionPane.showMessageDialog(InsertProductFrame.this, "EMPTY INPUT DETECTED");
			    }else {
			    	
			    	String nameGet = nameText.getText();
				    int stockGet = Integer.parseInt(stockText.getText()); 
				    String textGet = expirationText.getText();
				    
				    String imageGet = null;
				    try { 
				    	imageGet = imageFile.getCanonicalPath();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			    	
			    	if (isFood) {
					    product = new Food(nameGet, stockGet, imageGet, textGet);
					    Food food = (Food) product;// 올바른 데이터로 Food 객체 생성
					    Boolean error = system.insertFood(food);
					    if (error) {
			                JOptionPane.showMessageDialog(null, "오류가 발생하였습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(null, "정상적으로 입력되었습니다.", "입력 성공", JOptionPane.INFORMATION_MESSAGE);
			                dispose();
			            }
					    // ProductSection 클래스 실행 (화면 갱신)
					    parentFrame.refreshFrame();
					    dispose();
					}
					else {
						product = new Medicine(nameGet, stockGet, imageGet, textGet);
					    Medicine medicine = (Medicine) product;// 올바른 데이터로 Food 객체 생성
					    Boolean error = system.insertMedicine(medicine);
					    if (error) {
			                JOptionPane.showMessageDialog(null, "오류가 발생하였습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(null, "정상적으로 입력되었습니다.", "입력 성공", JOptionPane.INFORMATION_MESSAGE);
			                dispose();
			            }
					    parentFrame.refreshFrame();
				        dispose();
					}
			    }
				
			}
		});
		
		setSize(600,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
