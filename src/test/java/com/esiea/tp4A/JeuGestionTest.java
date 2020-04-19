package com.esiea.tp4A;

    import com.esiea.tp4A.jeu.PlayerOutput;
    import com.esiea.tp4A.jeu.Jeu;
    import com.esiea.tp4A.api.DataAlreadyExistsException;
    import com.esiea.tp4A.api.DataNotFoundException;
    import com.esiea.tp4A.api.JeuGestion;
    import org.junit.jupiter.api.Test;

    import static org.assertj.core.api.Assertions.assertThat;
    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.junit.jupiter.api.Assertions.assertTrue;

    import java.io.IOException;
    import java.util.HashMap;

public class JeuGestionTest {
    private JeuGestion gameManagement = new JeuGestion(new HashMap<String, Jeu>());

    @Test
    void gameCreateTest() throws DataAlreadyExistsException, IOException, ClassNotFoundException {
        try {
            Jeu theGame = gameManagement.createGame("first");
            assertThat(theGame.getName()).as("gameCreateTest").isEqualTo("first");
        } catch (DataAlreadyExistsException e) {
            assertThat(e).hasNoCause().hasMessage("Game first already exists.");
        }
    }

    @Test
    void checkGameTest() throws DataNotFoundException, IOException, ClassNotFoundException {
        try {
            Jeu theGame = gameManagement.checkGame("first");
            assertThat(theGame.getName()).as("gameCreateTest").isEqualTo("first");
        } catch (DataNotFoundException e) {
            assertThat(e).hasNoCause().hasMessage("Game first not found.");
        }
    }


    @Test
    void checkCreateRoverTest() {
        try {
            gameManagement.createGame("second");
        } catch (DataAlreadyExistsException e) {
            assertThat(e).hasNoCause().hasMessage("Game first already exists.");
        }
        try {
            PlayerOutput myRover = gameManagement.createRover("second", "rover");
            assertThat(myRover.getPlayer().getPlayer()).as("playerName").isEqualTo("rover");
        } catch (DataNotFoundException e) {
            assertThat(e).hasNoCause().hasMessage("Player rover not found.");
        } catch (DataAlreadyExistsException e) {
            assertThat(e).hasNoCause().hasMessage("Player rover already exists.");
        }
    }

}
