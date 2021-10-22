import java.util.Observer;
import java.util.Observable;
import java.time.Duration;

public class Interval implements Observer{
  private Duration totalTime;

  @Override
  public void update(Observable o, Object time) {
    totalTime = (Duration) time;
  }

  public void printTime(){
    System.out.println(totalTime.getSeconds());
  }
}