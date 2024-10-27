package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.NumberGeneratorImpl;
import racingcar.view.Input;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();

        Racing racing = new Racing(input, numberGenerator);
        racing.ready();
    }
}
