package racingcar.domain.player;

import racingcar.domain.car.Car;
import racingcar.domain.car.Distance;

public class Player {
    private final Long id;
    private final Car car;

    private Player(Long id, Car car) {
        this.id = id;
        this.car = car;
    }

    public static Player of(Long id, String name) {
        return new Player(
                id,
                Car.of(name)
        );
    }

    public Player move(Distance newDistance) {
        return new Player(id, car.move(newDistance));
    }


}
