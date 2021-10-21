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

  public void startUpdate(LocalDateTime initTime){
    if(totalTime.getSeconds() == 0){ //Not started yet
      initialTime = initTime;

      System.out.println("This is " + name);
      System.out.println("Initial time: " + initialTime);
      System.out.println("Total time: " + totalTime.getSeconds());
      System.out.println("Final time: " + finalTime);

      if(parent!=null) {
        parent.startUpdate(initTime); //Send update information to parent
      }
    }
  }

  public void update(Duration time, LocalDateTime finTime){
    totalTime = totalTime.plus(time);
    finalTime = finTime;

    System.out.println("This is " + name);
    System.out.println("Initial time: " + initialTime);
    System.out.println("Total time: " + totalTime.getSeconds());
    System.out.println("Final time: " + finalTime);

    if(parent!=null) {
      parent.update(totalTime,finTime);//Send update information to parent
    }
  }


  //Setters and getters
  public void setParent(Assignment par){
    parent = par;
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