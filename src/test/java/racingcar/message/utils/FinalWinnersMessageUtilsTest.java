package racingcar.message.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.message.utils.FinalWinnersMessageUtils.generateFinalWinnersMessage;

public class FinalWinnersMessageUtilsTest {

    @Test
    void TDD_단일_우승자_메세지() {
        //given
        List<RacingCar> winners = List.of(new RacingCar("pobi"));

        //when
        String message = generateFinalWinnersMessage(winners);

        //then
        assertThat(message).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void TDD_공동_우승자_메세지() {
        //given
        List<RacingCar> winners = List.of(new RacingCar("pobi"), new RacingCar("woni"));

        //when
        String message = generateFinalWinnersMessage(winners);

        //then
        assertThat(message).isEqualTo("최종 우승자 : pobi, woni");
    }
}
