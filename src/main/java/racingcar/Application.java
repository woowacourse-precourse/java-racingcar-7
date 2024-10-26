package racingcar;

import domain.CarRacing;
import iohandler.InputHandler;
import iohandler.OutputHandler;
import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRacing carRacing = new CarRacing(new InputHandler(), new OutputHandler(), new RandomMoveStrategy());
        carRacing.run();
    }
}
