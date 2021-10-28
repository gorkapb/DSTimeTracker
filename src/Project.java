import java.util.ArrayList;

public class Project extends Assignment {
  private ArrayList<Assignment> children = new ArrayList<Assignment>();

  public Project(String n, Assignment par) {
    super(n, par);
    this.type = true;
  }

  public ArrayList<Assignment> getChildren(){
    return this.children;
  }

  @Override
  public void addChild(Assignment assignment) {
    children.add(assignment);
  }

  @Override
  public void acceptVisitor(Visitor vis) {
    vis.visitRoot(this);
  }
}