import javax.swing.text.html.HTMLDocument;
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

  public Interval(Task parent, LocalDateTime actualTime) {
    this.totalTime = Duration.ofSeconds(0);
    this.initialTime = actualTime;
    this.parent = parent;
    this.parent.addInterval(this);
  }

  @Override
  public void update(Observable o, Object time) {
    this.totalTime = this.totalTime.plusSeconds(2);
    this.finalTime = (LocalDateTime) time;
    this.show();
    this.parent.update((LocalDateTime) time,2);

  }

  public LocalDateTime getInitialTime() {
    return this.initialTime;
  }

  public LocalDateTime getFinalTime() {
    return this.finalTime;
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
//    if (this.parent != null) {
//      this.parent.show();
//    }
  }
}