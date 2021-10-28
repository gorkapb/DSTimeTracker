import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public abstract class Assignment {
  private static final int project = 0;
  private static final int task = 1;
  protected LocalDateTime initialTime;
  protected Duration totalTime;
  protected LocalDateTime finalTime;
  protected Assignment parent;
  protected String name;
  protected boolean type;

  public Assignment(String name, Assignment parent) {
    this.totalTime = Duration.ofSeconds(0);
    this.name = name;
    this.parent = parent;
    if (this.parent != null) {
      this.parent.addChild(this);
    }
  }

  public void startUpdate(LocalDateTime actualTime, int seconds){
    this.finalTime = actualTime;
    this.totalTime = totalTime.plusSeconds(seconds);
    if (this.totalTime.getSeconds() == seconds) {
      this.initialTime = actualTime.minusSeconds(2);
//      System.out.println("This is " + name);
//      System.out.println("Initial time: " + initialTime);
//      System.out.println("Total time: " + totalTime.getSeconds());
//      System.out.println("Final time: " + finalTime);

      if (this.parent != null) {
        this.parent.startUpdate(initialTime, seconds);
      }
    }
  }

  public void update(LocalDateTime actualTime, int seconds) {
    this.totalTime = this.totalTime.plusSeconds(seconds);
    this.finalTime = actualTime;

//    System.out.println("This is " + name);
//    System.out.println("Initial time: " + initialTime);
//    System.out.println("Total time: " + totalTime.getSeconds());
//    System.out.println("Final time: " + finalTime);

    if(this.parent != null) {
      this.parent.update(actualTime, seconds);
    }
  }

  public void addChild(Assignment assignment){}

  public String getName() { return this.name; }

  public LocalDateTime getInitialTime() {
    return this.initialTime;
  }

  public LocalDateTime getFinalTime() {
    return this.finalTime;
  }

  public long getTotalTime() { return this.totalTime.getSeconds(); }

  public Assignment getParent() { return this.parent; }

  public boolean getType() { return this.type; }


  public void setTime(LocalDateTime initialTime, LocalDateTime finalTime, Long totalTime){
    this.initialTime = initialTime;
    this.finalTime = finalTime;
    this.totalTime = Duration.ofSeconds(totalTime);
  }

  public void show() {
    String init = this.initialTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    String fin = this.finalTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println("activity: \t" + this.name + "\t\t" + init + "\t\t" + fin + "\t\t" + this.totalTime.getSeconds());
    if (this.parent != null) {
      this.parent.show();
    }
  }

  public void acceptVisitor(Visitor vis) {};
}