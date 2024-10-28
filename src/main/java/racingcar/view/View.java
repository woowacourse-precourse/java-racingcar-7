package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class View {
    // 사용자로 부터 자동차 이름들을 입력 받음
    public String inputCarName() {
        return Console.readLine();
    }

    // 사용자로 부터 자동차 이동 횟수를 입력 받음
    public String inputCarRoundCount() {
        return Console.readLine();
    }

    // 경주할 자동차 입력에 대한 출력
    public void printOutputCarName(String input) {
        System.out.println(input);
    }

    // 시도할 이동 횟수 입력에 대한 출력
    public void printOutputCarRoundCount(String inputCount) {
        System.out.println(inputCount);
    }

    // 자동차들의 이동 상황(차수별 실행 결과)에 대한 출력
    public void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " :" + "-".repeat(car.getPosition()));
        }

    }

    // 우승자 출력(공동 우승자)
    public void displayWinners(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst().getName());
        } else {
            String winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            System.out.println("최종 우승자 : " + winnerNames);
        }

    }
}
