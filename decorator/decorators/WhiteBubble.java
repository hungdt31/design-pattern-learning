package decorators;

import decorators.base.MilkTeaDecorator;
import interfaces.IMilkTea;
import java.util.ArrayList;
import java.util.List;

// trân châu trắng
public class WhiteBubble extends MilkTeaDecorator {
  public WhiteBubble(IMilkTea inner) {
    super(inner);
  }

  @Override
  public double Cost() {
    return 0.75d + super.Cost();
  }
  @Override
  public List<String> getDescription() {
    List<String> description = new ArrayList<>(super.getDescription());
    description.add("white bubble");
    return description;
  }
}
