import java.util.Comparator;

public class Player implements Comparator<Player> {
    private final int id;
    private final String name;
    private final int strength;

    public Player(String name, int id, int strength) {
        this.name = name;
        this.id = id;
        this.strength = strength;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getStrength() - o2.getStrength();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
