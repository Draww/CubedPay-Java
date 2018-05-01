package co.melondev.cubedpay.data;

public class Game {

    private String id = "";
    private String name = "";

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
