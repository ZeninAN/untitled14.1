import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Game {
    private Collection<Player> items = new ArrayList<>();

    public void save(Player item) {
        items.add(item);
    }

    public Player[] findAll() {
        return items.toArray(new Player[0]);
    }

    public void removeById(int id) throws NotRegisteredException {
        items.removeIf(item -> item.getId() == id);
    }

    public void register(Player player) {
        items.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        int result = player1.getStrength() - player2.getStrength();
        if (result > 0) {
            return 1;
        }
        if (result < 0) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String name) {
        Player[] players = findBy(player -> player.getName() == name);
        if (players.length == 0) {
            throw new NotRegisteredException("Element with name: " + name + " not found");
        }
        return players[0];
    }


    private Player[] findBy(Predicate<Player> filter) {
        var itemsFromGame = findAll();
        var result = new ArrayList<Player>();
        for (Player player : itemsFromGame) {
            if (filter.test(player)) {
                result.add(player);
            }
        }
        return result.toArray(new Player[0]);
    }

}
