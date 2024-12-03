package GUI;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import ProductManage.Product;

public class ProductSection extends JPanel {
    private ProductList productList = new ProductList();

    public ProductSection(ProductFrame parentFrame) {
        // 기존의 Panel들을 모두 지우고 새로운 목록을 만들어서 갱신
        removeAll();  // 기존에 있던 모든 컴포넌트를 지운다.
        
        // 제품 목록을 불러와서 각 제품에 대한 Panel 생성
        ArrayList<Product> products = productList.getProducts();
        
        ArrayList<JPanel> productPanels = new ArrayList<JPanel>();
        
        for (int i = 0; i < products.size(); i++) {
            productPanels.add(new ProductPanel(products.get(i), parentFrame)); // Product 객체를 전달
        }
        
        if(productPanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(productPanels.size(),1,0,10)); // 레이아웃 설정
        
        // 화면 갱신: JScrollPane 추가
        JScrollPane productScroll = new JScrollPane(this);
        productScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        parentFrame.add(productScroll, BorderLayout.CENTER);  // 부모 프레임에 JScrollPane을 추가
        
        for (int i = 0; i < products.size(); i++) {
            add(productPanels.get(i));  // 새로운 Panel을 추가
        }
    }
}

