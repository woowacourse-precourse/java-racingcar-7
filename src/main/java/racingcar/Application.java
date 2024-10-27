package racingcar;

import java.util.List;

public class Application {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) {
        List<Car> cars = input.getCars();
        int round = input.getRoundInput();

        Racing racing = new Racing(cars);
        racing.play(round);

        List<Car> winners = racing.getWinners();
        output.printWinners(winners);
    }
}
