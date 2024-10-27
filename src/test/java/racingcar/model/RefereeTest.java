package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    void 우승자가_여러명일때_자동차_이름을_형식에_맞게_반환한다(){
        Cars cars = getCars();
        List<Integer> randomNumbers = List.of(5, 6, 7);
        cars.moveAll(randomNumbers);
        Referee referee = Referee.getInstance(cars);
        String message = referee.judge();
        assertEquals(message, "최종 우승자 : pobi, woni, jun");
    }

    @Test
    void 우승자가_한명일때_자동차_이름을_형식에_맞게_반환한다(){
        Cars cars = getCars();
        List<Integer> randomNumbers = List.of(1, 2, 7);
        cars.moveAll(randomNumbers);
        Referee referee = Referee.getInstance(cars);
        String message = referee.judge();
        assertEquals(message, "최종 우승자 : jun");
    }

    private Cars getCars() {
        List<String> names = List.of("pobi", "woni", "jun");
        return Cars.getInstance(names);
    }

}