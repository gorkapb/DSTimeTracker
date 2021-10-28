import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Timer;

public class Main {

  public static void apendixA(){
    Clock clock = Clock.getInstance();

    Project root = new Project("root", null);
    Project softwareDesing = new Project("software design", root);
    Project softwareTesting = new Project("software testing", root);
    Project databases = new Project("databases", root);
    Project problems = new Project("problems", softwareDesing);
    Project projectTimeTracker = new Project("project time tracker", softwareDesing);

    Task transportation = new Task("transportation", root);
    Task firstList = new Task("first list", problems);
    Task secondList = new Task("second list", problems);
    Task readHandout = new Task("read handout", projectTimeTracker);
    Task firstMilestone = new Task("first milestone", projectTimeTracker);

    System.out.println("Start Test\n");
    System.out.println("Transportation starts:\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    System.out.println("Transportation stop\n");
    sleep(2);
    System.out.println("First list starts\n");
    firstList.start();
    sleep(6);
    System.out.println("Second list start\n");
    sleep(4);
    secondList.start();
    firstList.stop();
    System.out.println("First list stop\n");
    sleep(2);
    secondList.stop();
    System.out.println("Second list stop\n");
    sleep(2);
    System.out.println("Transportation starts\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    System.out.println("Transportation stop\n");


  }

  public static void testVisitor(){
    Visitor vis = new Visitor("jason.txt");

    Clock clock = Clock.getInstance();

    Project root = new Project("Root", null);
    Project softwareDesing = new Project("Software design", root);
    Project softwareTesting = new Project("Software testing", root);
    Project databases = new Project("Databases", root);
    Project problems = new Project("Problems", softwareDesing);
    Project projectTimeTracker = new Project("Project time tracker", softwareDesing);

    Task transportation = new Task("transportation", root);
    Task firstList = new Task("first list", problems);
    Task secondList = new Task("second list", problems);
    Task readHandout = new Task("read handout", projectTimeTracker);
    Task firstMilestone = new Task("first milestone", projectTimeTracker);

    System.out.println("Start Test\n");
    System.out.println("Transportation starts:\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    System.out.println("Transportation stop\n");
    sleep(2);
    System.out.println("First list starts\n");
    firstList.start();
    sleep(6);
    System.out.println("Second list start\n");
    sleep(4);
    secondList.start();
    firstList.stop();
    System.out.println("First list stop\n");
    sleep(2);
    secondList.stop();
    System.out.println("Second list stop\n");
    sleep(2);
    System.out.println("Transportation starts\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    System.out.println("Transportation stop\n");



    root.acceptVisitor(vis);
    vis.writeFile();
  }

  public static void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }




  public static void main(String[] args) {
    testVisitor();
  }
}