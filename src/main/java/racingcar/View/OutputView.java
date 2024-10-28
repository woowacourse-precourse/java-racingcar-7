package racingcar.View;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.RacingCar;

public class OutputView {

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printBars(RacingCar car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printWinMessage() {
        System.out.print("최종 우승자 : ");
    }

    public static void printOneWinner(List<RacingCar> winners) {
        printWinMessage();
        System.out.printf(
            winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "))
        );
    }

    public static void printWinners(List<RacingCar> winners) {
        printWinMessage();
        winners.stream()
            .map(RacingCar::getName)
            .forEach(System.out::println);
    }
}
