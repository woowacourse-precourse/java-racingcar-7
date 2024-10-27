package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("차수별_실행_결과_출력_테스트")
    void resultPerOneCircleTest() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("test1"));
        carList.add(new Car("test2"));
        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.resultPerOneCircle(carList);
        // then
        assertThat(out.toString()).contains("test1 : ", "test2 : ");
    }

    @Test
    @DisplayName("최종_우승자_출력_테스트")
    void winnersTest() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("test1"));
        carList.add(new Car("test2"));
        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.winners(carList);
        // then
        assertThat(out.toString()).contains("최종 우승자 : test1, test2");
    }

    @Test
    @DisplayName("최대값_반환_테스트")
    void getMaxDistanceTest() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("test1"));
        carList.add(new Car("test2"));
        // when
        int maxDistance = outputView.getMaxDistance(carList);
        //then
        assertThat(maxDistance).isEqualTo(0);
    }
}