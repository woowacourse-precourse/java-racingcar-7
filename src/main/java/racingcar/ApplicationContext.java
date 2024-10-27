package racingcar;

public class ApplicationContext {
    private final View view;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;

    public ApplicationContext() {
        this.view = new View();
        this.inputParser = new InputParser();
        this.race = new Race();
        this.winner = new Winner();
    }

    public View getView() {
        return view;
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
