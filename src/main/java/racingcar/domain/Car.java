package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car {
    private final NumberGenerator numberGenerator;
    private final String name;
    private int position;

    public Car(String name) {
        this.numberGenerator = new RandomNumberGenerator();
        this.name = name;
        this.position = 0;
    }

    /* 자동차 움직임 테스트에 사용되는 생성자
       고정된 값으로 테스트 하기 위함 */
    public Car(String name, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }

    /* 자동차 움직임 테스트에 사용되는 생성자
       올바른 position 값을 갖는지 확인용 */
    public Car(String name, int position) {
        this.numberGenerator = new RandomNumberGenerator();
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (numberGenerator.getNumber() >= 4)
            position++;
    }

}
