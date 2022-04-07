package C228;

public class ConsumerProducer

{

 

   //VARIAVEIS

   FIFO fila; //fila que ser usada como memoria compartilhada entre threads consumidor e produtor

 

   //METODOS

   //constructor

   public ConsumerProducer(FIFO fila)

   {

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

   

 

   //consumidor

   public void consume()

   {

      int elemento;

     

      while(true)

      {

          synchronized (this)//inicia operacao atomica

          {

            while(this.fila.vazia())//se fila vazia

            {

                //System.out.println("consumidor Dormindo");

                try{

                wait();   //bloqueia o thread  

                   }  

                catch (InterruptedException e){}

            }

             

            //Se houver elemento na fila  

            elemento = this.fila.dequeue(); //retira primeiro da fila

            System.out.println("Elemento "+elemento+" consumido");  

            notify(); //notifica que há espaço na fila    

          }

       }

   }

 

 

}