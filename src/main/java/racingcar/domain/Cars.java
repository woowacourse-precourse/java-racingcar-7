package racingcar.domain;

import java.util.List;

/**
 * packageName    : racingcar.domain
 * fileName       : Cars
 * author         : ehgur
 * date           : 2024-10-24
 * description    : 컬렉션 Car 객체를 관리하기 위한 일급 컬렉션
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-24         ehgur            최초 생성
 */

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
