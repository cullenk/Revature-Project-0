package cullenkuch.model;

public class Puppy {
    //Variables
    private int puppy_id;
    private String breed;
    private String temperament;
    private String size;
    private String sheds;

    //Constructor Method
    public Puppy(int puppy_id, String breed, String temperament, String size, String sheds) {
        this.puppy_id = puppy_id;
        this.breed = breed;
        this.temperament = temperament;
        this.size = size;
        this.sheds = sheds;
    }

    //Getters and Setters for all Variables
    public int getPuppy_id() {return puppy_id;}

    public void setPuppy_id(int puppy_id) {
        this.puppy_id = puppy_id;
    }

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

    public String getSheds() {
        return sheds;
    }

    public void setSheds(String sheds) {
        this.sheds = sheds;
    }
}
