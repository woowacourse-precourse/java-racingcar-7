package racingcar;

import view.ErrorMessage;

public class Car {
    private String name; // 자동차 이름
    private int position = 0; // 자동차의 현재 위치
    private int tryNumber; // 시도 횟수

    public Car(String name) {
        if (name.length() < 1 || name.length() > 5) { // 이름 길이 검사
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print()); // 유효성 검사 실패 시 예외 발생
        }
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name; // 자동차 이름 getter
    }

    public void setTryNumber(int tryNumberValue) {
        this.tryNumber = tryNumberValue; // 시도 횟수 설정
    }

    public int getTryNumber() {
        return tryNumber; // 시도 횟수 getter
    }
}
