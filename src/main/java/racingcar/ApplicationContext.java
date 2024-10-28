package racingcar;

public class ApplicationContext {
    private final UserInteractionManager userInteractionManager;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;

    public ApplicationContext() {
        this.userInteractionManager = new UserInteractionManager();
        this.inputParser = new InputParser(new InputValidator());
        this.race = new Race();
        this.winner = new Winner();
    }

    public UserInteractionManager getUserInteractionManager() {
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
