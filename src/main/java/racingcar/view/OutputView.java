package racingcar.view;

import racingcar.common.IOMessage;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRoundResult(CarGroup carGroup) {
        System.out.println(IOMessage.RESULT_NOTICE.getText());
        carGroup.printCarPositions();
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
