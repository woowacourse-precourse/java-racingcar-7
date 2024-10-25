package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import model.CarList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.CarService;

public class CarServiceTest {
    static CarService carService;

    @BeforeAll
    static void setUpBeforeClass() {
        CarList carList = new CarList();
        carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
    }

    @Test
    public void CarService_우승자뽑기_한명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().getFirst().addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }

    @Test
    public void CarService_우승자뽑기_두명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().get(0).addDistance();
        carList.getCars().get(1).addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");
        expectedResult.add("carB");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }

    @Test
    public void CarService_우승자뽑기_세명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().get(0).addDistance();
        carList.getCars().get(1).addDistance();
        carList.getCars().get(2).addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");
        expectedResult.add("carB");
        expectedResult.add("carC");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }
}
