package racingcar;

/**
 * 자동차를 표현하는 클래스
 * 자동차는 이름과 현재 위치를 가지며, 이동 전략에 따라 움직인다
 */
public class Car {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;


    /**
     * @param name 자동차의 이름
     * @param moveStrategy 자동차의 이동 전략
     */
    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    /**
     * 이동 전략에 따라 자동차를 전진
     * moveStrategy true 반환 시 position 1 증가
     */
    public void move() {
        if (moveStrategy.shouldMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
