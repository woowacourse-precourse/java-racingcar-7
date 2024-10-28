package racingcar;


public class GameManager {
    private static GameManager instance;
    private int endTurn;

    CarManager carManager = CarManager.getInstance();

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void setEndTurn(int endTurn) {
        this.endTurn = endTurn;
        gameStart();
    }

    public void gameStart() {
        for (int i = 0; i < endTurn; i++) {
            playSingleTurn();
            IOManager.printState();
        }
        carManager.checkResult();
    }

    private void playSingleTurn() {
        carManager.getRandomNumber();
    }

    public void reset() {
        endTurn = 0;
    }
}
