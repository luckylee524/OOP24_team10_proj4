package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ProductManage.Product;
import ProductManage.ProductManageSystemImpl;
import ProductManage.Food;
import ProductManage.Medicine;


public class ProductPanel extends JPanel{
	private static ProductPanel lastClickedPanel = null;
	private ProductFrame parentFrame;
	private Product product;
	private ProductManageSystemImpl system = new ProductManageSystemImpl();

	
	public ProductPanel(Product product, ProductFrame parentFrame) {
		this.parentFrame = parentFrame;
		this.product = product;
		
		setLayout(new BorderLayout(5,5));
		setBorder(new LineBorder(Color.gray));
		
		Font textFont = new Font("Verdana", Font.BOLD,15);
		Font contentFont = new Font("SansSerif", Font.PLAIN,15);
		
		/////////////////////////////
		//***connection here(이미지 로드)
		/////////////////////////////
		//WEST
		ImageIcon iconTemp = new ImageIcon(product.getImage());
		Image originalImage = iconTemp.getImage();
		Image resizedImage = originalImage.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

		JLabel imageLabel = new JLabel(resizedImageIcon);
		add(imageLabel,BorderLayout.WEST);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.setBorder(new LineBorder(new Color(100, 180, 240)));
		
		
		//WEST
		//Product content
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3, 2));
		
		JLabel name = new JLabel("• NAME");
		JLabel stock = new JLabel("• STOCK");
		name.setFont(textFont);
		stock.setFont(textFont);
		
		//Food or Medicine
		JLabel thirdLabel = new JLabel("• EXPIRATION ");
		JLabel thirdLabelContent = new JLabel("TEST");
		thirdLabel.setFont(textFont);
		thirdLabelContent.setFont(contentFont);
		
		if(product instanceof Food) {
			Food food = (Food) product;
			thirdLabelContent = new JLabel(food.getExpirationDate());
			thirdLabelContent.setFont(contentFont);
		}else if(product instanceof Medicine) {
			thirdLabel = new JLabel("• INSTRUCTION ");
			thirdLabel.setFont(textFont);
			Medicine medicine = (Medicine) product;
			thirdLabelContent = new JLabel(medicine.getInstruction());
			thirdLabelContent.setFont(contentFont);
		}
		
		///////////////////////////////////
		//***connection here(Product 객체 정보)
		///////////////////////////////////
		//JLabel nameContent = new JLabel("Food name TEST");
		JLabel nameContent = new JLabel(product.getName());
		JLabel stockContent = new JLabel(Integer.toString(product.getStock()));
		nameContent.setFont(contentFont);
		stockContent.setFont(contentFont);
		
		westPanel.add(name);
		westPanel.add(nameContent);
		westPanel.add(stock);
		westPanel.add(stockContent);
		westPanel.add(thirdLabel);
		westPanel.add(thirdLabelContent);
		
		//EAST
		//Add or Remove button
		JPanel eastPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.insets = new Insets(5, 5, 5, 5);

		JButton btn1 = new JButton("ADD");
		btn1.setBackground(new Color(192, 192, 192));
		JButton btn2 = new JButton("REMOVE");
		btn2.setBackground(new Color(192, 192, 192));
		
		JPanel buttons = new JPanel(new GridLayout(1,2,5,5));
		buttons.add(btn1);
		buttons.add(btn2);
		
		gbc.gridx = 0; gbc.gridy = 0;
		eastPanel.add(buttons,gbc);
		
		mainPanel.add(westPanel,BorderLayout.WEST);
		mainPanel.add(eastPanel,BorderLayout.EAST);
		add(mainPanel,BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        system.stockPlus(product.getName()); // 재고 증가 처리
		        parentFrame.refreshFrame(); // 프레임 갱신 요청
		    }
		});
		btn2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        system.stockMinus(product.getName()); // 재고 증가 처리
		        parentFrame.refreshFrame(); // 프레임 갱신 요청
		    }
		});
				
	}
	
}
