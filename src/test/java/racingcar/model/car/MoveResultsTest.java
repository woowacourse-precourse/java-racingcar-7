package racingcar.model.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultsTest {
    @Test
    void 특정_시점_위치_반환() {
        MoveResults moveResults = new MoveResults();
        moveResults.add(true);
        moveResults.add(false);
        moveResults.add(true);
        moveResults.add(true);

        assertThat(moveResults.getPositionAtSpecificCount(0)).isEqualTo(1);
        assertThat(moveResults.getPositionAtSpecificCount(1)).isEqualTo(1);
        assertThat(moveResults.getPositionAtSpecificCount(2)).isEqualTo(2);
        assertThat(moveResults.getPositionAtSpecificCount(3)).isEqualTo(3);
        assertThat(moveResults.getPosition()).isEqualTo(3);
    }
}