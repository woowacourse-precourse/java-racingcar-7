package racingcar;

import java.util.List;

public record InputDTO(List<String> carNames, Long tryNums) {
    public List<RacingCar> to() {
        return this.carNames.stream()
                .map(RacingCar::new)
                .toList();
    }
}
