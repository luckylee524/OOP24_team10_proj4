package src.AnimalManage;

public class Animal {
    // Fields
    private String species;      // 종
    private String name;         // 이름
    private int age;             // 나이
    private String gender;       // 성별
    private String foundLocation; // 발견 장소
    private String adoptionStatus; // 입양 상태
    private String vaccinationStatus; // 예방 접종 여부

    // Constructor (Optional)
    public Animal(String species, String name, int age, String gender, String foundLocation, String adoptionStatus, String vaccinationStatus) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.foundLocation = foundLocation;
        this.adoptionStatus = adoptionStatus;
        this.vaccinationStatus = vaccinationStatus;
    }

    // Default Constructor (Optional)
    public Animal() {
    }

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }
}
