package C221;

public class C extends B{
	public int x;
	
	public void access() {
		// not exists 
		// you can't bypass your parent's behaviour - that would stop it from enforcing its own consistency. If the parent class wants to allow you to call the grandparent method directly, it can expose that via a separate method... but that's up to the parent class.
	}
}
