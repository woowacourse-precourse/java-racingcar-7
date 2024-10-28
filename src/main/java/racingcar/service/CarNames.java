package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Entity.Car;

/**
 * 자동차 이름을 처리하고 자동차 객체 리스트를 관리하는 서비스 클래스입니다.
 * 사용자로부터 입력받은 자동차 이름 문자열을 분리하여 각 이름으로 자동차 객체를 생성합니다.
 */
public class CarNames {
    // 생성된 자동차 객체들을 저장하는 리스트
    private final List<Car> cars = new ArrayList<>();

    /**
     * 생성자.
     * 입력된 자동차 이름 문자열을 쉼표(,)로 분리하여 각 이름으로 자동차 객체를 생성하고 리스트에 추가합니다.
     *
     * @param names 쉼표로 구분된 자동차 이름 문자열
     * @throws IllegalArgumentException 자동차 이름의 유효성 검사를 통과하지 못할 경우 발생
     */
    public CarNames(String names) {
        String[] splitNames = names.split(",");
        for (String name : splitNames) {
            // 각 이름을 트림(trim)하여 공백을 제거한 후 자동차 객체를 생성
            cars.add(new Car(name.trim()));
        }
    }

    /**
     * 생성된 자동차 객체들의 리스트를 반환합니다.
     *
     * @return 자동차 객체들의 리스트
     */
    public List<Car> getCars() {
        return cars;
    }
}
