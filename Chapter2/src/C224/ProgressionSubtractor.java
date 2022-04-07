package C224;

public class ProgressionSubtractor extends Progression {
	protected long prev ; 
	public ProgressionSubtractor(){
		super(200);
		prev = 2;
	}
	
	public ProgressionSubtractor(long current, long prev){
		super(current);
		this.prev = prev;
	}
	
	 protected void advance() {
		 long temp = prev;
		 prev = current;
		 current -= temp;
	 }
	
}
