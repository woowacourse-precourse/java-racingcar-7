package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.FinalResultDto;

class ScoreBoardTest {
    private ScoreBoard scoreBoard;
    private CarImpl car1;
    private CarImpl car2;
    private CarImpl car3;

    @BeforeEach
    void setUp() {
        car1 = (CarImpl) CarImpl.from("Car1");
        car2 = (CarImpl) CarImpl.from("Car2");;
        car3 = (CarImpl) CarImpl.from("Car3");;
        List<Car> carList = List.of(car1, car2, car3);
        scoreBoard = ScoreBoard.from(carList);
    }

    @Test
    void 가장_많이_전진한_자동차_이름을_반환하는지_확인() {
        car1.run();
        FinalResultDto finalResult = scoreBoard.returnFinalResult();

        assertEquals("최종 우승자 : Car1", finalResult.getResult());
    }
}