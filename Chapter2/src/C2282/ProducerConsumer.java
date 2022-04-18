package C2282;

public class ProducerConsumer {

    private static final int MAX_PRODUCER = 2;
    private static final int MAX_CONSUMER = 6;

<<<<<<< HEAD
    public static void main(String[] args){
=======
    public static void main(String args[]) {
>>>>>>> 500ae6648651629c9016645a3a3aa76e5267e645
      Queue queue = new Queue();
      // Producers
      Producer producer = null;
      for (int i = 0; i < MAX_PRODUCER; i++) {
        producer = new Producer(queue, "Producer " + i);
        producer.start();
      }
      Consumer consumer = null;
      // Consumers
      for (int i = 0; i < MAX_CONSUMER; i++) {
        consumer = new Consumer(queue, "Consumer " + i);
        consumer.start();
      }
    }
  }