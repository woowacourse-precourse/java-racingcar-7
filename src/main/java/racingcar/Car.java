package racingcar;

/**
 * {@link RacingGame}에서 자동차의 정보를 담는 클래스입니다.
 */
public class Car {
    public String name;
    public int distance;
    
    /**
     * {@link RacingGame}에서 자동차의 정보를 담는 클래스입니다.
     * @param name 자동차의 이름입니다.
     */
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }
}
