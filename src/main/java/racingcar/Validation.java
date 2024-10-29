package racingcar;

import java.util.ArrayList;

public class Validation {

    /// 자동차 입력부분 예외처리
    public void validateCarName(String[] carNameArray) {

        if (carNameArray.length > 8) {
            throw new IllegalArgumentException("자동차 이름은 최대 8개까지 입력 가능합니다.");
        }
        if (carNameArray.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상 입력해야합니다.");
        }

        for (String carName : carNameArray) {

            carName = carName.trim();


            if (carName.length() < 2) {
                throw new IllegalArgumentException("자동차 이름은 2자 이상으로 입력해야합니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야입니다.");
            }

            // 자동차 이름이 알파벳 대소문자로만 이루어져있는지 확인
            if (!carName.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳 대소문자만 가능합니다.");
            }

        }
    }

    ///자동차 이름 중복 예외처리
    public void checkDuplicateCar(ArrayList<Car> cars, String carName) {

        for (Car car : cars) {
            if (carName.equals(car.getCarName())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    ///이동거리 입력 예외처리
    public void validateMaxTurn(String maxTurnString) {

        int turn = 0;

        try {
            turn = Integer.parseInt(maxTurnString);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동횟수는 숫자만 입력 가능합니다.");
        }

        if (turn < 1) {
            throw new IllegalArgumentException("이동횟수는 최소 1 이상입니다.");
        }

        if (turn > 20) {
            throw new IllegalArgumentException("이동횟수는 최대 20 이하입니다.");
        }

    }

}
