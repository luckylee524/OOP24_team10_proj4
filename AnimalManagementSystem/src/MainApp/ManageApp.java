package src.MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.AnimalManage.AnimalManageApp;
import ProductManage.ProductManageApp;
import src.AnimalManage.AnimalManageSystem;
import src.AnimalManage.AnimalManageSystemImpl;

public class ManageApp {
	public static void main(String[] args) {
        JFrame frame = new JFrame("App Manager");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 설정
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // 두 화면 추가
        AnimalManageApp animalManageApp = new AnimalManageApp();
        ProductManageApp medicineManageApp = new ProductManageApp();

        /*
        mainPanel.add(animalManageApp.getPanel(), "AnimalManage");
        mainPanel.add(medicineManageApp.getPanel(), "ProductManageApp");
		*/
        
        // 우측 상단 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 우측 정렬
        JButton button1 = new JButton("1번 화면");
        JButton button2 = new JButton("2번 화면");

        // 1번 화면
        animalManageApp.initialize();
        
        /*
        // 버튼에 화면 전환 기능 추가
        button1.addActionListener(e -> cardLayout.show(mainPanel, "AnimalManage"));
        button2.addActionListener(e -> cardLayout.show(mainPanel, "ProductManageApp"));
		*/
		
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // 프레임 구성
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH); // 상단에 버튼 패널 추가
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}