package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.car.CarUtil;
import racingcar.util.game.GameUtil;
import racingcar.vo.CarVO;

import java.util.List;

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
                int randomNumber = Randoms.pickNumberInRange(0,9);
                if (randomNumber >= 4) {
                    carAndCount.goOneStep();
                }
                System.out.println(carAndCount.getCarName() + " : " + "-".repeat(carAndCount.getGoCount()));
            }
        });
    }



}
