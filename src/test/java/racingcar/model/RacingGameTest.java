package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ExceptionMessage.INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private final RacingGame racingGame = new RacingGame("pobi,woni,jun");

    @DisplayName("RacingGame_생성_테스트")
    @Test
    public void newRacingGameTest() {
        //given
        //when
        //then
        assertThat(racingGame).isNotNull();
    }

    @DisplayName("records_조회_테스트")
    @Test
    public void getRecordsTest() {
        //given
        //when
        List<RacingRecord> records = racingGame.getRecords();
        //then
        assertThat(records)
                .extracting("car")
                .extracting("name")
                .containsExactly("pobi", "woni", "jun");
        assertThat(records)
                .extracting("moveDistance")
                .containsExactly(0, 0, 0);
    }

    @DisplayName("차량들_정상_이동_테스트")
    @Test
    public void racingTest() {
        //given
        List<RacingRecord> records = racingGame.getRecords();
        List<Integer> randomNumbersOfRound = List.of(3, 6, 2);
        //when
        racingGame.racing(randomNumbersOfRound);
        //then
        assertThat(records)
                .extracting("moveDistance")
                .containsExactly(0, 1, 0);
    }

    @DisplayName("최대_무작위_값_예외_테스트")
    @Test
    public void racingOverMaxExceptionTest() {
        //given
        List<Integer> randomNumbersOfRound = List.of(3, 10, 2);
        //when,then
        assertThatThrownBy(() -> racingGame.racing(randomNumbersOfRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("최소_무작위_값_예외_테스트")
    @Test
    public void racingUnderMinExceptionTest() {
        //given
        List<Integer> randomNumbersOfRound = List.of(3, -1, 2);
        //when,then
        assertThatThrownBy(() -> racingGame.racing(randomNumbersOfRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("무작위값들_생성_테스트")
    @Test
    public void generateRandomNumbers() {
        //given
        List<RacingRecord> records = racingGame.getRecords();
        int numberOfCars = records.size();
        //when
        List<Integer> randomNumbers = racingGame.generateRandomNumbers();
        //then
        assertThat(randomNumbers.size()).isEqualTo(numberOfCars);
    }
}