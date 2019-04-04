import java.util.ArrayDeque;
import java.util.Deque;

public class ProducerConsumer {
    private static final Deque<Object> objects = new ArrayDeque<>();

    private static class Producer extends Thread{
        @Override
        public void run(){
            while (true) {
                synchronized (objects){
                    if (objects.size() >= 1000){
                        try {
                            objects.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (objects) {
                    if (objects.size() < 1000) {
                        continue;
                    }

                    long v = produce();
                    synchronized (objects){
                        objects.add(v);
                        objects.notify();
                    }
                }
            }
        }

        public long produce(){
            return System.currentTimeMillis();
        }
    }

    private static class Consumer extends Thread{
        @Override
        public void run(){
            while (true){

                synchronized (objects){
                    if(objects.isEmpty()){
                        try {
                            objects.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Object o;
                synchronized (objects) {
                    o = objects.pollFirst();
                    objects.notify();
                }

                if (o != null){
                    System.out.println(o);
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.start();
        consumer.start();

        producer.setName("Producer");
        consumer.setName("Consumer");
    }
}
