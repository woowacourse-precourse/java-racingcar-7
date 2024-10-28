package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

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

}