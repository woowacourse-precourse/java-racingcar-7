package racingcar;

public class Car {
    public Car(String name) {
        if (6 <= name.length()) {
            throw new IllegalArgumentException("이름의 길이는 6을 넘길 수 없습니다.");
        }
    }
}
