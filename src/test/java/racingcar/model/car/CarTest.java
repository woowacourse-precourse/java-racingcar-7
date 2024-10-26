package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.CarHelper;

public class CarTest {

    @Test
    @DisplayName("중간 진행 사항 확인")
    void checkLapChart() {
        // given
        String name = "JAVA";
        long remainingLap = 6L;
        String position = "---";
        Car sut = CarHelper.mock(name, remainingLap, position);

        // when
        String actual = sut.myProgressSummary();

        // then
        String expected = String.format("%s : %s", name, position);
        assertThat(actual.equals(expected)).isTrue();
    }

//    @Test
//    @DisplayName("movement value가 1일 때 내 현황 수정할 수 있다.")
//    void updateMyProgress() {
//        // given
//        String name = "JAVA";
//        long remainingLap = 3L;
//        String position = "---";
//        Car sut = CarHelper.mock(name, remainingLap, position);
//
//        // when
//        sut.updateProgress(Distance.ONE);
//
//        // then
//        assertThat(sut.toString()).isEqualTo("----");
//    }
}
