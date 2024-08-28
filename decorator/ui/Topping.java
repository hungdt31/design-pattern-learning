package ui;

public class Topping {
  private String label;
  private String name;
  private String image; // Đường dẫn hoặc URL của ảnh

  public Topping(String label, String name, String image) {
    this.label = label;
    this.name = name;
    this.image = image;
  }

  public String getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  public String getImage() {
    return image;
  }
}
