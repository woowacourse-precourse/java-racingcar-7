package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RacingCarListTest {

    private final List<RacingCar> racingCars= new ArrayList<RacingCar>();

    @AfterEach
    void 자동차_리스트_초기화() {
        racingCars.clear();
    }

    @Test
    void 새로운_자동차_추가() {
        //given
        String newCarName = "pobi";
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingCarList racingCarList = new RacingCarList(racingCars, moveStrategy);
        //when
        racingCarList.addRacingCar(newCarName);
        String name = racingCarList.getRacingCars().getFirst().getName();
        //then
        assertThat(name).isEqualTo(newCarName);
    }

    @Test
    void 중복된_자동차_이름_생성시_예외_발생() {
        //given
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingCarList racingCarList = new RacingCarList(racingCars, moveStrategy);
        racingCarList.addRacingCar("pobi");

        //when, then
        assertThatThrownBy(()->racingCarList.addRacingCar("pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모든_자동차의_이동_전략이_참일때_전진한다() {
        //given
        MoveStrategy moveStrategy = () -> true;
        RacingCarList racingCarList = new RacingCarList(racingCars, moveStrategy);
        racingCarList.addRacingCar("pobi");
        racingCarList.addRacingCar("pobi2");

        //when
        racingCarList.moveAllCars();

        //then
        List<RacingCar> racingCarList1 = racingCarList.getRacingCars();
        for(RacingCar racingCar:racingCarList1) {
            assertThat(racingCar.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 모든_자동자_상태_반환() {
        //given
        MoveStrategy moveStrategy = () -> true;
        RacingCarList racingCarList = new RacingCarList(racingCars, moveStrategy);
        racingCarList.addRacingCar("pobi");
        racingCarList.moveAllCars();

        //when
        List<RacingCarStatus> racingCarsStatus = racingCarList.getRacingCarsStatus();
        String name = racingCarsStatus.getFirst().getName();
        int position = racingCarsStatus.getFirst().getPosition();
        //then
        assertThat(name).isEqualTo("pobi");
        assertThat(position).isEqualTo(1);
    }

    @Test
    void 우승자_찾기() {
        //given
        MoveStrategy moveStrategy = () -> true;
        RacingCarList racingCarList = new RacingCarList(racingCars, moveStrategy);
        racingCarList.addRacingCar("pobi");
        racingCarList.moveAllCars();

        //when
        String winner = racingCarList.findWinners().getFirst();

        //then
        assertThat(winner).isEqualTo("pobi");
    }


}