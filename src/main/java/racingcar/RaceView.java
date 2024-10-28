package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;


public class RaceView {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }


}
