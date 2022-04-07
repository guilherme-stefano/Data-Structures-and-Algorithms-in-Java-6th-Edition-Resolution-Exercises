package C228;

public class Producer {

	//VARIAVEIS
	
	FIFO fila; //fila que ser usada como memoria compartilhada entre threads consumidor e produtor

	 
	public Producer(FIFO fila){
	
	   this.fila = fila; //variavel fila referencia uma fila passada como argumento
	
	}
	
	
	
	//produtor
	
	public void produce()
	
	{
	
	   int elemento = 0;
	
	  
	
	   while(true)// executa em loop
	
	   {
	
	      synchronized (this)//acesso atomico à fila
	
	      {
	
	         while(this.fila.cheia())//se fila cheia
	
	         {
	
	            //System.out.println("produtor Dormindo");
	
	            try
	
	            {
	
	             wait();   //bloqueia o thread  
	
	            }  
	
	            catch (InterruptedException e){}
	
	         }
	
	            
	
	         //Se houver espaco na fila  
	
	         this.fila.enqueue(elemento); //insere elemento
	
	         System.out.println("Elemento "+elemento+" produzido");
	
	         elemento++;  
	
	         notify(); //notifica que há elementos na fila
	
	     }      
	
	  }
	
	}    
}

