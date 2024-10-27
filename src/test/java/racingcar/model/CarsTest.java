package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;
import racingcar.service.RacingCarGameService;

class CarsTest {

    @Test
    @DisplayName("차 이름 중복 테스트")
    public void 차_이름_중복(){

        //given
        List<String> carNames = List.of("jinu","jinu","pepe");

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            Cars cars = new Cars(carNames);
        });

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.CANT_INSERT_DUPLICATE_CAR_NAME.getMessage());
    }


    @Test
    @DisplayName("차 이름 정상적 상황")
    public void 차_이름_정상상황(){

        //given
        List<String> carNames = List.of("jinu","pobi","pepe");

        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.getCars().get(0).getName()).isEqualTo("jinu");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("pepe");
    }


    @Test
    @DisplayName("차 랭킹 기능 정상상황-상위 2개")
    public void 차_랭킹_정상상황_2(){

        //given
        List<String> carNames = List.of("jinu","pobi","pepe");
        RacingCarGameService racingCarGameService = new RacingCarGameService();
        Cars cars = new Cars(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarGameService.moveCars(cars);
                },
                4, 3,9
        );

        //when
        List<String> topRankCarName = cars.getTopRankCarName();

        //then
        assertThat(topRankCarName.size()).isEqualTo(2);
        assertThat(topRankCarName.get(0)).isEqualTo("jinu");
        assertThat(topRankCarName.get(1)).isEqualTo("pepe");
    }

    @Test
    @DisplayName("차 랭킹 기능 정상상황-상위 1개")
    public void 차_랭킹_정상상황_1(){

        //given
        List<String> carNames = List.of("jinu","pobi","pepe");
        RacingCarGameService racingCarGameService = new RacingCarGameService();
        Cars cars = new Cars(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarGameService.moveCars(cars);
                },
                1, 3,9
        );

        //when
        List<String> topRankCarName = cars.getTopRankCarName();

        //then
        assertThat(topRankCarName.size()).isEqualTo(1);
        assertThat(topRankCarName.get(0)).isEqualTo("pepe");
    }

}