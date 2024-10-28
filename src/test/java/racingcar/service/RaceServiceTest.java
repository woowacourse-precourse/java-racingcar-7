package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

class RaceServiceTest {
    private static RaceService service;
    @BeforeAll
    static void init(){
        service = new RaceService();
    }
    @Test
    void 이름의_개수만큼_자동차가_만들어진다(){
        String input = "abc,bcd,cde";
        service.init(input);
        List<Car> cars = service.getCars().get();
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 가장_많이_전진한_자동차를_선정한다(){
        List<Car> carList = new ArrayList<>();

        Car abc = new Car("abc");
        Car bcd = new Car("bcd");

        abc.run(4);

        carList.add(abc);
        carList.add(bcd);

        service.setCars(carList);

        String winners = service.getWinners();
        Assertions.assertThat(winners).isEqualTo("abc");
    }

}