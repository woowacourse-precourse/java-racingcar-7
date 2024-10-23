package racingcar.common;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputMakerTest {

    @Test
    void 차수별_결과_생성() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("woody", 1));
        cars.add(new Car("fobi", 2));
        String expected = "실행결과\nwoody : -\nfobi : --\n";

        //when
        String result = OutputMaker.roundResult(cars);

        //then
        assertThat(result).isEqualTo(result);
    }

    @Test
    void 최종_결과_생성() {
        //given
        List<String> winnerNames = List.of("woody", "fobi");
        Winners winners = new Winners(winnerNames);
        String expected = "최종 우승자 : woody, fobi";

        //when
        String result = OutputMaker.finalResult(winners);
        System.out.println(result);

        //then
        assertThat(result).isEqualTo(expected);
    }
}