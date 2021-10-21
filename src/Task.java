public class Task extends Assignment{

  @Override
  public void start(){
    System.out.println("Task started, this is " + name);
    System.out.println("My parent is " + parent.name);
  }
  @Override
  public void stop(){
    System.out.println("Task stopped, this is " + name);
    System.out.println("My parent is " + parent.name);
  }

  public void addInterval(){
  }

//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitLeaf(this);
//  }
}