package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class OutputTest extends NsTest {
    @Test
    void 전진하는_자동차를_출력할_때_자동차_이름을_같이_출력한다() {
        Car car1 = new Car("김종경");
        car1.move();
        List<Car> carList = new ArrayList<>();
        carList.add(car1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        new Output().printIntermediateResult(carList);

        String expectedOutput = "김종경 : -\n";
        assert expectedOutput.trim().equals(outputStream.toString().trim()) : "출력 값이 예상과 다릅니다!";

    }

    @Override
    protected void runMain() {

    }
}
