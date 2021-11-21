package pkgsynchronized;
/**
 * @joyee-181
 */
 
//This program is not Synchronized.
class Callme {
   //synchronized void call(String msg){
        void call(String msg){
        System.out.print("[" + msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;
    
    public Caller(Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
    }
  public void run(){
      target.call(msg);
  }          
}
class Synch {
    public static void main(String args[]) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        
       try{
        ob1.t.join();
        ob2.t.join();
        ob3.t.join(); 
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

//This program uses  synchronized block
class Callme {
    void call(String msg){
        System.out.print("[" + msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("]");
        }
    }
    class Caller implements Runnable{
        String msg;
        Callme target;
        Thread t;
        
        public Caller(Callme targ, String s) {
            target = targ;
            msg = s;
            t = new Thread(this);
        }
       public void run(){
           synchronized(target){
               target.call(msg);
           }
       }
    }
    
    class Synch1{
        public static void main (String args[]) {
            Callme target = new Callme();
            Caller ob1 = new Caller(target, "Hello");
            Caller ob2 = new Caller(target, "Synchronized");
            Caller ob3 = new Caller(target, "World");
            
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        
       try{
        ob1.t.join();
        ob2.t.join();
        ob3.t.join(); 
        } catch(InterruptedException e) {
          System.out.println("Interrupted");
        }
        } 
    }
}
    
    

