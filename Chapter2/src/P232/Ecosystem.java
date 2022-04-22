package P232;

import java.util.LinkedList;
import java.util.Random;

public class Ecosystem {
	private final int max = 20;
	private Animal[] river = new Animal[max];
	private int Step = 1;
	public Ecosystem() {
		Start();
	}
	
	private void Start() {
		
		CreateRandomFish();
		CreateRandomFish();
		CreateRandomFish();
		CreateRandomFish();
		CreateRandomBear();
		CreateRandomBear();
	}
	
	public void NextStep() {
		System.out.println("Passo " + this.Step);
		
		for(Animal animal : this.river) {
			System.out.print("|" + (animal != null ? animal.toString() : "null") + "|");
		}
		
		for(Animal animal : this.river) {
			if (animal != null) {
				int tryMove = 1;
				boolean moved = false;
				while(tryMove <= 2 && moved == false && animal.Alive == true) {
					moved = MoveAnimal(animal, tryMove);
					tryMove++;
				}
				
				if(moved == false) {
					animal.Alive = false;
				}
				
			}
		}
		
		for(Animal animal : this.river) {
			if (animal != null) {
				if (animal.NeedReproduce) {
					
					if (animal instanceof Fish) {
						CreateRandomFish();
					}
	
					if (animal instanceof Bear) {
						CreateRandomBear();
					}
					
					animal.NeedReproduce = false;
				}
				if (!animal.Alive) {
					this.river[animal.Location] = null;
				} else {
					this.river[animal.OldLocation]  = null;
					
					Animal animalAdjacent = this.river[animal.Location];
					
					boolean goodInteraction = true;
					
					if(animalAdjacent != null) {
						goodInteraction = animal.InteractAdjacentAnimal(animalAdjacent);
					}
					
					if(goodInteraction) {
						this.river[animal.Location] = animal;
					}
				}
			}
		}
		System.out.println("");
		this.Step++;
	}
	
	private void CreateRandomFish() {
		Random random = new Random();
		Fish fish1 = new Fish(random.nextInt(this.max - 1));
		if(this.river[fish1.Location]== null)
		this.river[fish1.Location] = fish1;
	}
	
	private void CreateRandomBear() {
		Random random = new Random();
		Bear bear1 = new Bear(random.nextInt(this.max - 1));
		if(this.river[bear1.Location]== null)
		this.river[bear1.Location] = bear1;
	}
	
	private boolean MoveAnimal(Animal animal, int step) {
		Random random = new Random();
		
		int adjacent = random.nextInt(2);
		int newLocation = animal.Location;
		boolean goodInteraction = false;
		newLocation = adjacent == 0 ? newLocation + step : newLocation -step;
		
		if(newLocation > this.max -1) {
			newLocation = 0;
		}
		
		if(newLocation < 0) {
			newLocation = this.max - 1;
		}
		
		Animal animalAdjacent = this.river[newLocation];
		
		if(animalAdjacent != null) {
			goodInteraction = animal.InteractAdjacentAnimal(animalAdjacent);
		}
		
		if(goodInteraction || animalAdjacent == null) {
			animal.Move(newLocation);
		}
		
		return goodInteraction || animalAdjacent == null;
		
		
	}
	
	
}	

