package racingcar.view;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class RacingCarView {
    private final Supplier<String> inputSupplier;
    private final Consumer<String> outputConsumer;

    public RacingCarView(Supplier<String> supplier, Consumer<String> consumer) {
        this.inputSupplier = supplier;
        this.outputConsumer = consumer;
    }

    public String inputCarNames() {
        outputConsumer.accept("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return inputSupplier.get();
    }

    public String inputRound() {
        outputConsumer.accept("시도할 횟수는 몇 회인가요? ");
        return inputSupplier.get();
    }

    public void printResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            outputConsumer.accept(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        outputConsumer.accept("");
    }

    public void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        outputConsumer.accept("최종 우승자 : " + winnerNames);
    }
}
