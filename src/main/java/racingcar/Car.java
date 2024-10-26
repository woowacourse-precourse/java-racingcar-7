package racingcar;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        // 이름 유효성 검사는 아직 구현하지 않음
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }
}
