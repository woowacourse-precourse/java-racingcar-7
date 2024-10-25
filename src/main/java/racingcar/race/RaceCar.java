package racingcar.race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceCar implements Race {
    private Map<String, List<Boolean>> record;
    private final RacePreparation racePreparation;
    private final RacePrinter racePrinter;
    private final Movement movement;

    public RaceCar(RacePreparation racePreparation, RacePrinter racePrinter, Movement movement) {
        this.racePreparation = racePreparation;
        this.racePrinter = racePrinter;
        this.movement = movement;
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
                racePrinter.print(carName, moveForwardList);
            });
        }
        return new RaceCarResult(record);
    }

}
