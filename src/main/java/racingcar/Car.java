package racingcar;

public class Car {
    String name;
    int tryNumber;
    StringBuilder advance;

    Car(String name) {
        this.name = name;
        this.advance = new StringBuilder(); // 초기화
    }
}
