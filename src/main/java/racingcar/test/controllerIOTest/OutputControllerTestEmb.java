package racingcar.test.controllerIOTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.IO.OutputController;
import racingcar.controller.IO.OutputControllerEmb;
import racingcar.model.RacingCar;
import racingcar.service.factory.CarFactory;
import racingcar.service.factory.CarFactoryEmb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputControllerTestEmb implements OutputControllerTest {
    @Override
    @Test
    public void testRequestUserCarsInput(){
        OutputController outputController = new OutputControllerEmb();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputController.requestUserCarsInput();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Override
    @Test
    public void testRequestUserRoundInput(){
        OutputController outputController = new OutputControllerEmb();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputController.requestUserRoundInput();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("시도할 횟수는 몇 회인가요?\n");
    }

    @Override
    @Test
    public void testPrintWinner(){
        OutputController outputController = new OutputControllerEmb();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        CarFactory carFactory = new CarFactoryEmb();
        ArrayList<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("b");
        carNames.add("c");
        outputController.printWinner(carFactory.createCars(carNames));
        String output = outputStream.toString();
        assertThat(output).isEqualTo("최종 우승자 : a, b, c");
    }

    @Override
    @Test
    public void testPrintCarsCurrentDistance(){
        OutputController outputController = new OutputControllerEmb();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        CarFactory carFactory = new CarFactoryEmb();
        ArrayList<String> carNames = new ArrayList<>();
        carNames.add("a");
        List<RacingCar> cars = carFactory.createCars(carNames);
        cars.get(0).increaseDistance().increaseDistance();
        outputController.printCarsCurrentDistance(cars);
        String output = outputStream.toString();
        assertThat(output).isEqualTo("a : --\n");
    }

    @Test
    public void run(){
        testPrintCarsCurrentDistance();
        testPrintWinner();
        testRequestUserCarsInput();
        testRequestUserRoundInput();
    }
}
