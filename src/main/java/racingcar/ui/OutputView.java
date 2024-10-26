package racingcar.ui;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);

        System.out.println("최종 우승자 : " + winnerNames);
    }

    private String getWinnerNames(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerNames);
    }
}
