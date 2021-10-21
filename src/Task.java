import java.time.Duration;
import java.time.LocalDateTime;

public class Task extends Assignment{

  @Override
  public void start(){
    System.out.println("-> Task started, this is " + name);
    System.out.println("My parent is " + parent.name);

    //Start interval

    if(totalTime.getSeconds() == 0){ //Not started yet
      initialTime = LocalDateTime.now();
      System.out.println("Initial time: " + initialTime);
      System.out.println("Total time: " + totalTime.getSeconds());
      System.out.println("Final time: " + finalTime);

      System.out.println("-> Updating parents now");
      parent.startUpdate(initialTime);
    }

  }
  @Override
  public void stop(){
    System.out.println("-> Task stopped, this is" + name);
    System.out.println("My parent is " + parent.name);

    //Communicate w interval   (HARD CODED)
    totalTime = totalTime.plusSeconds(60);
    finalTime = LocalDateTime.now(); //cambiar por el intervalo

    System.out.println("Initial time: " + initialTime);
    System.out.println("Total time: " + totalTime.getSeconds());
    System.out.println("Final time: " + finalTime);

    System.out.println("-> Updating parents now");
    parent.update(totalTime, finalTime);
  }

//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitLeaf(this);
//  }
}