package racingcar.domain;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

public class Car {
    private final static int MOVE_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;
    private final String name;
    private int position;

    /* 기본 생성자 */
    public Car(final String name) {
        this.numberGenerator = new RandomNumberGenerator();
        this.name = name;
        this.position = 0;
    }

    /* 자동차 움직임 테스트에 사용되는 생성자
       고정된 값으로 테스트 하기 위함 */
    public Car(final String name, final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }

    /* 자동차 움직임 테스트에 사용되는 생성자
       올바른 position 값을 갖는지 확인용 */
    public Car(final String name, final int position) {
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
        if (numberGenerator.getNumber() >= MOVE_THRESHOLD)
            position++;
    }

}
