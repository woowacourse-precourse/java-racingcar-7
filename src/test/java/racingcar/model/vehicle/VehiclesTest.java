package racingcar.model.vehicle;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.movableStrategy.BasicMoveStrategy;
import racingcar.modle.vehicle.Vehicles;

public class VehiclesTest {

    Vehicles vehicles;

    @BeforeEach
    public void setUp() {
        this.vehicles = new Vehicles(List.of("형석","지민","철수"), new BasicMoveStrategy());
    }

    @Test
    @DisplayName("자동차들의 이름 확인 테스트")
    public void checkCarNamesTest(){
        //given
        List<String> names = List.of("형석", "지민", "철수");
        //when
        List<String> carNames = vehicles.getNames();
        //then
        Assertions.assertThat(carNames).containsOnly("형석", "지민", "철수");
    }

    @Test
    @DisplayName("자동차들의 현재 위치 확인 테스트")
    public void checkCarPositionTest(){
        // given
        // when
        // then
    }
}
