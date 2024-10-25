package racingcar.domain.car;

import racingcar.dto.CarDto;

public class Car {
    
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
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
