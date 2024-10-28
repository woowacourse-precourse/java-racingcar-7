package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarSnapShot;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.dto.WinnerDto;

public class FormatUtilTest {

    @Test
    void 차_상태_포맷_테스트() {
        Cars cars = new Cars("pobi,woni,jun", new AlwaysMoveStrategy());
        cars.moveAll();
        List<Car> carList = cars.getCars();

        carList.forEach(
                car -> assertThat(FormatUtil.joinCarStatus(new CarSnapShot(car)))
                        .isEqualTo(car.getName() + " : " + "-".repeat(car.getPosition()))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a,b,c,d", "a,b,c,d,e"})
    void 우승자_포맷_테스트(String winners) {
        WinnerDto winnerDto = new WinnerDto(Collections.singletonList(winners));
        String format = FormatUtil.joinWinners(winnerDto);

        assertThat(format)
                .isEqualTo(winners);
    }

}
