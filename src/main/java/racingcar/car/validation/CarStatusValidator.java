package racingcar.car.validation;

// 자동차 상태에 대한 검증 클래스
public class CarStatusValidator {
    public void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 0 이상이어야 합니다.");
        }
    }
}
