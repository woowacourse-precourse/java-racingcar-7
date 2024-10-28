package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public abstract class OutputView {

    public static void printCarsStatus(List<RacingCar> cars) {
        cars.forEach(System.out::println);
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printLineBreaking() {
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        System.out.print("최종 우승자 : ");
        if (isAlone(winners)) {
            System.out.print(winners.getFirst().getName());
            return;
        }

        winners.forEach(winner -> {
            System.out.print(winner.getName());
            if (isNotLast(winners, winner)) {
                System.out.print(", ");
            }
        });
    }

    private static boolean isAlone(List<RacingCar> winners) {
        return winners.size() == 1;
    }

    private static boolean isNotLast(List<RacingCar> winners, RacingCar winner) {
        return !winner.equals(winners.getLast());
    }
}
