import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private final Game players = new Game();
    private final Player first = new Player("человек", 1, 23);
    private final Player second = new Player("боксер", 2, 89);
    private final Player third = new Player("лыжник", 3, 23);

    @Test
    void FindByName() {
        players.register(first);
        players.register(second);
        players.register(third);

        assertEquals(first, players.findByName(first.getName()));
    }

    @Test
    void Registered() {
        players.register(first);
        players.register(second);
        players.register(third);

        Player[] expected = new Player[]{first, second, third};
        Player[] actual = players.findAll();
    }

    @Test
    void round() {
        players.register(first);
        players.register(second);

        int expected = 2;
        int actual = players.round("человек", "боксер");

        assertEquals(expected, actual);
    }

    @Test
    void round2() {
        players.register(first);
        players.register(third);

        int expected = 0;
        int actual = players.round("человек", "лыжник");

        assertEquals(expected, actual);
    }

    @Test
    void round3() {
        players.register(first);
        players.register(second);

        int expected = 1;
        int actual = players.round("боксер", "человек");

        assertEquals(expected, actual);
    }

    @Test
    void not() {
        players.register(first);


        Assertions.assertThrows(NotRegisteredException.class, () -> players.round("человек", "боксер"));
    }

    @Test
    void RemoveById() {
        players.save(first);
        players.save(second);

        players.removeById(2);

        Player[] expected = new Player[]{first};
        Player[] actual = players.findAll();
    }
}