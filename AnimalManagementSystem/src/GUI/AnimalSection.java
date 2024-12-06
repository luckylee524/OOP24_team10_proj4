package GUI;

import AnimalManage.Animal;
import AnimalManage.AnimalManageSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class AnimalSection extends JPanel{
	private AnimalList animalList = new AnimalList();
	private AnimalManageSystem animalManageSystem;
	
	public AnimalSection(AnimalManageSystem animalManageSystem, MainFrame parentFrame) {
		////////////////////////////////////////////////////
		//***connection here(Animal ArrayList 활용한 Panel 생성)
		////////////////////////////////////////////////////
		this.animalManageSystem = animalManageSystem;

		removeAll();

		ArrayList<Animal> animals = animalList.getAnimals();

		ArrayList<JPanel> animalPanels = new ArrayList<JPanel>();

		for(int i = 0; i < animals.size(); i++) {
			animalPanels.add(new AnimalPanel(animalManageSystem, animals.get(i), parentFrame));
		}

		if(animalPanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(animalPanels.size(),1,0,10));

		JScrollPane animalScroll = new JScrollPane(this);
		animalScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		parentFrame.add(animalScroll , BorderLayout.CENTER);

		for(int i = 0; i < animals.size(); i++) {
			add(animalPanels.get(i));
		}
	}

	public AnimalSection(MainFrame parentFrame) {

		removeAll();

		ArrayList<Animal> animals = animalList.getAnimals();

		ArrayList<JPanel> animalPanels = new ArrayList<JPanel>();

		for(int i = 0; i < animals.size(); i++) {
			animalPanels.add(new AnimalPanel(animalManageSystem, animals.get(i), parentFrame));
		}

		if(animalPanels.size() < 3) setLayout(new GridLayout(3,1,0,10));
		else setLayout(new GridLayout(animalPanels.size(),1,0,10));

		JScrollPane animalScroll = new JScrollPane(this);
		animalScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		parentFrame.add(animalScroll , BorderLayout.CENTER);

		for(int i = 0; i < animals.size(); i++) {
			add(animalPanels.get(i));
		}
	}

	public void ChangeAnimalSection(ArrayList<Animal> animals) {
		// 기존 패널의 모든 컴포넌트 제거
		this.removeAll();

		// 새로운 AnimalPanel 리스트 생성
		ArrayList<JPanel> animalPanels = new ArrayList<>();
		for (Animal animal : animals) {
			animalPanels.add(new AnimalPanel(animalManageSystem, animal, null)); // null은 MainFrame 참조를 대체 (필요에 따라 수정)
		}

		// 레이아웃 설정: 최소 3개의 행을 갖도록 조정
		if (animalPanels.size() < 3) {
			setLayout(new GridLayout(3, 1, 0, 10));
		} else {
			setLayout(new GridLayout(animalPanels.size(), 1, 0, 10));
		}

		// 새로운 AnimalPanel들을 추가
		for (JPanel panel : animalPanels) {
			add(panel);
		}

		// UI 갱신
		revalidate();
		repaint();
	}

	public void ChangeAnimalSection() {
		// 기존 패널의 모든 컴포넌트 제거
		this.removeAll();

		animalList.changeAnimalList();
		ArrayList<Animal> animals = animalList.getAnimals();

		// 새로운 AnimalPanel 리스트 생성
		ArrayList<JPanel> animalPanels = new ArrayList<>();
		for (Animal animal : animals) {
			animalPanels.add(new AnimalPanel(animalManageSystem, animal, null)); // null은 MainFrame 참조를 대체 (필요에 따라 수정)
		}

		// 레이아웃 설정: 최소 3개의 행을 갖도록 조정
		if (animalPanels.size() < 3) {
			setLayout(new GridLayout(3, 1, 0, 10));
		} else {
			setLayout(new GridLayout(animalPanels.size(), 1, 0, 10));
		}

		// 새로운 AnimalPanel들을 추가
		for (JPanel panel : animalPanels) {
			add(panel);
		}

		// UI 갱신
		revalidate();
		repaint();
	}
}



