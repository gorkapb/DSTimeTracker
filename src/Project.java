import java.util.ArrayList;

public class Project extends Assignment{
  private ArrayList<Assignment> children = new ArrayList<Assignment>();

  public Assignment getChild(int index){
    return children.get(index);
  }

  @Override
  public void addChild(Assignment assignment, int[] childIndex, int depth){ //depth of the child parent (MIN=0)
    System.out.println("Starting addChild(), this is "+ name);
    if(depth == 0){ //Current project is child's parent
      System.out.println("Child added");
      assignment.setParent(this);
      children.add(assignment);
    }
    else{ //Current project is not child's parent, go to next child
      System.out.println("Go to next child");
      children.get(childIndex[depth-1]).addChild(assignment, childIndex, depth-1);
    }
  }

  @Override
  public void startTask(int[] childIndex, int depth){ //depth of the task to start (MIN=1)
    System.out.println("Starting startTask(), this is "+ name);
    if(depth == 1){ //Current project is task's parent
      children.get(childIndex[0]).start();
    }
    else{ //Current project is not task's parent, go to next child
      System.out.println("Go to next child");
      children.get(childIndex[depth-1]).startTask(childIndex, depth-1);
    }
  }

  @Override
  public void stopTask(int[] childIndex, int depth){ //depth of the task to stop (MIN=1)
    System.out.println("Starting stopTask(), this is "+ name);
    if(depth == 1){ //Current project is task's parent
      children.get(childIndex[0]).stop();
    }
    else{ //Current project is not task's parent, go to next child
      System.out.println("Go to next child");
      children.get(childIndex[depth-1]).stopTask(childIndex, depth-1);
    }
  }


//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitComponent(this);
//    for (Assignment child : children) {
//      child.acceptVisitor(vis);
//    }
//  }
}