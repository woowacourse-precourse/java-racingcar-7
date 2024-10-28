package racingcar.service;

import racingcar.model.ConditionCar;
import racingcar.service.RacingGameService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {

    @Test
    void 자동차_리스트가_생성되는지_확인() {
        RacingGameService service = new RacingGameService(List.of("pobi", "woni", "jun"));
        assertThat(service.getCars()).hasSize(3);
    }

    @Test
    void 각_자동차가_라운드_한번_이동하는지_확인() {
        RacingGameService service = new RacingGameService(List.of("pobi", "woni", "jun"));
        service.raceOnce();
        List<ConditionCar> cars = service.getCars();
        assertThat(cars.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(1).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(2).getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 최종_우승자_결정_확인() {
        RacingGameService service = new RacingGameService(List.of("pobi", "woni"));
        service.raceOnce();  // 이동 후 우승자 확인
        List<String> winners = service.getWinners();
        assertThat(winners).isNotNull();
    }
}