package decorators;

import decorators.base.MilkTeaDecorator;
import interfaces.IMilkTea;
import java.util.ArrayList;
import java.util.List;
// trân châu
public class Bubble extends MilkTeaDecorator {
  public Bubble(IMilkTea inner) {
    super(inner);
  }

  @Override
  public double Cost() {
    return 0.5d + super.Cost();
  }
  @Override
  public List<String> getDescription() {
    List<String> description = new ArrayList<>(super.getDescription());
    description.add("bubble");
    return description;
  }
}
