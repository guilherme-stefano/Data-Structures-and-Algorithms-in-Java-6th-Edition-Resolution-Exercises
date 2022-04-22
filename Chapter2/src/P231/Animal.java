package P231;

public abstract class Animal {
	public int Location;
	public int OldLocation;
	public boolean Alive;
	public boolean NeedReproduce;
	
	public Animal(int location){
		this.Location = location;
		this.OldLocation = location;
		this.Alive = true;
		this.NeedReproduce = false;
	}
	
	public void Move(int newLocation) {
		this.OldLocation = this.Location;
		this.Location = newLocation;
	}
	
	public abstract boolean InteractAdjacentAnimal( Animal AdjacentAnimal);
	
	
	
}
