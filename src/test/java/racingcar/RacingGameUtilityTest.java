package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameUtilityTest {

    @Test
    void 자동차이름_길이확인() {
        String input = "car_name1";
        assertThatThrownBy(() -> RacingGameUtility.checkNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_입력값_자르기() {
        String input = "car1,car2,car3";
        assertThat(RacingGameUtility.splitStringToArray(input, ","))
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    void 경기용자동차_생성() {
        String input = "car1,car2";
        List<String> nameList = RacingGameUtility.splitStringToArray(input, ",");
        List<RacingCar> carList = RacingGameUtility.generateRacingCar(nameList);

        assertThat(carList).hasSize(2);
        assertThat(carList.get(0).getName()).isEqualTo("car1");
        assertThat(carList.get(1).getName()).isEqualTo("car2");
    }

    @Test
    void 경기우승자_출력() {
        String input = "car1,car2";
        List<String> nameList = RacingGameUtility.splitStringToArray(input, ",");
        List<RacingCar> carList = RacingGameUtility.generateRacingCar(nameList);

        assertThat(RacingGameUtility.getResultMessage(carList)).isEqualTo("최종 우승자 : car1, car2");
    }
}
