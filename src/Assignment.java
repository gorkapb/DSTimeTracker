import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public abstract class Assignment{
  protected LocalDateTime initialTime;
  protected Duration totalTime;
  protected LocalDateTime finalTime;
  protected Assignment parent;
  public String name;

  public Assignment(){totalTime = Duration.ofSeconds(0);}

  public void addTime(Duration time){
    totalTime.plus(time);
  }

  public void update(){

  }

  public void setParent(Assignment f){
    parent = f;
  }

  public LocalDateTime getInitialTime(){
    return initialTime;
  }

  public LocalDateTime getFinalTime(){
    return finalTime;
  }

  public Duration getTotalTime(){
    return totalTime;
  }


 // METHODS TO OVERRIDE
  public void addChild(Assignment assignment, int[] childIndex, int depth){} //Only used by project
  public void startTask(int[] childIndex, int depth){} //Only used by project
  public void stopTask(int[] childIndex, int depth){} //Only used by project
  public void start(){} //Only used by task
  public void stop(){} //Only used by task

//  public abstract void acceptVisitor(Visitor vis);
}