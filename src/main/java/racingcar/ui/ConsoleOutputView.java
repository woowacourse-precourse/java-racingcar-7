package racingcar.ui;

import racingcar.domain.car.Cars;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printRaceStatus(Cars cars) {
        StringBuilder statusBuilder = new StringBuilder();
        cars.forEach(car -> {
            statusBuilder
                    .append(car.getName())
                    .append(" : ")
                    .append(car.getPosition().toSymbol())
                    .append(System.lineSeparator());
        });
        System.out.print(statusBuilder);
    }

    @Override
    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
