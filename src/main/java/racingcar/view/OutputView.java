package racingcar.view;

import racingcar.model.CarDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private Boolean isSameName;
    private int rounds;

    public OutputView(Boolean isSameName, int rounds) {
        this.isSameName = isSameName;
        this.rounds = rounds;
    }

    public void showResult(List<CarDto> cars) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            cars.forEach(this::printCar);
            System.out.println();
        }
    }

    public void printCar(CarDto car) {
        String result = car.getName();

        if (isSameName) {
            result += "(" + car.getId() + ")";
        }

        System.out.println(result + " : " + printForward(car.getForward()));
    }

    private static StringBuilder printForward(int forward) {
        StringBuilder print = new StringBuilder();

        print.append("-".repeat(Math.max(0, forward)));

        return print;
    }

    public void showWinners(List<CarDto> winners) {
        String joinWinners = winners.stream()
                                    .map(this::formatWinnerName)
                                    .collect(Collectors.joining(", "));

        System.out.print("최종 우승자 : ");
        System.out.println(joinWinners);
    }

    private String formatWinnerName(CarDto winner) {
        String name = winner.getName();

        if (isSameName) {
            name = winner.getName() + "(" + winner.getId() + ")";
        }
        return name;
    }
}
