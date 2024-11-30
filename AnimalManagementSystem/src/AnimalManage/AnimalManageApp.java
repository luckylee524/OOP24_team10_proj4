package AnimalManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AnimalManageApp {
    private final AnimalManageSystemImpl animalManageSystem;
    private JPanel frame;
    private JTable animalTable;
    private DefaultTableModel tableModel;
    private JTextField searchField, deleteField, updateNameField, updateStatusField, vaccinationStatusField, nameField,
            speciesField, ageField, genderField, locationField, adoptionStatusField, updateVaccinationNameField, updateVaccinationStatusField;

    public AnimalManageApp() {
        this.animalManageSystem = new AnimalManageSystemImpl();
    }

    public AnimalManageApp(AnimalManageSystemImpl animalManageSystem) {
        this.animalManageSystem = animalManageSystem;
    }

    public void initialize() {
        frame = new JPanel();
        frame.setSize(800, 900);
        frame.setLayout(new BorderLayout());

        // Table model and JTable setup
        tableModel = new DefaultTableModel(new Object[]{"Species", "Name", "Age", "Gender", "Location", "Adoption Status","Vaccination Status"}, 0);
        animalTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(animalTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel for adding/updating/searching animals
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(25, 2));
        frame.add(panel, BorderLayout.SOUTH);

        // Input fields for animal data
        panel.add(new JLabel("Species:"));
        speciesField = new JTextField();
        panel.add(speciesField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);

        panel.add(new JLabel("Location:"));
        locationField = new JTextField();
        panel.add(locationField);

        panel.add(new JLabel("Adoption Status:"));
        adoptionStatusField = new JTextField();
        panel.add(adoptionStatusField);

        panel.add(new JLabel("Vaccination Status:"));
        vaccinationStatusField = new JTextField();
        panel.add(vaccinationStatusField);

        // Insert Button
        JButton insertButton = new JButton("Insert Animal");
        panel.add(insertButton);

        // Search Button
        panel.add(new JLabel());
        panel.add(new JLabel("Search by Name:"));
        searchField = new JTextField();
        panel.add(searchField);
        JButton searchButton = new JButton("Search Animal");
        panel.add(searchButton);

        // Delete Button
        panel.add(new JLabel());
        panel.add(new JLabel("Delete By Name :"));
        deleteField = new JTextField();
        panel.add(deleteField);
        JButton deleteButton = new JButton("Delete Animal By Name");
        panel.add(deleteButton);

        // Adoption Status Button
        panel.add(new JLabel());
        panel.add(new JLabel("Update Adoption Status"));
        panel.add(new JLabel());
        panel.add(new JLabel("Name :"));
        updateNameField = new JTextField();
        panel.add(updateNameField);
        panel.add(new JLabel("Adoption Status :"));
        updateStatusField = new JTextField();
        panel.add(updateStatusField);
        JButton updateAdoptionButton = new JButton("Update Adoption Status");
        panel.add(updateAdoptionButton);

        // Vaccination Status Button
        panel.add(new JLabel());
        panel.add(new JLabel("Update Vaccination Status"));
        panel.add(new JLabel());
        panel.add(new JLabel("Name :"));
        updateVaccinationNameField = new JTextField();
        panel.add(updateVaccinationNameField);
        panel.add(new JLabel("Vaccination Status :"));
        updateVaccinationStatusField = new JTextField();
        panel.add(updateVaccinationStatusField);
        JButton updateVaccinationButton = new JButton("Update Vaccination Status");
        panel.add(updateVaccinationButton);

        // Sort Button
        panel.add(new JLabel());
        JButton sortAgeButton = new JButton("Sort by Age");
        panel.add(sortAgeButton);
        panel.add(new JLabel());

        JButton sortSpeciesButton = new JButton("Sort by Species");
        panel.add(sortSpeciesButton);
        panel.add(new JLabel());

        JButton sortNameButton = new JButton("Sort by Name");
        panel.add(sortNameButton);

        // Action listeners
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertAnimal();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAnimal();
            }
        });

        sortAgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortAgeButton();
            }
        });

        sortSpeciesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortSpeciesButton();
            }
        });

        sortNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortNameButton();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAnimal();
            }
        });

        updateAdoptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdoptionStatus();
            }
        });

        updateVaccinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVaccinationStatus();
            }
        });

        // Display animals when UI is loaded
        displayAnimals();

        frame.setVisible(true);
    }

    // Return the panel of the AnimalManageApp
    public JPanel getPanel() {
        return frame;  // Cast to JPanel
    }

    // Display animals in the JTable
    public void displayAnimals() {
        List<Animal> animals = animalManageSystem.getAllAnimals();
        tableModel.setRowCount(0);  // Clear existing data
        for (Animal animal : animals) {
            tableModel.addRow(new Object[]{
                    animal.getSpecies(),
                    animal.getName(),
                    animal.getAge(),
                    animal.getGender(),
                    animal.getFoundLocation(),
                    animal.getAdoptionStatus(),
                    animal.getVaccinationStatus()
            });
        }
    }

    // Display animals in the JTable
    public void displaySearchedAnimals(List<Animal> animals) {
        tableModel.setRowCount(0);  // Clear existing data
        for (Animal animal : animals) {
            tableModel.addRow(new Object[]{
                    animal.getSpecies(),
                    animal.getName(),
                    animal.getAge(),
                    animal.getGender(),
                    animal.getFoundLocation(),
                    animal.getAdoptionStatus(),
                    animal.getVaccinationStatus()
            });
        }
    }

    // Insert a new animal
    private void insertAnimal() {
        String species = speciesField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        String location = locationField.getText();
        String adoptionStatus = adoptionStatusField.getText();
        String vaccinationStatus = vaccinationStatusField.getText();

        animalManageSystem.insertAnimal(species, name, age, gender, location, adoptionStatus, vaccinationStatus);
        displayAnimals();  // Refresh table
    }

    // Delete an animal by name
    private void deleteAnimal() {
        String name = deleteField.getText();
        animalManageSystem.deleteAnimal(name);
        displayAnimals();  // Refresh table
    }

    // Sort animals by age
    private void sortAgeButton() {
        animalManageSystem.sortAnimal();
        displayAnimals();  // Refresh table
    }

    // Sort animals by species
    private void sortSpeciesButton() {
        animalManageSystem.sortAnimalBySpecies();
        displayAnimals();  // Refresh table
    }

    // Sort animals by name
    private void sortNameButton() {
        animalManageSystem.sortAnimalByName();
        displayAnimals();  // Refresh table
    }

    // Search for an animal by name
    private void searchAnimal() {
        String name = searchField.getText();
        displaySearchedAnimals(animalManageSystem.search(name));
    }

    // Update adoption status of an animal
    private void updateAdoptionStatus() {
        String name = updateNameField.getText();
        String status = updateStatusField.getText();
        animalManageSystem.updateAdoptionStatus(name,status);
        displayAnimals();  // Refresh table
    }

    // Update vaccination status of an animal
    private void updateVaccinationStatus() {
        String name = updateVaccinationNameField.getText();
        String status = updateVaccinationStatusField.getText();
        animalManageSystem.updateVaccinationStatus(name,status);
        displayAnimals();  // Refresh table
    }

}
