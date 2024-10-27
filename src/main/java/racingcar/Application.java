package racingcar;

import racingcar.io.ProgramOutput;

public class Application {
    private final ProgramOutput output;

    public Application() {
        this.output = new ProgramOutput();
    }

    public void run() {
        output.requestCarsName();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application racingGame = new Application();
        racingGame.run();


    }
}
