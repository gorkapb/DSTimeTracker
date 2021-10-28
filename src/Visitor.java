import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import org.json.JSONTokener;
import java.io.InputStream;


public class Visitor {
  private JSONArray jsonArray;


  public Visitor(){
    this.jsonArray = new JSONArray();
  }

  public void visitRoot(Project project) {
    JSONObject obj = new JSONObject();
    obj.put("name", project.getName());
    if (project.getInitialTime() != null) {
      obj.put("initialTime", project.getInitialTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      obj.put("finalTime", project.getFinalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    else {
      obj.put("initialTime", JSONObject.NULL);
      obj.put("finalTime",JSONObject.NULL);
    }
    obj.put("totalTime", project.getTotalTime());

    JSONArray children = new JSONArray();

    for (Assignment child : project.getChildren()) {
      if (child.getType()){
        children.put(visitProject((Project) child));
      }
      else {
        children.put(visitTask((Task) child));
      }
    }

    obj.put("children", children);
    this.jsonArray.put(obj);
  }

  public JSONObject visitProject(Project project){
    JSONObject obj = new JSONObject();
    obj.put("name", project.getName());
    if (project.getInitialTime() != null) {
      obj.put("initialTime", project.getInitialTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      obj.put("finalTime", project.getFinalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    else {
      obj.put("initialTime", JSONObject.NULL);
      obj.put("finalTime",JSONObject.NULL);
    }
    obj.put("totalTime", project.getTotalTime());

    JSONArray children = new JSONArray();

    for (Assignment child : project.getChildren()) {
      if (child.getType()){
        children.put(visitProject((Project) child));
      }
      else {
        children.put(visitTask((Task) child));
      }
    }

    obj.put("children", children);
    return obj;
  }

  public JSONObject visitTask(Task task){

    JSONObject obj = new JSONObject();
    obj.put("name", task.getName());
    if (task.getInitialTime() != null) {
      obj.put("initialTime", task.getInitialTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      obj.put("finalTime", task.getFinalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    else {
      obj.put("initialTime", JSONObject.NULL);
      obj.put("finalTime",JSONObject.NULL);
    }
    obj.put("totalTime", task.getTotalTime());

    JSONArray intervals = new JSONArray();

    for (Interval interval : task.getIntervals()) {
      intervals.put(visitInterval(interval));
    }

    obj.put("intervals", intervals);
    return obj;
  }

  public JSONObject visitInterval(Interval interval){
    JSONObject obj = new JSONObject();
    if (interval.getInitialTime() != null) {
      obj.put("initialTime", interval.getInitialTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      obj.put("finalTime", interval.getFinalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    else {
      obj.put("initialTime", JSONObject.NULL);
      obj.put("finalTime",JSONObject.NULL);
    }
    obj.put("totalTime", interval.getTotalTime());

    return obj;
  }

  public void createFile(String fileName) {
    fileName = fileName;
    try {
      File myObj = new File(fileName);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public void saveData(String fileName){
    createFile(fileName);
    try {
      FileWriter myWriter = new FileWriter(fileName);
      myWriter.write(this.jsonArray.toString(4));
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void loadData(String fileName){

  }
}
