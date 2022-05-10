package GameEntriesArray;

public class GameTest {

	public static void main(String[] args) {
		
		Scoreboard board = new Scoreboard(3);
		
		board.add(new GameEntry("Madalena", 1));
		
		board.print();
		
		board.add(new GameEntry("Jorge", 2));
		
		board.print();
		
		board.add(new GameEntry("Tunico", 3));
		
		board.print();
		
		board.add(new GameEntry("Janjão", 4));
		
		board.print();
		
	}

}
