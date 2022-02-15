package cullenkuch.model;

public class Puppy {
    //Variables
    private String breed;
    private String temperament;
    private String size;
    private boolean sheds;

    //Constructor Method
    public Puppy(String breed, String temperament, String size, boolean sheds) {
        this.breed = breed;
        this.temperament = temperament;
        this.size = size;
        this.sheds = sheds;
    }

    //Getters and Setters for all Variables
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSheds() {
        return sheds;
    }

    public void setSheds(boolean sheds) {
        this.sheds = sheds;
    }
}
