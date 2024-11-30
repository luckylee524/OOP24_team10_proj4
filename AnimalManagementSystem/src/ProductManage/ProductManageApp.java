package ProductManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductManageApp {

    private JPanel mainPanel;
    private JButton insertButton; // insertButton을 멤버 변수로 선언
    private JButton deleteButton; // deleteButton을 멤버 변수로 선언
    private JButton sortButton;   // sortButton을 멤버 변수로 선언
    ProductManageSystem productManageSystem = new ProductManageSystemImpl();

    public ProductManageApp() {
        // JPanel 생성 및 레이아웃 설정
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        // 1번 버튼: 물품 삽입
        insertButton = new JButton("물품 삽입");

        // 2번 버튼: 객체 삭제
        deleteButton = new JButton("물품 삭제");

        // 3번 버튼: 정렬
        sortButton = new JButton("정렬");

        // 팝업 메뉴 생성 (물품 삽입용)
        JPopupMenu insertPopupMenu = new JPopupMenu();
        JMenuItem option1 = new JMenuItem("의약품 삽입");
        JMenuItem option2 = new JMenuItem("음식 삽입");

        // 메뉴 아이템 클릭 이벤트 처리
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 옵션 1 선택 시 입력 폼 창 열기
                showInputDialog("의약품");
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 옵션 2 선택 시 입력 폼 창 열기
                showInputDialog("음식");
            }
        });

        // 팝업 메뉴에 아이템 추가
        insertPopupMenu.add(option1);
        insertPopupMenu.add(option2);

        // 물품 삽입 버튼 클릭 시 팝업 메뉴 표시
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showInsertPopupMenu(insertButton, insertPopupMenu); // 팝업 메뉴 표시를 위한 메서드 호출
            }
        });

        // 객체 삭제 버튼 클릭 시 이름만 입력 받는 대화상자 표시
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDeleteDialog();
            }
        });

        // 정렬 버튼 클릭 시 정렬 메뉴 팝업 표시
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSortMenu();
            }
        });

        // 버튼을 mainPanel에 추가
        mainPanel.add(insertButton);
        mainPanel.add(deleteButton);
        mainPanel.add(sortButton);
    }

    // mainPanel을 반환하는 메서드
    public JPanel getPanel() {
        return mainPanel;
    }

    // 입력 폼을 보여주는 메서드 (의약품/음식 입력)
    private void showInputDialog(String type) {
        // 입력 폼을 위한 패널 생성
        JPanel inputPanel = new JPanel(new GridLayout(3, 2)); // 3개의 입력 필드를 위한 GridLayout

        // 필드 생성
        JTextField nameField = new JTextField(20);
        JTextField numberField = new JTextField(20);
        JTextArea usageArea = new JTextArea(5, 20);
        usageArea.setLineWrap(true);
        usageArea.setWrapStyleWord(true);

        // 기본적으로 '사용법'을 추가
        JLabel usageLabel = new JLabel("사용법:");
        inputPanel.add(new JLabel("이름:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("개수:"));
        inputPanel.add(numberField);
        inputPanel.add(usageLabel);
        inputPanel.add(new JScrollPane(usageArea));

        // 타입에 따라 라벨 변경
        if (type.equals("음식")) {
            usageLabel.setText("유통기한:");
        }

        // 입력 폼을 표시하는 대화상자
        int option = JOptionPane.showConfirmDialog(null, inputPanel, type + " 정보 입력", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // OK 버튼 클릭 시 입력값 출력
            String name = nameField.getText();
            String number = numberField.getText();
            String usage = usageArea.getText();
            
            if (type.equals("의약품")) {
                Medicine medicine = new Medicine(name, Integer.parseInt(number), usage);
                productManageSystem.insertMedicine(medicine);
            } else if (type.equals("음식")) {
                Food food = new Food(name, Integer.parseInt(number), usage);  // Food 클래스가 있다고 가정
                productManageSystem.insertFood(food);
            }
        }
    }

    // 객체 삭제를 위한 메서드
    private void showDeleteDialog() {
        // 이름 입력 받기
        String name = JOptionPane.showInputDialog(null, "삭제할 물품의 이름을 입력하세요:");
        
        if (name != null && !name.trim().isEmpty()) {
            boolean error = productManageSystem.deleteProduct(name);
            if (error) {
                JOptionPane.showMessageDialog(null, "물품을 찾을 수 없습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "성공적으로 삭제하였습니다.");
            }
        }
    }

    // 정렬을 위한 메뉴 팝업을 표시하는 메서드
    private void showSortMenu() {
        JPopupMenu sortPopupMenu = new JPopupMenu();
        JMenuItem sortOption1 = new JMenuItem("의약품순 정렬");
        JMenuItem sortOption2 = new JMenuItem("음식순 정렬");

        // 각 메뉴 아이템에 대해 선택 시 호출될 함수 등록
        sortOption1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 의약품순 정렬 함수 호출
            	productManageSystem.sortion(1);
            }
        });

        sortOption2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 음식순 정렬 함수 호출
            	productManageSystem.sortion(2);
            }
        });

        // 팝업 메뉴에 아이템 추가
        sortPopupMenu.add(sortOption1);
        sortPopupMenu.add(sortOption2);

        // 정렬 메뉴 표시
        sortPopupMenu.show(sortButton, 0, sortButton.getHeight()); // 이제 sortButton은 멤버 변수로 접근 가능
    }

    // 물품 삽입 팝업 메뉴 표시를 위한 메서드
    private void showInsertPopupMenu(JButton button, JPopupMenu popupMenu) {
        popupMenu.show(button, 0, button.getHeight()); // 버튼 바로 위에 메뉴 표시
    }
}
