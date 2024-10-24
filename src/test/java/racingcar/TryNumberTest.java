package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TryNumberTest {

    private TryNumber tryNumber;

    @BeforeEach
    void SetUp(){
        tryNumber = new TryNumber();
    }

    @Test
    void 시도할_횟수_유효성_테스트() {
        assertThatThrownBy(() -> {
            tryNumber.getTryNumber("as");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
