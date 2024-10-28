package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNameServiceTest {
    final CarNameService carNameService = new CarNameService();

    @Test
    @DisplayName("자동차 이름이 5자를 초과하여 유효하지 않은 경우")
    public void overflowCarName() {
        String carName = "aaaaaa, bbb, cc";
        assertThrows(IllegalArgumentException.class, () -> carNameService.getNamesFromString((carName)));
    }

    @Test
    @DisplayName("자동차 이름이 빈 입력값으로 유효하지 않은 경우")
    public void emptyCarName() {
        String carName = "    ,    ";
        assertThrows(IllegalArgumentException.class, () -> carNameService.getNamesFromString((carName)));
    }

    @Test
    @DisplayName("중복된 자동차 이름인 경우")
    public void duplicatedCarName() {
        String carName = "aa,aa";
        assertThrows(IllegalArgumentException.class, () -> carNameService.getNamesFromString((carName)));
    }

    @Test
    @DisplayName("자동차가 1대만 있어 유효하지 않은 경우 ")
    public void oneCarName() {
        String carName = "car";
        assertThrows(IllegalArgumentException.class, () -> carNameService.getNamesFromString((carName)));
    }

    @Test
    @DisplayName("자동차 이름이 유효한 경우")
    public void validCarName() {
        String carName = "aaa,bbb, ccc ";
        List<Car> answer = new ArrayList<>();
        answer.add(new Car("aaa", 0));
        answer.add(new Car("bbb", 0));
        answer.add(new Car("ccc", 0));
        assert carNameService.getNamesFromString(carName).equals(answer);
    }
}