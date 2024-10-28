package racingcar;

public class OperationManager {
    private final IO io = new IO();
    private final Race race = new Race();
    private final Validator validator = new Validator();
    private String carNames;
    private String attemptsNumber;

    public void initProgram() {
        carNames = io.readCarNames();
        validator.carNamesValidation(carNames);
        attemptsNumber = io.readAttemptsNumber();
        validator.attemptsNumberValidation(attemptsNumber);
        System.out.println();
    }

    public void execute() {
        race.init(carNames);
        race.start(Integer.parseInt(attemptsNumber));
        race.result();
    }
}
