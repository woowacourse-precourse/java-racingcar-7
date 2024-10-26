package racingcar;

public class ApplicationContext {
    private final View view;
    private final Validator validator;
    private final GameLogic gameLogic;

    public ApplicationContext() {
        this.view = new View();
        this.validator = new Validator();
        this.gameLogic = new GameLogic();
    }

    public View getView() {
        return view;
    }

    public Validator getValidator() {
        return validator;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }
}
