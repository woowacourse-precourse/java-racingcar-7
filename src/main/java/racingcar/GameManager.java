package racingcar;


public class GameManager {
    private static GameManager instance;
    private int endTurn;
    private int thisTurn;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void setEndTurn(int endTurn) {
        this.endTurn = endTurn;
    }
}
