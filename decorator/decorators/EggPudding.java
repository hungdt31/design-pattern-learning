package decorators;

import decorators.base.MilkTeaDecorator;
import interfaces.IMilkTea;
import java.util.ArrayList;
import java.util.List;

// bánh trứng
public class EggPudding extends MilkTeaDecorator {
  public EggPudding(IMilkTea inner) {
    super(inner);
  }

  @Override
  public double Cost() {
    return 1.5d + super.Cost();
  }
  @Override
  public List<String> getDescription() {
    List<String> description = new ArrayList<>(super.getDescription());
    description.add("egg pudding");
    return description;
  }
}
