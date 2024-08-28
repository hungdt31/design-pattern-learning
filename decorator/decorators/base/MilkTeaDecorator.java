package decorators.base;
import interfaces.*;
import java.util.List;
// Được sử dụng như abstract class để các class con kế thừa và triển khai các phương thức
// total cost = cost của instance được bọc bên trong + cost của lớp bên ngoài
// Bubble = base.Cost() + 0.5d
// BlackSugar = base.Cost() + 1d
// EggPudding = base.Cost() + 1.5d
// WhiteBubble = base.Cost() + 0.75d
// FruitPudding = base.Cost() + 1.75d
public abstract class MilkTeaDecorator implements IMilkTea {
  private IMilkTea _milkTea;
  protected MilkTeaDecorator(IMilkTea inner) {
    _milkTea = inner;
  }
  public double Cost(){
    return _milkTea.Cost();
  }
  public List<String> getDescription(){
    return _milkTea.getDescription();
  }
}
