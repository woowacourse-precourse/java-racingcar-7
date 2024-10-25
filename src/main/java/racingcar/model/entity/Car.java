package racingcar.model.entity;

import racingcar.strategy.MoveStrategy;

/**
 * 자동차를 구현한 클래스, 움직이는 것은 전략 클래스에 위임한다.
 */
public class Car {

    private final String name;

    private final MoveStrategy moveStrategy;

    private int progress;

    public Car(String name, MoveStrategy strategy) {
        this.name = name;
        this.moveStrategy = strategy;
        this.progress = 0;
    }
    public void move() {
        progress += moveStrategy.getMovingDistance();
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

}
