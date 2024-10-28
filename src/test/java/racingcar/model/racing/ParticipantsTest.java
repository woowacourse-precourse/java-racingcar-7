package racingcar.model.racing;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.Car;
import racingcar.model.car.strategy.RandomMove;

@DisplayName("경주 참여 자동차들 로직 관련 테스트")
class ParticipantsTest {

    @Test
    public void 자동차_단체_이동() {
        // given
        List<Car> cars = List.of(new Car(new RandomMove(), "lee")
                , new Car(new RandomMove(), "dong"));
        Participants participants = new Participants(cars);

        // when, then
        assertRandomNumberInRangeTest(() -> {
            // when
            participants.moveCars();

            // then
            Assertions.assertThat(participants.findCarsWithMovedDistance(participants.getMaxMovedDistance()))
                    .hasSize(2);
        }, 4, 5);
    }

    @Test
    public void 참가자_없을시_예외_발생() {
        // given
        List<Car> participants = List.of();

        // when, then
        Assertions.assertThatThrownBy(() -> new Participants(participants))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    public void 참가자_NULL_예외_발생() {
        // given
        List<Car> participants = null;

        // when, then
        Assertions.assertThatThrownBy(() -> new Participants(participants))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    public void 자동차_이름_중복시_예외_발생() {
        // given
        List<Car> participants = List.of(new Car(null, "chan")
                , new Car(null, "dong")
                , new Car(null, "chan"));

        // when, then
        Assertions.assertThatThrownBy(() -> new Participants(participants))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }
}