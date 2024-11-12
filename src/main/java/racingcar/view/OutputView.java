package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Validation;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private final Validation validation;

    public OutputView(Validation validation) {
        this.validation = validation;
    }

    public void printWinner(List<String> winners) {
        String output = "최종 우승자 : " + String.join(", ", winners);
        validation.validateOutputFormat(output, winners);
        System.out.println(output);
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
