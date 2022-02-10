package gfx;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private Map<String, SpriteSet> units;
    private Map<String,Image> tiles;

    public SpriteLibrary() {
        units = new HashMap<>();
        tiles = new HashMap<>();
        loadSpriteFromDisk();
    }

    private void loadSpriteFromDisk() {
        loadUnits("/sprites/units");
        loadTile("/sprites/tiles");
    }

    private void loadTile(String pathToTiles) {
        String[] imagesInFolder = getImageInFolder(pathToTiles);
        for (String imageName : imagesInFolder) {
            tiles.put(
                    imageName.substring(0,imageName.length() - 4),
                    ImageUtils.loadImage(pathToTiles + "/" + imageName)
            );
        }
    }

    private void loadUnits(String pathToUnits) {
        String[] folderNames = getFolderNames(pathToUnits);

        for (String folderName : folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = pathToUnits + "/" + folderName;
            String[] sheetsInFolder = getImageInFolder(pathToFolder);
            for (String sheetName : sheetsInFolder) {
                spriteSet.addSheet(
                        sheetName.substring(0,sheetName.length() - 4),
                        ImageUtils.loadImage(pathToFolder + "/" + sheetName)
                );
            }
            units.put(folderName,spriteSet);
        }
    }

    private String[] getImageInFolder(String pathToFolder) {
        URL resource = SpriteLibrary.class.getResource(pathToFolder);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }

    private String[] getFolderNames(String pathToUnits) {
        URL resource = SpriteLibrary.class.getResource(pathToUnits);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }

    public Image getTile(String name) {
        return tiles.get(name);
    }
}
