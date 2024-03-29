package C228;

public class Programa2

{

   public static void main(String[] args) throws InterruptedException

   {

   

      //OBJETOS

      FIFO fila = new FIFO(3); //fila de tamanho 3

      Producer producer = new Producer(fila); /*fila � passado como buffer para novo Objeto ConsumerProducer*/
      Consumer consumer = new Consumer(fila); /*fila � passado como buffer para novo Objeto ConsumerProducer*/

     

      Thread produtor = new Thread //cria um objeto Thread para o metodo produtor

      (

            new Runnable() /*Thread recebe interface Runnable como parametro, e roda seu m�todo run como uma thread*/

            {

                public void run() //Runnable permite sobrescrever seu m�todo run

                {

                	producer.produce(); //metodo produce do objeto ConsumerProducer sobrescreve metodo run

                }

            }

      );

      Thread consumidor = new Thread //cria uma thread para o metodo consumidor

      (

            new Runnable() 

            {

                public void run()

                {

                    consumer.consume(); //m�todo consume de ProducerConsumer rodar� como thread

                }

            }

      );  

       

      //INICIA PROGRAMA

      //inicia as threads criadas

      produtor.start(); 

      consumidor.start();

      //main abdica do controle - aguarda execucao das threads

      produtor.join();

      consumidor.join();      

   }

 

}