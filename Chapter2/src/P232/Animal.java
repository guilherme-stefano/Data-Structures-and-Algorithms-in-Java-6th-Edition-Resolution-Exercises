package P232;

public abstract class Animal {
	public int Location;
	public int OldLocation;
	public boolean Alive;
	public boolean NeedReproduce;
	public int Strenght ;
	public Gender Gender;
	
	public Animal(int location){
		this.Location = location;
		this.OldLocation = location;
		this.Alive = true;
		this.NeedReproduce = false;
		this.Strenght = 0;
		this.Gender = Gender.Male; 
	}
	
	public void Move(int newLocation) {
		this.OldLocation = this.Location;
		this.Location = newLocation;
	}
	
	public abstract boolean InteractAdjacentAnimal( Animal AdjacentAnimal);
	
	
	
}
