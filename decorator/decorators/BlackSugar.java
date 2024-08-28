package decorators;
import java.util.ArrayList;
import java.util.List;
import decorators.base.MilkTeaDecorator;
import interfaces.IMilkTea;

// đường đen
public class BlackSugar extends MilkTeaDecorator {
  public BlackSugar(IMilkTea inner) {
    super(inner);
  }

  @Override
  public double Cost() {
    return 1d + super.Cost();
  }
  @Override
  public List<String> getDescription() {
    List<String> description = new ArrayList<>(super.getDescription());
    description.add("black sugar");
    return description;
  }
}