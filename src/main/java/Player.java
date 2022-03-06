import java.util.Comparator;

public class Player implements Comparator<Player> {
    private int id;
    private String name;
    private int strength;

    public Player(String name, int id, int strength) {
        this.name = name;
        this.id = id;
        this.strength = strength;
    }

    public Player() {
    }


    @Override
    public int compare(Player o1, Player o2) {
        return o1.getStrength() - o2.getStrength();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
