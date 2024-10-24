package view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {

    private boolean isFirst = true;

    public final void game(List<RacingCar> carNames) {
        if (isFirst) {
            System.out.println("실행 결과");
            isFirst = false;
        }

        carNames.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getDistance())) // 자동차 이름과 거리 표시
                .forEach(System.out::println); // 각 줄을 출력
        System.out.println();
    }

    public final void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
