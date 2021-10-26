import java.util.Observer;
import java.util.Observable;
import java.time.Duration;

public class Interval implements Observer{
  private Duration totalTime;

  public Interval(){totalTime = Duration.ofSeconds(0);}

  @Override
  public void update(Observable o, Object time) {
    totalTime = totalTime.plusSeconds(1);
  }

  public Duration getTime(){
    return totalTime;
  }
  public void printTime(){
    System.out.println(totalTime.getSeconds());
  }
}