package racingcar;

public class Car {
    /* 자동차 클래스 생성
     *  - 자동차 전진 조건 추가(무작위 값이 4 이상일 경우 전진)
     *  - 게임 회차별 현재 자동차들 위치 출력 기능
     */
    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveDisctance() {
        return moveDistance;
    }
}
