package game.states;

import core.Position;
import core.Size;
import display.Window;
import entity.NPC;
import entity.Player;
import map.GameMap;

import java.util.List;
import java.util.Random;

public class GameState extends State {
    Random random = new Random();
    public GameState() {
        super();
        gameMap = new GameMap(new Size(21, 12), spriteLibrary);
        initializeObject();
    }

    public void initializeObject() {
        NPC npc = new NPC(spriteLibrary);
        npc.setPosition(new Position(random.nextInt(Window.WIDTH), random.nextInt(Window.HEIGHT)));
        Player player = new Player(spriteLibrary);
        gameObjectList.addAll(List.of(npc,player));
        camera.focusOn(player);
    }
}
