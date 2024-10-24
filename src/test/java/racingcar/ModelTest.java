package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ModelTest {

    @Test
    void 자동차_이름은_구분자로_구분한다() {
        //준비 - 실행 - 검증
        Model model = new Model(); //준비에는 일단 실행할 클래스를 초기화한다.
        String input = "pobi,woni,jun"; //실행에 필요한 재료를 설정.

        List<String> carNames = model.getCarNames(input);
        //필요한 기능을 담당하는 메서드 이름을 실행 부분에서 일단 결정한다.(추후 변경 가능)
        //문자열을 구분자로 구분하여 반환하는 메서드가 필요하다.
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}
