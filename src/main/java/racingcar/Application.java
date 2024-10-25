package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //초기화
        Input input = new Input();
        Parser parser = new Parser(input.read());
        Cars cars = new Cars(parser.parseCarNameInput());
        Output output = new Output(cars);

        output.printPrefix();

        int raceRound = parser.parseRaceRoundInput();
        for(int i = 0; i < raceRound; i++) {
            cars.run();
            output.printProcess();
        }

        output.printResult();
    }
}
