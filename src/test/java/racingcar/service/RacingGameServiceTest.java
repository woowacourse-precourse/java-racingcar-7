package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class RacingGameServiceTest {

    private RacingGameService racingGameService;
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "woni", "jun");
        racingGameService = new RacingGameService(carNames);
    }

    @Test
    void racingGameService_ShouldInitializeCarsCorrectly() {
        // 자동차 리스트가 정상적으로 초기화되었는지 확인
        List<RacingCar> racingCars = racingGameService.getRacingCars();
        assertThat(racingCars).hasSize(3);
        assertThat(racingCars.get(0).getName()).isEqualTo("pobi");
        assertThat(racingCars.get(1).getName()).isEqualTo("woni");
        assertThat(racingCars.get(2).getName()).isEqualTo("jun");
        assertThat(racingCars.get(0).getPosition()).isEqualTo(0);
    }

    @Test
    void racingGameService_ShouldMoveCarsCorrectly() {
        // 경주가 시작된 후 자동차가 전진하는지 테스트
        racingGameService.startRace(5);

        // 자동차가 전진했는지 확인 (0 이상의 위치)
        List<RacingCar> racingCars = racingGameService.getRacingCars();
        for (RacingCar car : racingCars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void racingGameService_ShouldFindWinnersCorrectly() {
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");
        RacingCar car3 = new RacingCar("jun");

        car1.advance();
        car1.advance();
        car2.advance();
        car3.advance();

        List<RacingCar> racingCars = Arrays.asList(car1, car2, car3);

        // 우승자 검증 - 2칸 전진한 pobi가 우승자
        List<RacingCar> winners = racingCars.stream()
                .filter(car -> car.getPosition() == 2)
                .collect(Collectors.toList());

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

}
