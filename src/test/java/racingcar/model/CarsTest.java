package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_컬렉션_객체_생성_테스트() {
        //given
        List<String> names = List.of("alex", "철수", "john");
        Cars cars = new Cars(names);
        List<Car> carList = cars.getCars();

        //then
        assertEquals(carList.size(), 3);
        assertEquals(carList.get(0).getName(), "alex");
        assertEquals(carList.get(1).getName(), "철수");
        assertEquals(carList.get(2).getName(), "john");
    }
}