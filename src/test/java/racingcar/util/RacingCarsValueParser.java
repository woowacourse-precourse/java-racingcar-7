package racingcar.util;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.lang.reflect.Field;
import java.util.List;

public class RacingCarsValueParser {

    /*
        RacingCars 객체의 values 필드에 접근하여 값을 가져온다.
        Reflection 을 사용하여 private 필드에 접근한다.
     */
    public static List<RacingCar> parseValues(RacingCars racingCars) {
        try {
            Field valuesField = RacingCars.class.getDeclaredField("values");
            valuesField.setAccessible(true);

            @SuppressWarnings("unchecked")
            List<RacingCar> values = (List<RacingCar>) valuesField.get(racingCars);
            return values;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("RacingCars 객체의 values 필드 접근에 실패했습니다.");
        }
    }
}
