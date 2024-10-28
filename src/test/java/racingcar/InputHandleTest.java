package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGame;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;

class InputHandleTest {
    RacingGame racingGame = new RacingGame();

    @DisplayName("입력받은 자동차 이름들을 (,)로 구분해서 리스트에 저장한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaj,minju"})
    void 자동차_라인업_만들기_테스트(String input) {
        Cars cars = racingGame.makeCars(input);
        List<String> expected = List.of("pobi", "javaj", "minju");

        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertEquals(expected.get(i), cars.getCar(i).name());
        }
    }

    @DisplayName("입력받은 이름 앞과 뒤에 공백들이 섞여 있다면, 이를 제거한다. 이름사이의 공백은 제거하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {" pobi,jav  ,  ja ,ja me"})
    void 자동차_라인업_만들기_공백처리_테스트(String input) {
        Cars cars = racingGame.makeCars(input);
        List<String> expected = List.of("pobi", "jav", "ja", "ja me");

        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertEquals(expected.get(i), cars.getCar(i).name());
        }
    }

    @DisplayName("입력받은 경주 횟수를 저장한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 경주_횟수_입력처리_테스트(String input) {
        Rounds rounds = new Rounds(input);
        Assertions.assertEquals(Integer.parseInt(input), rounds.rounds());
    }
}
