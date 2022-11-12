package fruit_task;

public class Orange extends Fruit {
    private String name;

    public Orange(String name) {
        super(1.5f);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                '}';
    }
}
