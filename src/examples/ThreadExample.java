package examples;




class MyCounter{
        int counter;

        public synchronized int increment(){
            return this.counter++;
        };
}


public class ThreadExample {

    public static void main(String args[]){

            MyCounter myCounter = new MyCounter();

            // lamda expression
            Thread t1 = new Thread( () -> {
                for(int i = 1;i<=50;i++){
                    System.out.println("Hi c="+myCounter.increment());
                    try{Thread.sleep(100);}catch (Exception e){}
                }
            },"Hi thread");

            // anonymous class
            Thread t2 = new Thread( new Runnable() {
                public void run(){
                    for(int i = 1;i<=50;i++){
                        System.out.println("Hello from the other side c="+myCounter.increment());
                        try{Thread.sleep(100);}catch (Exception e){}
                    }
                }

            },"Hello thread");


            t1.start();
//            this thread.sleep make the main thread to sleep for 10 milis and create a difference in execution of t1 and t2
//            try{Thread.sleep(10);}catch (Exception e){}
            t2.start();

//             Common methods provided by thread class
//            t1.isAlive();
//            t1.isDaemon();
//            t1.isInterrupted();
//            t1.checkAccess();
//            t1.getId();
//            t1.getName();
//            t1.getClass();
//            t1.getPriority();   min=1, max = 10
//            t1.interrupt();
//            t1.getThreadGroup();


        try {
            // at this point main thread will wait till t1 and t2 stops the execution
            t2.setPriority(10);
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main" + "c=" +myCounter.increment());

    }
}
