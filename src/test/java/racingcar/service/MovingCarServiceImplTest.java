package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;


class MovingCarServiceImplTest {

    private MovingCarService movingCarService;

    @BeforeEach
    void setUp(){
        movingCarService = new MovingCarServiceImpl();
    }


    @Test
    public void 랜덤값_차_전진(){

        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(List.of("pobi","jinu","popo"));
                    movingCarService.moveCars(cars);
                    assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(0);
                    assertThat(cars.getCars().get(2).getMoveCount()).isEqualTo(1);
                },
                4, 3,9
        );



    }



}