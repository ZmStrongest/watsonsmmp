package generic;

public class Cat {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void show() {
        System.out.println( "Cat{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
