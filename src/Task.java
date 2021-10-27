import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task extends Assignment {
  private ArrayList<Interval> intervals = new ArrayList<Interval>();
  private Clock clock;

  public Task(String n, Assignment par,Clock clock) {
    super(n, par);
    this.clock = clock;
  }

  public void start() {
//    System.out.println("-> Task started, this is " + this.name);
//    System.out.println("My parent is " + this.parent.name);

    LocalDateTime actualTime = LocalDateTime.now();
    //Start interval
    Interval interval = new Interval(this, actualTime);
    this.intervals.add(interval);
    this.clock.addObserver(interval);

    if(totalTime.getSeconds() == 0) { //Not started yet
      this.initialTime = actualTime;
//      System.out.println("Initial time: " + this.initialTime);
//      System.out.println("Total time: " + this.totalTime.getSeconds());
//      System.out.println("Final time: " + this.finalTime);

//      System.out.println("-> Updating parents now");
      this.parent.startUpdate(this.initialTime);
    }

  }

  public void stop() {
//    System.out.println("-> Task stopped, this is " + name);
//    System.out.println("My parent is " + parent.name);

    //Communicate w interval
    this.clock.deleteObserver(intervals.get(intervals.size()-1));

//    System.out.println("Initial time: " + initialTime);
//    System.out.println("Total time: " + totalTime.getSeconds());
//    System.out.println("Final time: " + finalTime);
  }

//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitLeaf(this);
//  }
}