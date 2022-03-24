package P128;

import java.util.Random;

public class WriteSentenceMultiple {

	public static void main(String[] args) {
		WriteSentenceMultiple sentence = new WriteSentenceMultiple();
		
		sentence.Print("I will never spam my friends again.", 8, 100);

	}
	
	public void Print(String phrase, int numberTypos, int numberPrints ) {
		String[] phrases = new String[numberPrints];
		Random random = new Random();
		for(int i = 0 ; i<numberTypos; i++) 
		{
		
			int indexTypo = random.nextInt(phrase.length());
			int indexChar = random.nextInt(phrase.length());
			String typo = phrase.substring(0, indexTypo) +  phrase.substring(indexChar == 0 ? 0 :indexChar - 1 , indexChar == phrase.length() ? phrase.length() :  indexChar + 1) + phrase.substring(indexTypo, phrase.length());
			int indexPhrase = 0;
			do {
				indexPhrase = random.nextInt(numberPrints - 1);
			}while(phrases[indexPhrase] != null);
			phrases[indexPhrase] = typo;
			
		}
		
		for(int i = 0 ; i<numberPrints; i++) 
		{
			if(phrases[i] == null) 
			{
				phrases[i] = phrase;
			}
		}
		
		for(String phraseToPrint : phrases) 
		{
			System.out.println(phraseToPrint);
		}
	
	}

}
