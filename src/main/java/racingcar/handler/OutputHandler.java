package racingcar.handler;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class OutputHandler {

    public void printRoundResult(Race race) {
        race.getCars().forEach(this::carStatusPrintFormat);
        System.out.println();
    }

    public void printFinalWinners(Race race) {
        List<String> winnerNameList = race.createWinnerNameList();
        System.out.println("최종 우승자 : " + String.join(", ", winnerNameList));
    }

    private void carStatusPrintFormat(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }

}
