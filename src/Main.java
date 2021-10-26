import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Timer;

public class Main {
  public static void testNodes(){
    Clock clock = new Clock();
    clock.startClock();

    Project p1 = new Project("P1", null);
    Project p2 = new Project("P2", p1);
    Task t1 = new Task("T1", p2);
    Task t2 = new Task("T2", p1);

    t1.start(clock);
    try{ Thread.sleep(8000); }
    catch(Exception e){}
    t1.stop(clock);

    t2.start(clock);
    try{ Thread.sleep(8000); }
    catch(Exception e){}
    t2.stop(clock);

  }






  public static void testObserver() {
    Clock observable = new Clock();
    Interval observer = new Interval();

    observable.addObserver(observer);
    observable.startClock();

    try{ Thread.sleep(8000); }
    catch(Exception e){}

    observer.printTime();
  }

  public static void main(String[] args) {
    testNodes();
  }
}