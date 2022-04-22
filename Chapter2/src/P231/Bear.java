package P231;

public class Bear extends Animal {

	public Bear(int location) {
		super(location);
	}



	@Override
	public boolean InteractAdjacentAnimal(Animal AdjacentAnimal) {
		
		
		if (AdjacentAnimal instanceof Bear) {
			this.NeedReproduce = true;
			return false;
		}
		
		if (AdjacentAnimal instanceof Fish) {
			AdjacentAnimal.Alive = false;
		}
		
		
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Bear";
	}

}
