package P337;


	public class Scoreboard {
	    private int numEntries = 0; // number of actual entries
	    private SinglyLinkedList<GameEntry> board  = new SinglyLinkedList<GameEntry>(); // array of game entries (names & scores)
	    private int capacity = 0;
	    public Scoreboard(int capacity) {
	    	this.capacity = capacity;
	    }
	  
	    public void add(GameEntry e) {
	      int newScore = e.getScore();
	      // is the new entry e really a high score?
	      if(numEntries==0) {
	    	  numEntries++;
	    	  board.addLast(e);
	    	  return;
	      }
	      if (numEntries < capacity || newScore > board.last().getScore()) {
	        if (numEntries < capacity) // no score drops from the board
	          numEntries++; // so overall number increases
	        // shift any lower scores rightward to make room for the new entry
	        GameEntry j = board.last();
	        SinglyLinkedList<GameEntry> boardToAdd = new SinglyLinkedList<GameEntry>();
	        while (j != board.first() && j.getScore() < newScore) {
	        	j = board.removeFirst();
	        	boardToAdd.addLast(e);
	        }
	        board.addLast(j);
	        while(!boardToAdd.isEmpty()) {
	        	board.addLast(boardToAdd.removeFirst());
	        }
	      }
	    }
	    

	    

	  }
	


