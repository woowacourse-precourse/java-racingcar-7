package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingTrackException;

class RacingTrackTest {

    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외 발생")
    void checkDuplicatedCarName() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "pobi", "crong");

        //when & then
        assertThatThrownBy(() -> racingTrack.addCar(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingTrackException.DUPLICATED_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 존재하지 않는 경우 예외 발생하지 않음")
    void checkDuplicatedCarName_NotExist() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");

        //when & then
        assertThatCode(() -> racingTrack.addCar(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("최대 위치 반환 테스트")
    void winnerPositionTest() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");
        racingTrack.addCar(carNames);

        final int expected = 4;

        //when
        racingTrack.getCarsForTest().getFirst().move(4);
        racingTrack.getCarsForTest().getFirst().move(5);
        racingTrack.getCarsForTest().getFirst().move(6);
        racingTrack.getCarsForTest().getFirst().move(7);

        //then
        assertThat(racingTrack.getWinnerPosition())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자 이름 반환 테스트 - 우승자가 한명일 경우")
    void winnerNamesTest_OneWinner() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");
        racingTrack.addCar(carNames);

        final List<String> expected = List.of("crong");

        //when
        racingTrack.getCarsForTest().get(0).move(1);
        racingTrack.getCarsForTest().get(1).move(4);

        //then
        assertThat(racingTrack.getWinnerNames())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자 이름 반환 테스트 - 우승자가 여러명일 경우")
    void winnerNamesTest_MultipleWinners() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");
        racingTrack.addCar(carNames);

        final List<String> expected = List.of("pobi", "crong");

        //when
        racingTrack.getCarsForTest().get(0).move(4);
        racingTrack.getCarsForTest().get(1).move(4);

        //then
        assertThat(racingTrack.getWinnerNames())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("단계 진행 테스트")
    void stepProcessTest() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");
        racingTrack.addCar(carNames);

        final List<String> expected = List.of("pobi : ", "crong : ");
        //when
        var stepResult = racingTrack.step();

        //then
        for (int index = 0; index < carNames.size(); index++) {
            assertThat(stepResult.get(index)).contains(expected.get(index));
        }
    }
}