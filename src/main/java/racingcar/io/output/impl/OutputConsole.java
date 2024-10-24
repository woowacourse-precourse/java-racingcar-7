package racingcar.io.output.impl;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.CarCollection;
import racingcar.io.output.Output;

public class OutputConsole implements Output {
    @Override
    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printRoundResult(CarCollection cars) {
        List<String> carStatuses = cars.getCarStatuses();
        carStatuses.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printWinners(CarCollection cars) {
        String winnerNames = cars.getWinnerNames();
        System.out.println("최종 우승자 : " + winnerNames);
    }

    @Override
    public void close() {
        Console.close();
    }
}