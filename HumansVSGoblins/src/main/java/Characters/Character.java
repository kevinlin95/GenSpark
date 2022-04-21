package Characters;

import Gameboard.Map;

import java.util.List;

public abstract class Character {
    public int m_x, m_y;
    protected final int characterPosition;
    protected final Alliance characterAlliance;

    Character(final int characterPosition, final Alliance characterAlliance){
        this.characterPosition = characterPosition;
        this.characterAlliance = characterAlliance;
    }
    public abstract List<Move> calculateLegalMoves(final Map map);
    public Humans m_human;

    public Character(int x, int y, Humans human){
        m_x = x;
        m_y = y;
        m_human = human;

    }
    public abstract boolean isValidPath(int finalX, int finalY);
    // determines if path is valid based on character type


}
