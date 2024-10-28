package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.gameuserdata.RacingUserData;
import racingcar.model.RacingcarDataVerification;
import racingcar.splitter.RacingcarSplitter;

public class CarInputTest {

    private RacingcarSplitter racingcarSplitter = new RacingcarSplitter();
    private RacingcarDataVerification racingcarDataVerification = new RacingcarDataVerification();

    @Test
    void 자동차_객체_변환() {
        String[] RacingNameList = {"pobi", "woni", "minsu", "young"};

        List<RacingUserData> RacingCarList = racingcarSplitter.racingUserDataSplitter(RacingNameList);

        assertThat(RacingCarList).hasSize(4)
                .extracting("racingUserName")
                .containsExactly("pobi", "woni", "minsu", "young");
    }

    @Test
    void 이름이_좀_긴듯() {
        String[] RacingNameList = {"pobi", "woni", "asdfgh"};

        assertThatThrownBy(() -> racingcarDataVerification.validateRacingCarNames(RacingNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_누가함() {
        String[] RacingNameList = {""};

        assertThatThrownBy(() -> racingcarDataVerification.validateRacingCarNames(RacingNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 뭐가_빠짐() {
        String[] RacingNameList = {"pobi", ""};

        assertThatThrownBy(() -> racingcarDataVerification.validateRacingCarNames(RacingNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
