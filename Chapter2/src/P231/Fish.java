package P231;

public class Fish extends Animal {

	public Fish(int location) {
		super(location);
	}
	

	@Override
	public boolean InteractAdjacentAnimal(Animal AdjacentAnimal) {
		
		if (AdjacentAnimal instanceof Bear) {
			this.Alive = false;
		}
		
		if (AdjacentAnimal instanceof Fish) {
			this.NeedReproduce = true;
		}
		
	
		return false;
	}
	
	@Override
	public String toString() {
		return "Fish";
	}

}
