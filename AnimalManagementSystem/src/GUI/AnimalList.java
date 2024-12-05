package GUI;

import AnimalManage.Animal;
import ProductManage.Food;
import ProductManage.Medicine;
import ProductManage.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnimalList {
    ///////////////////////////////////////////////
    //***connection here(Animal 객체를 다루는 ArrayList)
    ///////////////////////////////////////////////
    private ArrayList<Animal> animals;

    public AnimalList() {
        animals = new ArrayList<>();

        String filePath = "src/Repository/AnimalList.txt";
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(" / ");
                String species = details[0];
                String name = details[1];
                int age = Integer.parseInt(details[2]);
                String gender = details[3];
                String foundLocation = details[4];
                String adoptionStatus = details[5];
                String vaccinationStatus = details[6];
                String imagePath = details[7];
                animals.add(new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus, imagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeAnimalList() {
        animals = new ArrayList<>();

        String filePath = "src/Repository/AnimalList.txt";
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(" / ");
                String species = details[0];
                String name = details[1];
                int age = Integer.parseInt(details[2]);
                String gender = details[3];
                String foundLocation = details[4];
                String adoptionStatus = details[5];
                String vaccinationStatus = details[6];
                String imagePath = details[7];
                animals.add(new Animal(species, name, age, gender, foundLocation, adoptionStatus, vaccinationStatus, imagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
