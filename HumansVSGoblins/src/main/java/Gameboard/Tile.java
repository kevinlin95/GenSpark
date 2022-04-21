package Gameboard;
import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {
    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for(int i = 0; i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        //return Collections.unmodifiableMap(emptyTileMap);
        return ImmutableMap.copyOf(emptyTileMap);
    }
    public static Tile createTile(final int tileCoordinate, final Character character){
        return character != null ? new OccupiedTile(tileCoordinate, character) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Character getCharacter();

    public static final class EmptyTile extends Tile {

        EmptyTile(final int coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Character getCharacter(){
            return null;
        }
    }
    public static final class OccupiedTile extends Tile {

        private final Character characterOnTile;
        OccupiedTile(int coordinate, Character characterOnTile) {
            super(coordinate);
            this.characterOnTile = characterOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Character getCharacter() {
            return this.characterOnTile;
        }
    }
}
