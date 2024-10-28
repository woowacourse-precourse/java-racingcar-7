package racingcar;

import racingcar.io.ProgramOutput;
import racingcar.io.UserInput;

public class Application {
    private final ProgramOutput output;
    private final UserInput input;

    public Application() {
        this.output = new ProgramOutput();
        this.input = new UserInput();
    }

    public void run() {
        output.requestCarsName();
        ParticipatingCars cars = input.getCars();

        output.requestAttemptCount();
        int tryCount = input.getAttemptCount();

        output.printAttemptResult(cars, tryCount);

        output.printWinner(cars);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application carRacing = new Application();
        carRacing.run();

    }
}
