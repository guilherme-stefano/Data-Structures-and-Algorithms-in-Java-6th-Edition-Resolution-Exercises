package C319;

import java.util.Random;

public class Scoreboard {
	    private int numEntries = 0; // number of actual entries
	    private GameEntry[] board; // array of game entries (names & scores)
	    private SinglyLinkedList<Integer> gameEntryEmpties ;
	    
	    public Scoreboard(int capacity) {
	      gameEntryEmpties = new SinglyLinkedList();
	      board = new GameEntry[capacity];
	      for(int i = 0 ; i < board.length; i++ ) {
	    	  gameEntryEmpties.addLast(i);
	      }
	    }
	  
	public void add(GameEntry e) {
		int j  = 0;
		GameEntry newEntry ;
		int newScore = e.getScore();
		if(gameEntryEmpties.size()>0) {
			j  = gameEntryEmpties.removeFirst(); 
			numEntries++;
		} else {	
			Random rand = new Random();
			j = rand.nextInt(board.length);
		}
		board[j] = e;
	}

	    
		public GameEntry remove(int i){
		  GameEntry removed = board[i];
		  gameEntryEmpties.addLast(i);
		  board[i] = null; 
		  numEntries--;
		  return removed; // return the removed object
		}
	    
		  public void print() {
			  for(GameEntry entry: board) {
				  if( entry != null) {
					  System.out.println("Name:" + entry.getName() + " Score:" + entry.getScore());
				  }
			  }
			  System.out.println("");
		  }
	  }
	


