package racingcar.Controller;

import java.util.Arrays;
import racingcar.Model.GameCars;
import racingcar.View.StartView;

public class InputController {
    private static final String exceptWord = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";


    public static GameCars setCars() {
        String[] car_names = StartView.inputCarInfo().split(",");
        car_names = Arrays.stream(car_names)
                .map(String::trim)
                .peek(car_name -> {
                    if (car_name.length() > 5) {
                        throw new IllegalArgumentException("자동차 이름은 5글자 이하이어야 합니다.");
                    }
                    if (car_name.matches(exceptWord)) {
                        throw new IllegalArgumentException("자동차 이름에는 특수문자는 허락되지 않습니다");
                    }
                })
                .toArray(String[]::new);
        return new GameCars(car_names);
    }

    public static int setGameCount() {
        return Integer.parseInt(StartView.inputNumOfMatch());
    }
}