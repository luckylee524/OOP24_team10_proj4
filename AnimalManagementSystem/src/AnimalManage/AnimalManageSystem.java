package AnimalManage;

import java.util.List;

// id 없이 이름으로 동물 구별!
public interface AnimalManageSystem {
	public List<Animal> loadAnimals();
	public void saveAnimals(List<Animal> animals);
	// 동물 추가
	public boolean insertAnimalFile(Animal animal);
	// 관리되고 있는 동물 삭제
	public Boolean deleteAnimal(String name);
	// 나이로 정렬
	public void sortAnimal();
	public void sortAnimalByName();
	public void sortAnimalBySpecies();
	// 동물 이름으로 검색
	public List<Animal> search(String speciesText, String nameText, String ageText, String genderText, String foundLocationText, String adoptionStatusText,
							   String vaccinationText);
	public void updateAdoptionStatus(String name, String status);
	public void updateVaccinationStatus(String name, String status);
}
