package racingcar;


public class GameManager {
    private static GameManager instance;
    private int endTurn;

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

    public void gameStart() {
        for (int i = 0; i < endTurn; i++) {
            playSingleTurn();
            IOManager.printState();
        }
    }

    private void playSingleTurn() {
        CarManager carManager = CarManager.getInstance();
        carManager.getRandomNumber();
    }
}
