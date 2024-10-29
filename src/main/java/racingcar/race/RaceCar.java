package racingcar.race;

import racingcar.util.RandomGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceCar implements Race {
    private Map<String, List<Boolean>> record;
    private final RacePreparation racePreparation;
    private final Movement movement;

    public RaceCar(RacePreparation racePreparation) {
        this.racePreparation = racePreparation;
        this.movement = new Movement(new RandomNumberGenerator());

        initialize(racePreparation.getCarNames());
    }

    public RaceCar(RacePreparation racePreparation, RandomGenerator randomGenerator) {
        this.racePreparation = racePreparation;
        this.movement = new Movement(randomGenerator);

        initialize(racePreparation.getCarNames());
    }

    private void initialize(List<String> carNames) {
        record = new HashMap<>();
        for (String name : carNames) {
            record.putIfAbsent(name, new ArrayList<>());
        }
    }

    @Override
    public RaceCarResult startRacingGame() {
        for (int i = 0; i < racePreparation.getMatchCount(); i++) {
            record.forEach((carName, moveForwardList) -> {
                record.get(carName).add(movement.moveForward());
                RacePrinter.print(carName, moveForwardList);
            });
        }
        return new RaceCarResult(record);
    }

}
