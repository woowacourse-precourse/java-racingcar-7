package racingcar.model;

public class Car {
    private String name; // 자동차 이름
    private int position; // 자동차 위치

    // 생성자: 자동차 이름을 입력받아 초기 위치를 0으로 설정
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 주어진 랜덤 값에 따라 자동차의 위치를 이동시키는 메서드
    public void move(int randomValue) {
        if (randomValue >= 4) { // 조건: 4 이상일 경우 전진
            position++;
        }
    }

    // 현재 위치를 반환하는 메서드
    public int getPosition() {
        return position;
    }

    // 자동차 이름을 반환하는 메서드
    public String getName() {
        return name;
    }
}
