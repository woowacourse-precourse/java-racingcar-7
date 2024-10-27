package racingcar;

public class Car {
    String name;
    int tryNumber;
    StringBuilder advance; // 전진 상태를 저장할 StringBuilder로 변경

    Car(String name) {
        this.name = name;
        this.advance = new StringBuilder(); // 초기화
    }
}
