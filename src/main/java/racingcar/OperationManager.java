package racingcar;

public class OperationManager {
    private IO io = new IO();
    private Race race = new Race();
    private String carNames;
    private Long number;

    public void initProgram() {
        carNames = io.readCarNames();
        number = io.readNumber();
        System.out.println();
    }

    public void execute() {
        race.init(carNames);
        race.start(number);
    }
}
