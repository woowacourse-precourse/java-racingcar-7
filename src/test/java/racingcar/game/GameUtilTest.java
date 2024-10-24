package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.car.CarUtil;
import racingcar.util.game.GameUtil;
import racingcar.vo.CarVO;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GameUtilTest {


    @ParameterizedTest
    @ValueSource(ints = {9, 8, 7, 6, 5, 4, 3, 2, 1})
    @DisplayName("차량의 전진 OR 정지 판단")
    void 전진_아니면_정지(int number) {
        var result = GameUtil.goOrStop(number);

        if (number >= 4)
            assertThat(result).isEqualTo("-");
        else
            assertThat(result).isEmpty();
    }


    @ParameterizedTest
    @ValueSource(strings = {"koo,sang,woo"})
    @DisplayName("게임의 한 턴에 대한 결과값을 정상적으로 삽입한다.")
    void 한턴_진행_결과값_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            List<CarVO> carNameAndGoCountList = CarUtil.getCarNameAndGoCountList(carNames);
            for (var carAndCount : carNameAndGoCountList) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    carAndCount.goOneStep();
                }
                System.out.println(carAndCount.getCarName() + " : " + "-".repeat(carAndCount.getGoCount()));
            }
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"구상우,홍길동, 김천지"})
    @DisplayName("한턴을 진행해주는 함수가 업데이트 된 값을 가져와야한다.")
    void 한턴_진행_실제_함수_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            GameUtil.oneTurnPrintAndUpdate(CarUtil.getCarNameAndGoCountList(carNames));
        });
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesAndExecuteNumbers")
    @DisplayName("게임 전체를 진행하는 함수를 구현한다.")
    void 전체_진행_함수(String carNames, int executeNumber) {
        assertDoesNotThrow(() -> {
            List<CarVO> carNameAndGoCountList = CarUtil.getCarNameAndGoCountList(carNames);
            System.out.println("실행 결과");
            for (int i = 0; i < executeNumber; i++) {
                GameUtil.oneTurnPrintAndUpdate(carNameAndGoCountList);
            }

            for (CarVO car : carNameAndGoCountList) {
                System.out.println(car.toString());
            }
        });
    }

    // 매개변수 제공 메서드
    static Stream<Arguments> provideCarNamesAndExecuteNumbers() {
        return Stream.of(
                Arguments.of("koo,sang,woo", 5) // 자동차 이름과 실행 횟수
        );
    }

}
