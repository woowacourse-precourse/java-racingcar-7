package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;

class RacingCarServiceTest {

    private final RacingCarRepositoryImpl racingCarRepository = new RacingCarRepositoryImpl();
    private final RacingCarService racingCarService = new RacingCarService(racingCarRepository);

    @Test
    @DisplayName("자동차 객체의 생성과 저장을 요청할 수 있다")
    void t001() {
        List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "seo"));

        racingCarService.createAll(carNames);

        assertThat(racingCarService.getByName(carNames.get(0)).isPresent()).isTrue();
        assertThat(racingCarService.getByName(carNames.get(1)).isPresent()).isTrue();
    }

    @Test
    @DisplayName("특수 구분자로 나눠진 여러 자동차의 이름들을 분리할 수 있다")
    void t002() {
        String input = "pobi,seo";

        List<String> results = racingCarService.processingCarNames(input);

        assertThat(results.get(0)).isEqualTo("pobi");
        assertThat(results.get(1)).isEqualTo("seo");
    }

    @Test
    @DisplayName("자동차들의 이름들이 유효한지 검사를 요청할 수 있다")
    void t003() {
        List<String> correctInput = new ArrayList<>(Arrays.asList("pobi", "seo"));
        List<String> incorrectInput = new ArrayList<>(Arrays.asList("seomoon", "javajigi"));

        assertThatCode(() -> {
            racingCarService.validateCarNames(correctInput);
        }).doesNotThrowAnyException();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarService.validateCarNames(incorrectInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수가 올바른지 검사를 요청할 수 있다")
    void t004() {
        String correctRaceCount = "3";
        String incorrectRaceCount = "-3";

        assertThatCode(() -> {
            racingCarService.validateRaceCount(correctRaceCount);
        }).doesNotThrowAnyException();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarService.validateRaceCount(incorrectRaceCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("경주를 통해 이동거리가 변화한다")
    void t005() {
        String carName = "seo";
        String raceCount = "100";
        racingCarService.createAll(List.of(carName));
        RacingCar racingCar = racingCarService.getByName(carName).get();
        BigInteger beforeDistance = racingCar.getDistance();

        racingCarService.startRacingAndTracking(new BigInteger(raceCount));

        BigInteger afterDistance = racingCar.getDistance();
        assertThat(beforeDistance).isLessThan(afterDistance);
    }

    @Test
    @DisplayName("경주를 통해 궤적이 기록된다")
    void t006() {
        boolean findFlag = false;
        String carName = "seo";
        String raceCount = "100";
        racingCarService.createAll(List.of(carName));

        Map<String, String>[] resultMap = racingCarService.startRacingAndTracking(new BigInteger(raceCount));

        for (int i = 0; i < Integer.parseInt(raceCount); i++) {
            String track = carName + " : " + resultMap[i].get(carName);
            if (track.equals(carName + " : " + "-")) {
                findFlag = true;
                break;
            }
        }

        assertThat(findFlag).isTrue();
    }

}