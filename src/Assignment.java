import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public abstract class Assignment {
  protected LocalDateTime initialTime;
  protected Duration totalTime;
  protected LocalDateTime finalTime;
  protected Assignment parent;
  protected String name;

  public Assignment(String n, Assignment par) {
    totalTime = Duration.ofSeconds(0);
    name = n;
    parent = par;
  }

  public void startUpdate(LocalDateTime initTime ){
    if (totalTime.getSeconds() == 0) { //Not started yet
      initialTime = initTime;

//      System.out.println("This is " + name);
//      System.out.println("Initial time: " + initialTime);
//      System.out.println("Total time: " + totalTime.getSeconds());
//      System.out.println("Final time: " + finalTime);

      if (parent != null) {
        parent.startUpdate(initTime); //Send update information to parent
      }
    }
  }

  public void update(Duration time, LocalDateTime finTime) {
    totalTime = totalTime.plus(time);
    finalTime = finTime;

//    System.out.println("This is " + name);
//    System.out.println("Initial time: " + initialTime);
//    System.out.println("Total time: " + totalTime.getSeconds());
//    System.out.println("Final time: " + finalTime);

    if(parent != null) {
      parent.update(totalTime, finTime);//Send update information to parent
    }
  }

 // METHODS TO OVERRIDE
  public void addChild(Assignment assignment){}

  public void show() {
    String init = this.initialTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    String fin = this.finalTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


    System.out.println("activity: \t" + this.name + "\t\t" + init + "\t\t" + fin + "\t\t" + this.totalTime.getSeconds());

    if (this.parent != null) {
      this.parent.show();
    }
  }
//  public abstract void acceptVisitor(Visitor vis) {};
}