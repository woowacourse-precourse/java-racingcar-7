package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.NumberGeneratorImpl;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();

        Racing racing = new Racing(input, output, numberGenerator);
        racing.ready();
    }
}
