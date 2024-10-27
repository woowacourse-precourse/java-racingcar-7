package racingcar.domain.car;

import racingcar.dto.CarDto;
import racingcar.util.RacingcarRandomUtil;
import racingcar.util.RandomUtil;

public class Car {

    private static final RandomUtil DEFAULT_RANDOM_UTIL = RacingcarRandomUtil.getInstance();

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(DEFAULT_RANDOM_UTIL);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position, DEFAULT_RANDOM_UTIL);
    }

    public void playRound() {
        position.playRound();
    }

    public String getName() {
        return name.get();
    }

    public int getPosition() {
        return position.get();
    }

    public CarDto getDto() {
        return new CarDto(name.get(), position.get());
    }
}
