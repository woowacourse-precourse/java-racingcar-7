package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void 전진() {
        final Car car = new Car(CarName.of("test"), 4);
        final MoveCondition moveCondition = new MoveCondition(4);
        final Participant participant = new Participant(car, 0);

        participant.move(moveCondition);

        Assertions.assertThat(participant.getScore())
                .isEqualTo(1);
    }

    @Test
    void 정지() {
        final Car car = new Car(CarName.of("test"), 4);
        final MoveCondition moveCondition = new MoveCondition(3);
        final Participant participant = new Participant(car, 0);

        participant.move(moveCondition);

        Assertions.assertThat(participant.getScore())
                .isEqualTo(0);
    }
}