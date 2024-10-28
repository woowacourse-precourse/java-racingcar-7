package racingcar.model.vehicle;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.movableStrategy.BasicMoveStrategy;
import racingcar.modle.vehicle.Vehicles;

public class VehiclesTest {

    private Vehicles vehicles;

    @BeforeEach
    public void setUp() {
        this.vehicles = new Vehicles(new BasicMoveStrategy());
        vehicles.nameSettings(List.of("형석","지민","철수"));
    }

    @Test
    @DisplayName("자동차들의 이름 확인 테스트")
    public void checkCarNamesTest(){
        //given
        List<String> names = List.of("형석", "지민", "철수");
        //when
        List<String> carNames = vehicles.names();
        //then
        Assertions.assertThat(carNames).containsOnly("형석", "지민", "철수");
    }

    @Test
    @DisplayName("자동차들의 시작 위치 확인 테스트")
    public void startPositionTest(){
        // given
        List<Integer> carPositions = vehicles.positions();
        // when, then
        Assertions.assertThat(carPositions).containsOnly(0,0,0);
    }

//    @Test
//    @DisplayName("이동된 자동차들의 위치 확인 테스트")
//    public void movedPositionTest(){
//        // given
//        Vehicles movedvehicles = vehicles.move();
//
//        List<Integer> carPositions = movedvehicles.positions();
//        // when, then
//        Assertions.assertThat(carPositions).containsOnly(0,0,0);
//    }
}
