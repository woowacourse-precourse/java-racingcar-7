package racingcar;

public class Game {
    private final InputView inputView;
    private final CarGenerator carGenerator;
    private final InputValidator inputValidator;
    private final RandomNumberGenerator randomNumberGenerator;

    public Game(InputView inputView, CarGenerator carGenerator, InputValidator inputValidator,
                RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.carGenerator = carGenerator;
        this.inputValidator = inputValidator;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {

    }
}
