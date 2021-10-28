import java.util.Observable;
import java.util.TimerTask;
import java.util.Timer;
import java.time.LocalDateTime;

public class Clock extends Observable{
  private static Clock uniqueInstance;
  private LocalDateTime time;

  private Clock() {
    this.time = LocalDateTime.now();
    startClock();
  }

  public static Clock getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Clock();
    }
    return  uniqueInstance;
  }

  public LocalDateTime getTime(){
    return time;
  }

  private void startClock(){

    TimerTask updateTime = new TimerTask() {
      public void run() {
        setChanged();
        time = time.plusSeconds(2);
        notifyObservers(time);
      }
    };

    Timer timer = new Timer("Timer");
    timer.scheduleAtFixedRate(updateTime, 0, 2000L); //Period = 2s
  }

}
