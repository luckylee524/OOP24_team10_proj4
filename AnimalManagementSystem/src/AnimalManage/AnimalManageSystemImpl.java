package AnimalManage;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalManageSystemImpl implements AnimalManageSystem {

	private static final String FILE_NAME = "AnimalList.txt";
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public List<Animal> loadAnimals() {
		List<Animal> animals = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 7) {
					String species = data[0];
					String name = data[1];
					int age = Integer.parseInt(data[2]);
					String gender = data[3];
					String foundLocation = data[4];
					String adoptionStatus = data[5];
					String vaccinationStatus = data[6];
					animals.add(new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus));
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
				writer.write(String.format("%s,%s,%d,%s,%s,%s,%s%n",
						animal.getSpecies(),
						animal.getName(),
						animal.getAge(),
						animal.getGender(),
						animal.getFoundLocation(),
						animal.getAdoptionStatus(),
						animal.getVaccinationStatus()));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void insertAnimal(String species, String name, Integer age, String gender, String foundLocation, String adoptionStatus, String vaccinationStatus) {
		List<Animal> animals = loadAnimals();

		Animal newAnimal = new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus);
		animals.add(newAnimal);
		saveAnimals(animals);
	}

	@Override
	public void deleteAnimal(String name) {
		List<Animal> animals = loadAnimals();

		boolean isDeleted = animals.removeIf(animal -> animal.getName().equalsIgnoreCase(name));
		if (isDeleted) {
			saveAnimals(animals);
		}
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

		animals.sort(Comparator.comparing(Animal::getName));
		saveAnimals(animals);
	}

	@Override
	public List<Animal> search(String name) {
		List<Animal> animals = loadAnimals();
		List<Animal> foundAnimals = animals.stream()
				.filter(animal -> animal.getName().equals(name))
				.collect(Collectors.toList());
		System.out.println(foundAnimals);
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
