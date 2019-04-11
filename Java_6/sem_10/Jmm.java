public class Jmm {
    private boolean keepRunning = true;
    private volatile boolean keepRunning2 = true;

    public void run(){
        int x = 0;

        while (keepRunning){
            ++x;
        }
        System.out.println(x);
    }

    public void stop(){
        keepRunning = false;
        System.out.println("Stop");
    }

    public void run2(){
        int x = 0;

        while (keepRunning2){
            ++x;
        }
        System.out.println(x);
    }

    public void stop2(){
        keepRunning2 = false;
        System.out.println("Stop");
    }

    public static void main(String[] args) throws InterruptedException {
        Jmm jmm = new Jmm();

        //new Thread(jmm::run).start();
        //Thread.sleep(3); --- даже при 1 программа крутится бесконечно
        //new Thread(jmm::stop).start();

        new Thread(jmm::run2).start();
        new Thread(jmm::stop2).start();
    }
}
