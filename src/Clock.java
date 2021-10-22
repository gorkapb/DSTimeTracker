import java.util.Observable;
import java.util.TimerTask;
import java.util.Timer;
import java.time.Duration;

public class Clock extends Observable{
  private Duration time;

  public Clock(){time = Duration.ofSeconds(0);}

  public void startClock(){

    TimerTask addTwoSeconds = new TimerTask() {
      public void run() {
        time.plusSeconds(2);
        setChanged();
        notifyObservers(time);
      }
    };

    Timer timer = new Timer("Timer");
    timer.scheduleAtFixedRate(addTwoSeconds, 0, 2000L); //Period = 2s
  }

}
