package racingcar.io;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputWriterTest extends NsTest {

    private final OutputWriter outputWriter = new OutputWriter();
    private final List<Car> cars = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        init();
    }
    @AfterEach
    void afterEach() {
        printOutput();
        cars.clear();
    }

    @Test
    @DisplayName("중간_결과_출력_테스트")
    void 중간_결과_출력_테스트() {
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        cars.get(0).move();
        cars.get(2).move();
        outputWriter.printIntermediateResult(cars);

        assertThat(output()).contains("pobi : -\n" + "woni : \n" + "jun : -");
    }

    @Test
    @DisplayName("최종_결과_출력_테스트1")
    void 최종_결과_출력_테스트1() {
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
        cars.add(new Car("jaewoong"));

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(3).move();
        cars.get(3).move();
        outputWriter.printFinalResult(cars);

        assertThat(output()).contains("최종 우승자 : jaewoong");
    }

    @Test
    @DisplayName("최종_결과_출력_테스트2")
    void 최종_결과_출력_테스트2() {
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jaewoong"));

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        outputWriter.printFinalResult(cars);

        assertThat(output()).contains("최종 우승자 : pobi, woni, jaewoong");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}