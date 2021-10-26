import java.util.ArrayList;

public class Project extends Assignment {
  private ArrayList<Assignment> children = new ArrayList<Assignment>();

  public Project(String n, Assignment par) {
    super(n, par);
    if (parent != null) {
      parent.addChild(this);
    }
  }

  public Assignment getChild(int index) {
    return children.get(index);
  }

  @Override
  public void addChild(Assignment assignment) {
    children.add(assignment);
  }

//  @Override
//  public void acceptVisitor(Visitor vis) {
//    vis.visitComponent(this);
//    for (Assignment child : children) {
//      child.acceptVisitor(vis);
//    }
//  }
}