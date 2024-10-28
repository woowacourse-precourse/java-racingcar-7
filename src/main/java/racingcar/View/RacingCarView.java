package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Model.Car;

public class RacingCarView {

    public String[] inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public String inputNumberOfTries(){

        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printRaceProgress(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {

        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
