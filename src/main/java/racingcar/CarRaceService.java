package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.CarRace;

public class CarRaceService {

    private CarRace carRace;

    public void init(String carNames) {
        carRace = new CarRace(carNames);
    }

    public void start(int attempts) {
        IntStream.range(0, attempts)
                .forEach(attempt -> moveCars());
    }

    public void moveCars() {
        carRace.getCars().stream()
                .filter(car -> canMove())
                .forEach(Car::move);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
