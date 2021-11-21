package extending.thread;
/**
 * @joyee-181
 */
class NewThread extends Thread{
    
    NewThread() {
        super("Demo Thread");
        System.out.println("Child Thraed: "+ this);
    }

    public void run () {
      try{
          for(int i = 5; i > 0; i--) {
              System.out.println("Child Thread: "+ i);
              Thread.sleep(500);
          }
      }catch (InterruptedException e) {
          System.out.println("Child interrupted.");
      }
      System.out.println("Exiting child thread.");
    }   
}


class ExtendThraed {
    public static void main (String args[]) {
        NewThread nt = new NewThread();
        
        nt.start();
        
        try{
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thraed: "+ i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}