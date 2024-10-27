package racingcar.domain.racer;

import java.util.List;
import racingcar.domain.racer.movecondition.NumberGenerator;

public record Racers(List<Racer> racers) {

    public static Racers of(List<String> carNames, NumberGenerator numberGenerator) {
        List<Racer> racers = carNames.stream()
                .map(carName -> Racer.of(carName, numberGenerator))
                .toList();

        return new Racers(racers);
    }

    public void moveCars() {
        this.racers.forEach(Racer::forward);
    }

}
