import java.util.Observable;
import java.util.TimerTask;
import java.util.Timer;

public class Clock extends Observable{

  public void startClock(){

    TimerTask addTwoSeconds = new TimerTask() {
      public void run() {
        setChanged();
        notifyObservers();
      }
    };

    Timer timer = new Timer("Timer");
    timer.scheduleAtFixedRate(addTwoSeconds, 0, 1000L); //Period = 2s
  }

}
