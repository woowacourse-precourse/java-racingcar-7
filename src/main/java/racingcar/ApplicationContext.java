package racingcar;

public class ApplicationContext {
    private final View view;
    private final InputParser inputParser;
    private final GameLogic gameLogic;

    public ApplicationContext() {
        this.view = new View();
        this.inputParser = new InputParser();
        this.gameLogic = new GameLogic();
    }

    public View getView() {
        return view;
    }

    public InputParser getInputParser() {
        return inputParser;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }
}
