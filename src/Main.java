import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Timer;


public class Main {
  public void testNodesNew(){

  }




//  public void testNodesOldMethod(String[] args) {
//    Project P1 = new Project();
//    P1.name = "P1";
//    Task T1 = new Task();
//    T1.name = "T1";
//    Project P2 = new Project();
//    P2.name = "P2";
//    Task T2 = new Task();
//    T2.name = "T2";
//
//
//    P1.addChild(T1,new int[]{}, 0);
//    System.out.println("--------------");
//    P1.startTask(new int[]{0}, 1);
//    System.out.println("--------------");
//    P1.stopTask(new int[]{0}, 1);
//    System.out.println("--------------");
//    P1.addChild(P2,new int[]{}, 0);
//    System.out.println("--------------");
//    P1.addChild(T2,new int[]{1}, 1);
//    System.out.println("--------------");
//    P1.startTask(new int[]{0,1}, 2);
//    System.out.println("--------------");
//    P1.stopTask(new int[]{0,1}, 2);
//  }

  public static void testObserver() {
    Clock observable = new Clock();
    Interval observer = new Interval();

    observable.addObserver(observer);
    observable.startClock();

    try{
      Thread.sleep(8000);
    }
    catch(Exception e){

    }

    observer.printTime();
  }

  public static void main(String[] args) {
    testObserver();
  }
}