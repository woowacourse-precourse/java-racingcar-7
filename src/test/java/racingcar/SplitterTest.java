package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingInputReq;
import racingcar.model.Car;
import racingcar.util.Splitter;
import java.util.List;

class SplitterTest extends NsTest{

    @Test
    @DisplayName("자동차 이름을 구분자(,)로 분리하는지 검증")
    void splitSeparator() {
        // given
        Splitter splitter = new Splitter();
        RacingInputReq racingInputReq = new RacingInputReq("hello    ,      my, name    , is,ksj", "1");

        // when
        List<Car> carList = splitter.splitSeparator(racingInputReq);

        // then
        assertThat(carList)
                .extracting(Car::getName) // Car 객체에서 name을 추출하여 리스트로 비교
                .containsExactly("hello", "my", "name", "is", "ksj"); // 정확히 해당 값들이 포함되어 있는지 검증
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}