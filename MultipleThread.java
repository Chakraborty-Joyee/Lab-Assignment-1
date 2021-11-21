package multiple.thread;
/**
 @joyee-181
 */
class NewThread implements Runnable{
    String name;
    Thread t;
    
    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }
    
    public void run() {
        try{
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
           System.out.println(name + "Interrupted");
        }
        System.out.println(name + "exiting.");
    }   
}

class MultiThreadDemo {
    public static void main (String args[]){
        NewThread nt1 = new NewThread ("One ");
        NewThread nt2 = new NewThread ("Two ");
        NewThread nt3 = new NewThread ("Three ");
        
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();
        
        try{
            Thread.sleep(10000);
        } catch(InterruptedException e) {
          System.out.println("Main thread Inrrupted");
        }
        System.out.println("Main thread exiting");
    }
}
