package racingcar.Entity;

/**
 * 자동차를 나타내는 엔티티 클래스입니다.
 * 각 자동차는 고유한 이름과 현재 위치를 가집니다.
 */
public class Car {
    // 자동차의 이름 (고유해야 하며, 1자 이상 5자 이하)
    private final String name;

    // 자동차의 현재 위치 (전진할 때마다 1씩 증가)
    private int position;

    /**
     * 자동차의 이름을 초기화하고, 초기 위치를 0으로 설정합니다.
     *
     * @param name 자동차의 이름
     * @throws IllegalArgumentException 이름이 유효하지 않을 경우 발생
     */
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * 다른 자동차 객체를 기반으로 새로운 자동차 객체를 생성하는 복사 생성자입니다.
     * 이는 자동차의 상태를 깊은 복사하여 히스토리에 저장할 때 유용합니다.
     *
     * @param car 복사할 자동차 객체
     */
    public Car(Car car) {
        this.name = car.name;
        this.position = car.position;
    }

    /**
     * 자동차를 한 칸 전진시킵니다.
     * 전진 시 자동차의 위치가 1씩 증가합니다.
     */
    public void move() {
        position++;
    }

    /**
     * 자동차의 이름을 반환합니다.
     *
     * @return 자동차의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 자동차의 현재 위치를 반환합니다.
     *
     * @return 자동차의 위치
     */
    public int getPosition() {
        return position;
    }
}
