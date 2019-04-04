public class Main {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> Main.inc2(true));
        Thread thread2 = new Thread(() -> Main.inc2(false));

        thread.start();
        thread2.start();

        thread.setName("thread one");
        //thread.setPriority(1);
        //thread.setDaemon(true);

        System.out.println("End");

        thread.join();
        thread2.join();

        Thread.currentThread().getName();

        System.out.println("Absolute End");
        System.out.println(counter);
    }

    private static void inc(boolean even){
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0 == even) {
                System.out.println(i);
            }
        }
    }

    private static void inc2(boolean even){
        for (int i = 0; i < 1000; i++) {
            doIncrement();
        }
    }

    private synchronized static void doIncrement(){
        ++counter;
    }

    private static void inc3(boolean even){
        for (int i = 0; i < 1000; i++) {
            synchronized (Main.class) {
                doIncrement();
            }
        }
    }

    private synchronized void run1(){
        //non-static method
    }
}
