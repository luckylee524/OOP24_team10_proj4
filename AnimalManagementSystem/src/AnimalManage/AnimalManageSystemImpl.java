package AnimalManage;

import ProductManage.Food;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalManageSystemImpl implements AnimalManageSystem {

	private static final String FILE_NAME = "src/Repository/AnimalList.txt";
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public List<Animal> loadAnimals() {
		List<Animal> animals = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(" / ");
				if (data.length == 8) {
					String species = data[0];
					String name = data[1];
					int age = Integer.parseInt(data[2]);
					String gender = data[3];
					String foundLocation = data[4];
					String adoptionStatus = data[5];
					String vaccinationStatus = data[6];
					String imagePath = data[7];
					animals.add(new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus, imagePath));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The data file does not exist. Creating a new one.");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return animals;
	}

	// Save to the text file
	@Override
	public void saveAnimals(List<Animal> animals) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (Animal animal : animals) {
				writer.write(String.format("%s / %s / %d / %s / %s / %s / %s / %s%n",
						animal.getSpecies(),
						animal.getName(),
						animal.getAge(),
						animal.getGender(),
						animal.getFoundLocation(),
						animal.getAdoptionStatus(),
						animal.getVaccinationStatus(),
						animal.getImagePath()));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public boolean insertAnimalFile(Animal animal) {
		boolean error = false;
		String filePath = "src/Repository/AnimalList.txt";
		File file = new File(filePath);
		boolean isDuplicate = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(file));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] animalDetails = line.split(" / ");
				if (animalDetails.length >= 2 && animalDetails[1].equals(animal.getName())) {
					isDuplicate = true;
					break;
				}
			}

			if (isDuplicate) {
				error = true;
			} else {
				// 파일이 비어있지 않으면 newLine()을 호출하여 줄바꿈 추가
				if (file.length() > 0) {
					writer.newLine();
				}
				// 데이터를 파일에 기록
				writer.write(animal.getSpecies() + " / " + animal.getName() + " / " + animal.getAge() + " / "
						+ animal.getGender() + " / " + animal.getFoundLocation() + " / " + animal.getAdoptionStatus()
						+ " / " + animal.getVaccinationStatus() + " / " + animal.getImagePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
			error = true;
		}
		return error;
	}

	@Override
	public void insertAnimal(String species, String name, Integer age, String gender, String foundLocation, String adoptionStatus, String vaccinationStatus, String imagePath) {
		List<Animal> animals = loadAnimals();

		Animal newAnimal = new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus, imagePath);
		animals.add(newAnimal);
		saveAnimals(animals);
	}

	@Override
	public Boolean deleteAnimal(String name) {
		List<Animal> animals = loadAnimals();

		boolean isDeleted = animals.removeIf(animal -> animal.getName().equalsIgnoreCase(name));
		if (isDeleted) {
			saveAnimals(animals);
		}

		return isDeleted;
	}

	// dafault : sort by age
	@Override
	public void sortAnimal() {
		List<Animal> animals = loadAnimals();
		if (animals.isEmpty()) {
			return;
		}

		animals.sort(Comparator.comparingInt(Animal::getAge));
		saveAnimals(animals);
	}

	@Override
	public void sortAnimalByName() {
		List<Animal> animals = loadAnimals();
		if (animals.isEmpty()) {
			return;
		}

		animals.sort(Comparator.comparing(Animal::getName));
		saveAnimals(animals);
	}

	@Override
	public void sortAnimalBySpecies() {
		List<Animal> animals = loadAnimals();
		if (animals.isEmpty()) {
			return;
		}

		animals.sort(Comparator.comparing(Animal::getSpecies));
		saveAnimals(animals);
	}

	@Override
	public List<Animal> search(String speciesText, String nameText, String ageText, String genderText,
							   String foundLocationText, String adoptionStatusText, String vaccinationText) {
		List<Animal> animals = loadAnimals();

		List<Animal> foundAnimals = animals.stream()
				.filter(animal -> speciesText.isEmpty() || animal.getSpecies().equals(speciesText))
				.filter(animal -> nameText.isEmpty() || animal.getName().equals(nameText))
				.filter(animal -> ageText.isEmpty() || animal.getAge() == Integer.parseInt(ageText))
				.filter(animal -> genderText.isEmpty() || animal.getGender().equals(genderText))
				.filter(animal -> foundLocationText.isEmpty() || animal.getFoundLocation().equals(foundLocationText))
				.filter(animal -> adoptionStatusText.isEmpty() || animal.getAdoptionStatus().equals(adoptionStatusText))
				.filter(animal -> vaccinationText.isEmpty() || animal.getVaccinationStatus().equals(vaccinationText))
				.collect(Collectors.toList());

		return foundAnimals;
	}

	@Override
	public void updateAdoptionStatus(String name, String status) {
		List<Animal> animals = loadAnimals();

		Animal animalToUpdate = animals.stream()
				.filter(animal -> animal.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);

		if (animalToUpdate != null) {
			animalToUpdate.setAdoptionStatus(status);
			saveAnimals(animals);
		}
	}

	@Override
	public void updateVaccinationStatus(String name, String status) {
		List<Animal> animals = loadAnimals();

		Animal animalToUpdate = animals.stream()
				.filter(animal -> animal.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);

		if (animalToUpdate != null) {
			animalToUpdate.setVaccinationStatus(status);
			saveAnimals(animals);
		}
	}

	// Return Animal List
	@Override
	public List<Animal> getAllAnimals() {
		return loadAnimals();
	}
}
