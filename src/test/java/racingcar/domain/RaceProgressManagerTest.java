package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RaceResult;
import racingcar.exception.RacingCarException;

import java.util.List;

class RaceProgressManagerTest {

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(strings = {"BMW,BMW", "Audi,Audi"})
        @DisplayName("자동차 이름이 중복될 경우 예외가 발생한다")
        void 자동차_이름이_중복될_경우_예외가_발생한다(String input) {
            String[] names = input.split(",");
            RacingCar car1 = new RacingCar(names[0].trim());
            RacingCar car2 = new RacingCar(names[1].trim());

            assertThatThrownBy(() -> new RaceProgressManager(List.of(car1, car2)))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACE_PROGRESS_MANAGER_DUPLICATE_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("존재하지 않는 자동차의 진행 상황을 업데이트하려고 하면 예외가 발생한다")
        void 존재하지_않는_자동차의_진행_상황을_업데이트할_경우_예외가_발생한다() {
            RacingCar car = new RacingCar("Audi");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));
            RacingCar nonExistentCar = new RacingCar("Tesla");

            assertThatThrownBy(() -> manager.updateProgressForForward(nonExistentCar))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACE_PROGRESS_MANAGER_CAR_NOT_FOUND.getMessage());
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("자동차의 진행 상황을 정상적으로 업데이트한다")
        void 자동차의_진행_상황을_정상적으로_업데이트한다() {
            RacingCar car = new RacingCar("Mini");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));

            manager.updateProgressForForward(car);
            RaceResult result = manager.createRaceResult();

            assertThat(result.raceProgress().get("Mini")).isEqualTo(1);
        }

        @Test
        @DisplayName("경주 결과를 생성하면 원래의 진행 상황이 불변성을 유지한다")
        void 경주_결과_생성시_불변성_유지() {
            RacingCar car = new RacingCar("Jeep");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));

            manager.updateProgressForForward(car);
            RaceResult result1 = manager.createRaceResult();
            manager.updateProgressForForward(car);
            RaceResult result2 = manager.createRaceResult();

            assertThat(result1.raceProgress().get("Jeep")).isEqualTo(1);
            assertThat(result2.raceProgress().get("Jeep")).isEqualTo(2);
        }
    }
}
