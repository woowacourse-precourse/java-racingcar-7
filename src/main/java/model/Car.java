package model;

import service.MoveStrategy;

public class Car {
    private final String name; // 이름을 변경할 일은 없음.
    private int position;

    public int getPosition() { // alt + insert 를 통한 getter 생성
        return position;
    }

    public String getName() {
        return name;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }

    // Object 클래스의 toString함수를 오버라이드
    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }
}
