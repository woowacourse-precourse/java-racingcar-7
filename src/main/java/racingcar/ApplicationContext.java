package racingcar;

public class ApplicationContext {
    private final UserInteractionManager userInteractionManager;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;

    public ApplicationContext() {
        this.userInteractionManager = new UserInteractionManager();
        this.inputParser = new InputParser();
        this.race = new Race();
        this.winner = new Winner();
    }

    public UserInteractionManager getView() {
        return userInteractionManager;
    }

    public InputParser getInputParser() {
        return inputParser;
    }

    public Race getRace() {
        return race;
    }

    public Winner getWinner() {
        return winner;
    }
}
