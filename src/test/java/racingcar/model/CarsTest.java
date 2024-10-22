package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void 객체_생성() {
        List<String> names = List.of("alex", "철수", "john");
        cars = new Cars(names);
    }

    @Test
    void 자동차_컬렉션_객체_생성_테스트() {
        //given
        List<Car> carList = cars.getCars();

        //then
        assertEquals(carList.size(), 3);
        assertEquals(carList.get(0).getName(), "alex");
        assertEquals(carList.get(1).getName(), "철수");
        assertEquals(carList.get(2).getName(), "john");
    }

    @Test
    void 랜덤_숫자가_4이상일_때_자동차가_이동해야함() {
        //given
        cars.playRound(() -> 4);

        //when
        List<Car> carList = cars.getCars();

        //then
        for (Car car : carList) {
            assertEquals(car.getPosition(), 1);
        }
    }

    @Test
    void 랜덤_숫자가_4미만일_때_자동차가_이동하지_않는다() {
        //given
        cars.playRound(() -> 3);

        //when
        List<Car> carList = cars.getCars();

        //then
        for (Car car : carList) {
            assertEquals(car.getPosition(), 0);
        }
    }

    @Test
    void 라운드별_결과_구하기() {
        //given
        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("alex", 0);
        expectedResult.put("철수", 0);
        expectedResult.put("john", 0);

        //when
        Map<String, Integer> roundResult = cars.getRoundResult();

        //then
        assertEquals(roundResult, expectedResult);
    }

    @Test
    void 최종_결과_구하기() {
        //given
        List<Car> carList = cars.getCars();
        Car alexCar = carList.get(0);
        alexCar.go(9);

        //when
        List<String> finalResult = cars.getFinalResult();

        //then
        assertEquals(finalResult.size(), 1);
        assertEquals(finalResult.get(0), "alex");
    }
}