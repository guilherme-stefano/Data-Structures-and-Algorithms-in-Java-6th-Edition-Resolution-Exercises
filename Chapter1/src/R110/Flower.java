package R110;

public class Flower {
	private String Name;
	private int NumberOfPetals;
	private float Price;
	
	public Flower(String number, int numberOfPetals, float price) {
		this.Name = number;
		this.NumberOfPetals = numberOfPetals;
        this.Price = price;
	}
	
	public String Name() {
		return this.Name;
	}
	
	public void Name(String name) {
		this.Name = name;
	}
	
	public int NumberOfPetals() {
		return this.NumberOfPetals;
	}
	
	public void NumberOfPetals(int numberOfPetals) {
		this.NumberOfPetals = numberOfPetals;
	}
	
	public float Price() {
		return this.Price;
	}
	
	public void Price(float price) {
		this.Price = price;
	}
	
}
