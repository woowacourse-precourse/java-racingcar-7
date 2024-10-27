package racingcar;

public class OperationManager {
    private final IO io = new IO();
    private final Race race = new Race();
    private String carNames;
    private int attemptsNumber;

    public void initProgram() {
        carNames = io.readCarNames();
        attemptsNumber = io.readAttemptsNumber();
        System.out.println();
    }

    public void execute() {
        race.init(carNames);
        race.start(attemptsNumber);
        race.result();
    }
}
