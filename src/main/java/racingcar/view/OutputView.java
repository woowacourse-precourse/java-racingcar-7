package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void displayCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayTryCountsMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void displayRaceResultMessage() {
        System.out.println("실행 결과");
    }

    public void displayRaceProgressMessage(List<Car> carList) {
        carList.forEach(car -> System.out.println(formatCarProgress(car)));
        System.out.println();  // 각 라운드 결과 후 빈 줄 추가
    }

    public void displayWinnersMessage(List<Car> winnerList) {
        System.out.println("최종 우승자 : " + formatWinners(winnerList));
    }

    private String formatCarProgress(Car car) {
        return car.getName() + " : " + "-".repeat(car.getState());
    }

    private String formatWinners(List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
