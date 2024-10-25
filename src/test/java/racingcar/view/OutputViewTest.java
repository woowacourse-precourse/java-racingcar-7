package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

@DisplayName("OutputView 테스트")
public class OutputViewTest {

    private OutputView outputView;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();

        // 기존 표준 출력을 백업
        originalOut = System.out;

        // 표준 출력을 새로운 PrintStream으로 변경하여 캡처
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 자동차들의_위치를_출력한다() {
        //given
        Cars cars = new Cars(List.of(
            new Car("pobi"),
            new Car("woni"),
            new Car("jun")
        ));
        cars.getCar("pobi").move();
        cars.getCar("pobi").move();
        cars.getCar("woni").move();

        //when
        outputView.printCarPositions(cars);

        //then
        assertEquals("""
                pobi : --
                woni : -
                jun :\s
                
                """.replace("\n", System.lineSeparator()),
            outContent.toString());
    }

    @AfterEach
    public void setOut() {
        System.setOut(originalOut);
    }

}
