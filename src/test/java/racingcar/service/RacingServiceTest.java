package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RacingServiceTest {

    private RacingService racingService = new RacingService();

    @Test
    @DisplayName("자동차는 이름을 입력한 순서대로 저장된다")
    void save_as_ordered() {
        String input = "해적왕, 소방차, 요리사";
        List<String> carInputs = new ArrayList<>(List.of("해적왕", "소방차", "요리사"));

        Set<Car> cars = racingService.createCars(input);
        Iterator<Car> iterator = cars.iterator();

        carInputs.forEach(car ->
                Assertions.assertEquals(car, iterator.next().getName()));
    }

    @Test
    @DisplayName("중복으로 입력한 이름은 삭제하고 저장한다")
    void save_after_delete_duplication() {
        String input = "해적왕, 소방차, 해적왕, 소방차";
        List<String> carInputs = Arrays.asList("해적왕", "소방차");

        Set<Car> cars = racingService.createCars(input);

        Assertions.assertEquals(cars.size(), carInputs.size());
    }
}
