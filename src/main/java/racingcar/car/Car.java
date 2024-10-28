package racingcar.car;

import java.util.Objects;

public abstract class Car {

    protected final String name;
    protected int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * 자동차의 위치를 변경합니다. 이 메서드는 구체적인 자동차 클래스에서 구현되어야 합니다.
     *
     * @implSpec
     * 구현 클래스는 자동차의 이동 거리를 결정하여 position 필드의 값을 변경해야 합니다.
     */
    abstract public void move();

    /**
     * 자동차의 우승 여부를 반환합니다. 이 메서드는 구체적인 자동차 클래스에서 구현되어야 합니다.
     *
     * @param maxPosition 현재 레이스의 최대 위치
     * @return 최대 위치와 비교하여 우승했으면 True, 못했으면 False
     * @implSpec
     * 구현 클래스는 자동차의 최대 위치를 확인하여 판별합니다.
     */
    abstract public boolean isWinner(int maxPosition);

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
