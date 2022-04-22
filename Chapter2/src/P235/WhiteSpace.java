package P235;

import java.util.LinkedList;

import P232.Ecosystem;

public class WhiteSpace {
	public static void main(String[] args) {
		String  words = "banana melancia banana mel resto arroz resto resto";
		
		String[] splitWords = words.split(" ");
		LinkedList<String> founds = new LinkedList<String>();
		
		for(int i = 0; i< splitWords.length; i++) {
			String current = splitWords[i];			
			int numberFound = 0;
			boolean hasFound = founds.contains(current);
			if(!hasFound) 
			{
				for(int j = i; j < splitWords.length ; j++ ) {
					String check = splitWords[j];
					if(current.equals(check)  ) {
						numberFound++;
					}	
				}
				System.out.println(current + " found: " + numberFound);
			}
			founds.add(current);
		}
	}
}
