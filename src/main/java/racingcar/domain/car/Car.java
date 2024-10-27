package racingcar.domain.car;

import racingcar.dto.CarDto;
import racingcar.util.RacingcarRandomUtil;
import racingcar.util.RandomUtil;

public class Car {

    private final Name name;
    private final Position position;
    private final RandomUtil randomUtil = RacingcarRandomUtil.getInstance();

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(randomUtil);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(randomUtil, position);
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
