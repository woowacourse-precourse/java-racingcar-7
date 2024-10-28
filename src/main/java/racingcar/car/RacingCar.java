package racingcar.car;

/**
 * 레이싱카 생성을 담당하는 팩토리 클래스. Car 클래스를 상속받아 레이싱카 인스턴스를 생성한다.
 *
 * @author JBumLee
 * @version 2024/10/26
 */
public class RacingCar extends Car {
    /**
     * 레이싱카 인스턴스를 생성한다. 생성자는 private으로, 팩토리 메소드를 통해서만 인스턴스화할 수 있다.
     *
     * @param name 레이싱카의 이름
     */
    private RacingCar(String name) {
        super(name);
    }

    /**
     * 레이싱카 인스턴스를 생성하는 정적 팩토리 메소드.
     *
     * @param name 생성할 레이싱카의 이름
     * @return 생성된 레이싱카 인스턴스
     */
    public static Car create(String name) {
        return new RacingCar(name);
    }
}