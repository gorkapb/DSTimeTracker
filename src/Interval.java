import java.time.format.DateTimeFormatter;
import java.util.Observer;
import java.util.Observable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Interval implements Observer {
  private LocalDateTime initialTime;
  private Duration totalTime;
  private LocalDateTime finalTime;
  private Task parent;

  public Interval(Task parent, LocalDateTime time) {
    this.totalTime = Duration.ofSeconds(0);
    this.initialTime = time;
    this.parent = parent;
    this.parent.addInterval(this);
  }

  @Override
  public void update(Observable o, Object time) {
    this.totalTime = this.totalTime.plusSeconds(2);
    this.finalTime = LocalDateTime.now();

    this.parent.update(Duration.ofSeconds(2), this.finalTime);
    this.show();
  }

  public String getInitialTimeToString() {
    return this.initialTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  public String getFinalTimeToString() {
    return this.finalTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  public long getTotalTime() { return this.totalTime.getSeconds(); }

  public Task getParent() { return this.parent; }

  public void setTime(LocalDateTime initialTime, LocalDateTime finalTime, Long totalTime){
    this.initialTime = initialTime;
    this.finalTime = finalTime;
    this.totalTime = Duration.ofSeconds(totalTime);
  }

  public void acceptVisitor(Visitor vis) {
    vis.visitInterval(this);
  }

  public void show() {
    String init = this.initialTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    String fin = this.finalTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println("interval: \t\t\t" + "\t\t" + "\t\t" + init + "\t\t" + fin + "\t\t" + this.totalTime.getSeconds());
    if (this.parent != null) {
      this.parent.show();
    }
  }
}