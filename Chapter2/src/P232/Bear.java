package P232;

public class Bear extends Animal {

	public Bear(int location) {
		super(location);
	}



	@Override
	public boolean InteractAdjacentAnimal(Animal AdjacentAnimal) {
		
		
		if (AdjacentAnimal instanceof Bear) {
			
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
