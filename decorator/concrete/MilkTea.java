package concrete;
import java.util.ArrayList;
import java.util.List;

import interfaces.*;

public class MilkTea implements IMilkTea {
  private List<String> description;
  public MilkTea() {
    // Mặc định mô tả của trà sữa cơ bản
    description = new ArrayList<String>();
  }
  public double Cost(){
    return 3d;
  }
  public List<String> getDescription(){
    return description;
  }
}
