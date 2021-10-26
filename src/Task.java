import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task extends Assignment {
  private ArrayList<Interval> intervals = new ArrayList<Interval>();

  public Task(String n, Assignment par) {
    super(n, par);
  }

  public void start(Clock clock) {
    System.out.println("-> Task started, this is " + name);
    System.out.println("My parent is " + parent.name);

    //Start interval
    Interval interval = new Interval();
    intervals.add(interval);
    clock.addObserver(interval);

    if(totalTime.getSeconds() == 0) { //Not started yet
      initialTime = LocalDateTime.now();
      System.out.println("Initial time: " + initialTime);
      System.out.println("Total time: " + totalTime.getSeconds());
      System.out.println("Final time: " + finalTime);

      System.out.println("-> Updating parents now");
      parent.startUpdate(initialTime);
    }

  }

  public void stop(Clock clock) {
    System.out.println("-> Task stopped, this is " + name);
    System.out.println("My parent is " + parent.name);

    //Communicate w interval
    totalTime = intervals.get(intervals.size()-1).getTime();
    clock.deleteObserver(intervals.get(intervals.size()-1));
    finalTime = LocalDateTime.now();

    System.out.println("Initial time: " + initialTime);
    System.out.println("Total time: " + totalTime.getSeconds());
    System.out.println("Final time: " + finalTime);

    System.out.println("-> Updating parents now");
    parent.update(totalTime, finalTime);
  }

//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitLeaf(this);
//  }
}