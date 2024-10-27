package racingcar.custom_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        outputView = OutputView.getInstance();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("중간 출력 확인")
    void interimOutputViewTest(){
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("benz"));
        carList.add(new Car("audi"));
        carList.add(new Car("kia"));
        String result = "benz : \naudi : \nkia : \n\n";
        //when
        outputView.printInterimResult(carList);
        //then
        Assertions.assertEquals(result,outputStream.toString());
    }
    @Test
    @DisplayName("최종 결과 확인")
    void outputViewTest(){
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("benz"));
        carList.add(new Car("audi"));
        carList.add(new Car("kia"));
        //when
        String result = "최종 우승자 : benz, audi, kia\n";
        outputView.printResult(carList);
        //then
        Assertions.assertEquals(result,outputStream.toString());
    }
}
