import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
    Project P1 = new Project();
    P1.name = "P1";
    Task T1 = new Task();
    T1.name = "T1";
    Project P2 = new Project();
    P2.name = "P2";
    Task T2 = new Task();
    T2.name = "T2";


    P1.addChild(T1,new int[]{}, 0);
    P1.startTask(new int[]{0}, 1);
    P1.stopTask(new int[]{0}, 1);

    P1.addChild(P2,new int[]{}, 0);
    P1.addChild(T2,new int[]{1}, 1);
    P1.startTask(new int[]{0,1}, 2);
    P1.stopTask(new int[]{0,1}, 2);


  }
}