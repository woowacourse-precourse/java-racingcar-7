package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.RacingGameSettingService;

public class SettingServiceTest {
    RacingGameSettingService racingGameSettingService = new RacingGameSettingService();

    @Nested
    class 자동차_이름_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {"abc,asdf","qweer,ff"})
        public void 자동차_이름은_반드시_5글자_이하_영어_소문자로만_구성된다(String input){
            Assertions.assertDoesNotThrow(() -> {
                racingGameSettingService.createCars(input);
            });
        }
        @ParameterizedTest
        @ValueSource(strings = {"abcdddd,asdf",",asdf",""," "})
        public void 자동차_이름에_5자_초과_되거나_빈_값이_오면_실패한다(String input){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                racingGameSettingService.createCars(input);
            });
        }
        @ParameterizedTest
        @ValueSource(strings = {"한", "1", "~","A"})
        public void 자동차_이름에_영어_소문자_외에_다른_문자가_오면_실패한다(String input){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                racingGameSettingService.createCars(input);
            });
        }
        @ParameterizedTest
        @ValueSource(strings = {"abc,abc","a,a"})
        public void 자동차_이름은_중복될_수_없다(String input) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                racingGameSettingService.createCars(input);
            });
        }
    }

    @Nested
    class 시도_횟수_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {"1","100","10000"})
        public void 시도_횟수는_반드시_자연수_이어야_한다(String input){
            Assertions.assertDoesNotThrow(() -> {
                racingGameSettingService.createGameRound(input);
            });
        }
        @ParameterizedTest
        @ValueSource(strings = {""," ","한", "~","A"})
        public void 시도_횟수에_자연수_이외의_다른_문자가_오면_실패한다(String input){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                racingGameSettingService.createGameRound(input);
            });
        }
    }
}
