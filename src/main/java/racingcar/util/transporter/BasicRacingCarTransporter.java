package racingcar.util.transporter;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.util.generator.RacingCarGameRandomGenerator;

public class BasicRacingCarTransporter implements RacingCarTransporter {

    private final RacingCarGameRandomGenerator racingCarGameRandomGenerator;

    public BasicRacingCarTransporter(RacingCarGameRandomGenerator racingCarGameRandomGenerator) {
        this.racingCarGameRandomGenerator = racingCarGameRandomGenerator;
    }

    @Override
    public void transportRacingCar(List<RacingCar> racingCars) {
        racingCars.stream()
                .forEach(racingCar -> transport(racingCar));
    }

    private void transport(RacingCar racingCar) {
        if (racingCarGameRandomGenerator.generateRandomNumbers() >= 4) {
            racingCar.move();
        }
    }
}
