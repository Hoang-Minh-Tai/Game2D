package game.states;

import core.Position;
import core.Size;
import display.Window;
import entity.NPC;
import entity.Player;
import map.GameMap;

import java.util.List;

public class GameState extends State {
    public GameState() {
        super();
        gameMap = new GameMap(new Size(21, 12), spriteLibrary);
        initializeObject();
    }

    public void initializeObject() {
        for (int i = 1; i <= 10; i++) {
            gameObjectList.add(new NPC(spriteLibrary));
        }
        Player player = new Player(spriteLibrary);
        gameObjectList.add(player);
        camera.focusOn(player);
    }
}
