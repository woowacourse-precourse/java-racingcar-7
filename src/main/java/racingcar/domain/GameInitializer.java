package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameInitializer {

    private static final int CRITICAL_POINT = 4;
    private static final int DEFAULT_SCORE = 0;
    private final MoveConditionGenerator moveConditionGenerator = new MoveConditionGenerator();
    private final ProgressedAmountRepository progressedAmountRepository = new ProgressedAmountRepository();
    private final List<Car> cars;

    public GameInitializer(final CarNames carNames) {
        this.cars = mapToCar(carNames.getCarNames());
    }

    public Game initGame() {
        final List<Participant> participants = mapToParticipants();
        return new Game(participants, progressedAmountRepository, moveConditionGenerator);
    }

    private List<Participant> mapToParticipants() {
        return this.cars.stream()
                .map(car -> new Participant(car, DEFAULT_SCORE))
                .collect(Collectors.toList());
    }

    private List<Car> mapToCar(final List<CarName> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, CRITICAL_POINT))
                .collect(Collectors.toList());
    }
}
