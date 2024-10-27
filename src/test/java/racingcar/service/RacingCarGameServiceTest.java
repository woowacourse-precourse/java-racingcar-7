package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;



class RacingCarGameServiceTest {

    private RacingCarGameService racingCarGameService;

    @BeforeEach
    void setUp(){
        racingCarGameService = new RacingCarGameService();
    }


    @Test
    public void 랜덤값_차_전진(){

        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(List.of("pobi","jinu","popo"));
                    racingCarGameService.moveCars(cars);
                    assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(0);
                    assertThat(cars.getCars().get(2).getMoveCount()).isEqualTo(1);
                },
                4, 3,9
        );



    }



}