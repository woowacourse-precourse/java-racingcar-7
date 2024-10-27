package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.function.IntSupplier;

public class CarGenerator {

    private CarGenerator () {}

    private static final IntSupplier randomEngine = () -> Randoms.pickNumberInRange(0, 9);

    public static Cars generateFrom(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(carName -> Car.of(carName, randomEngine))
                .toList();

        return new Cars(cars);
    }
}
