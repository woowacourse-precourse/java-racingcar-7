package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("이름과 -이 제대로 나오는지 확인")
    @Test
    void resultPrintTest() {
        RacingCar car1 = new RacingCar("car1");
        RacingCar car2 = new RacingCar("car2");

        car1.goAhead(5);
        car1.goAhead(5);
        car2.goAhead(5);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);


        outputView.printResult(cars);
        System.out.println(byteArrayOutputStream.toString());
        Assertions.assertThat(byteArrayOutputStream.toString().trim()).contains(
                "실행 결과",
                "car1 : --",
                "car2 : -"
        );
    }

    @DisplayName("한명이면 그냥 출력 여러명이면 ,로 구분해서 출력")
    @Test
    void winnerPrintTest() {
        List<String> winners1 = new ArrayList<>();
        List<String> winners2 = new ArrayList<>();

        winners1.add("김은지");

        winners2.add("a");
        winners2.add("b");


        outputView.printWinner(winners1);
        outputView.printWinner(winners2);

        Assertions.assertThat(byteArrayOutputStream.toString().trim()).contains(
                "최종 우승자 : 김은지",
                "최종 우승자 : a, b"

        );
    }

}