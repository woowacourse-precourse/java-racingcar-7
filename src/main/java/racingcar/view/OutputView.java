package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class OutputView {
    public void printWinner(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void printEachTime(List<Car> carList) {
        carList.forEach(car -> {
            System.out.print(car.getName() + " : ");
            printDash(car.getTotalMovement());
            System.out.println();
        });
        System.out.println();
    }

    private void printDash(Integer movement) {
        IntStream.range(0, movement).mapToObj(i -> "-").forEach(System.out::print);
    }
}
