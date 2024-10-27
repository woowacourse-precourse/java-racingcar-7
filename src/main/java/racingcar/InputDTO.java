package racingcar;

import java.util.List;
import racingcar.model.RacingCar;

public record InputDTO(List<String> carNames, Long tryNums) {
    public List<RacingCar> to() {
        return this.carNames.stream()
                .map(RacingCar::new)
                .toList();
    }
}
