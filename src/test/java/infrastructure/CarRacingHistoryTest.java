package infrastructure;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.infrastructure.RacingCarHistory;

class CarRacingHistoryTest {
    public RacingCarHistory racingCarHistory = new RacingCarHistory();

    @BeforeEach
    void init(){
        Car caca = new Car("caca", 1L);
        Car qqq = new Car("qqq", 2L);
        Car sss = new Car("sss", 2L);
        List<Car> carList = List.of(caca,qqq,sss);
        racingCarHistory.addRound(1, carList);
    }

    @DisplayName("라운드별 경기결과를 저장할 수 있다.")
    @Test
    void addRound() {
        //then
        Assertions.assertThat(racingCarHistory.getSize()).isEqualTo(1);
    }

    @DisplayName("라운드별 경기결과를 조회할 수 있다.")
    @Test
    void getCars() {
        //then
        Assertions.assertThat(racingCarHistory.getCars(1L).get(0).getVehicleName()).isEqualTo("caca");
    }
}