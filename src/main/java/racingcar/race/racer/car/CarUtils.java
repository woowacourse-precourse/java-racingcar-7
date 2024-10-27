package racingcar.race.racer.car;

import racingcar.race.racer.RacerUtils;

// Car 객체에만 할당돼야 하는 기능 추가 (확장성 고려)
// 하나의 인스턴스를 공유하기 위해 싱글톤 패턴 적용
public class CarUtils extends RacerUtils {
    private static CarUtils instance;

    // 외부에서 생성자로 객체 생성 불가
    private CarUtils() {
    }

    public static CarUtils getInstance() {
        if (instance == null) {
            instance = new CarUtils();
        }
        return instance;
    }
}
