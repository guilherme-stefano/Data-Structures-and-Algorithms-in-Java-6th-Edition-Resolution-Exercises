package P232;

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
			if(this.Gender != AdjacentAnimal.Gender) {
				this.NeedReproduce = true;
				return false;
			} else {
				if (this.Strenght >= AdjacentAnimal.Strenght) {
					AdjacentAnimal.Alive = false;
					return true;
				} else {
					this.Alive = false;
					return false;
				}
			}
		}
		
	
		return false;
	}
	
	@Override
	public String toString() {
		return "Fish";
	}

}
