package decorators;

import decorators.base.MilkTeaDecorator;
import interfaces.IMilkTea;
import java.util.ArrayList;
import java.util.List;

// bánh trái cây
public class FruitPudding extends MilkTeaDecorator {
  public FruitPudding(IMilkTea inner) {
    super(inner);
  }

  @Override
  public double Cost() {
    return 1.75d + super.Cost();
  }
  @Override
  public List<String> getDescription() {
    List<String> description = new ArrayList<>(super.getDescription());
    description.add("fruit pudding");
    return description;
  }
}
