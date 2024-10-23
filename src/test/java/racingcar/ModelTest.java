package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ModelTest {

    @Test
    void 자동차_이름은_구분자로_구분한다() {
        //준비 - 실행 - 검증
        Model model = new Model(); //준비에는 일단 실행할 클래스를 초기화한다.
        String input = "pobi,woni,jun"; //실행에 필요한 재료를 설정.

        String[] carNames = model.getCarNames(input);
        //필요한 기능을 담당하는 메서드 이름을 실행 부분에서 일단 결정한다.(추후 변경 가능)
        //문자열을 구분자로 구분하여 반환하는 메서드가 필요하다.
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름이_5자_초과시_예외발생() {
        //1.Given(준비): 어떤 상황을 준비해야 하는가? - model 객체 생성, input 세팅
        //2.When(실행): 어떤 동작을 실행하는가? - getCarName을 실행한다.
        //3.Then(검증): 기대하는 결과는 무엇인가? - 자동차 이름이 5자 초과시 예외 발생
        //3->2->1 순으로 작성해나간다.
        Model model = new Model();
        String input = "pobiwoni,jun";

        assertThrows(IllegalArgumentException.class, () -> {
            model.getCarNames(input);
        });
    }
}
