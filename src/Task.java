import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task extends Assignment {
  private ArrayList<Interval> intervals = new ArrayList<Interval>();

  public Task(String name, Assignment parent) {
    super(name, parent);
    this.type = false;
  }

  public void start() {
//    System.out.println("-> Task started, this is " + this.name);
//    System.out.println("My parent is " + this.parent.name);

    Clock clock = Clock.getInstance();
    LocalDateTime actualTime = clock.getTime();
    Interval interval = new Interval(this, actualTime);

    clock.addObserver(interval);
    int seconds = 2;
    this.totalTime = totalTime.plusSeconds(seconds);
    this.finalTime = actualTime;

    if(totalTime.getSeconds() == seconds) { //Not started yet
      this.initialTime = actualTime.minusSeconds(2);
    }
    this.parent.startUpdate(actualTime, seconds);

    interval.show();
  }

  public void stop() {
//    System.out.println("-> Task stopped, this is " + name);
//    System.out.println("My parent is " + parent.name);

    Clock clock = Clock.getInstance();
    clock.deleteObserver(this.intervals.get(this.intervals.size()-1));

//    System.out.println("Initial time: " + initialTime);
//    System.out.println("Total time: " + totalTime.getSeconds());
//    System.out.println("Final time: " + finalTime);
  }

  public ArrayList<Interval> getIntervals(){
    return this.intervals;
  }

  public void addInterval(Interval interval) {
    this.intervals.add(interval);
  }

  @Override
  public void acceptVisitor(Visitor vis) {
    vis.visitTask(this);
  }
}