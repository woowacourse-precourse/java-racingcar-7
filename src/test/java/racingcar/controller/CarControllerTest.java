package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.controller.CarController;
import racingcar.car.domain.Car;
import racingcar.car.repository.CarRepository;
import racingcar.car.service.dto.CarCreateReqDto;

public class CarControllerTest {
    private CarController carController = CarController.getInstance();
    private CarRepository carRepository = CarRepository.getInstance();
    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;

    @AfterEach
    void close() {
        carRepository.clear();
        Console.close();
    }

    @Test
    @DisplayName("자동차를 입력받고 저장한다.")
    public void saveCars() {
        // GIVEN
        inputStream = new ByteArrayInputStream("car1,car2,car3".getBytes());
        System.setIn(inputStream);
        carController.createCars();

        // WHEN
        List<Car> cars = carRepository.findAll();

        // THEN
        assertThat(cars.size()).isEqualTo(3);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo("car" + String.valueOf(i + 1));
        }
    }

    @Test
    @DisplayName("이름의 길이가 5자보다 크면, 예외를 발생시킨다.")
    public void nameRange() {
        // GIVEN
        inputStream = new ByteArrayInputStream("car1,car2,car3,overrange".getBytes());
        System.setIn(inputStream);

        // WHEN - THEN
        assertThatThrownBy(() -> carController.createCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자를 출력한다.")
    public void getWinners() {
        // GIVEN
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Car car1 = Car.from(new CarCreateReqDto("car1"));
        Car car2 = Car.from(new CarCreateReqDto("car2"));
        Car car3 = Car.from(new CarCreateReqDto("car3"));
        car2.move();
        car3.move();
        car3.move();
        carRepository.saveAll(List.of(car1, car2, car3));

        // WHEN
        carController.getWinners();

        // THEN
        assertThat(outputStream.toString()).contains("최종 우승자 : car3");
    }

    @Test
    @DisplayName("실행 횟수가 10000 이상일 경우, 예외를 발생시킨다.")
    public void over10000CountTest() {
        // GIVEN
        inputStream = new ByteArrayInputStream("10000".getBytes());
        System.setIn(inputStream);

        // WHEN - THEN
        assertThatThrownBy(() -> carController.moveCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 횟수가 0일 경우, 예외를 발생시킨다.")
    public void zeroCountTest() {
        // GIVEN
        inputStream = new ByteArrayInputStream("0".getBytes());
        System.setIn(inputStream);

        // WHEN - THEN
        assertThatThrownBy(() -> carController.moveCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 횟수가 음수일 경우, 예외를 발생시킨다.")
    public void minusCountTest() {
        // GIVEN
        inputStream = new ByteArrayInputStream("-10".getBytes());
        System.setIn(inputStream);

        // WHEN - THEN
        assertThatThrownBy(() -> carController.moveCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단독 우승자를 계산하고 출력한다.")
    public void getWinnerTest() {
        // GIVEN
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Car car1 = Car.from(new CarCreateReqDto("car1"));
        Car car2 = Car.from(new CarCreateReqDto("car2"));
        car1.move();
        carRepository.saveAll(List.of(car1, car2));

        // WHEN
        carController.getWinners();

        // THEN
        assertThat(outputStream.toString()).contains("우승자 : car1");
    }

    @Test
    @DisplayName("공동 우승자를 계산하고 출력한다.")
    public void getWinnersTest() {
        // GIVEN
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Car car1 = Car.from(new CarCreateReqDto("car1"));
        Car car2 = Car.from(new CarCreateReqDto("car2"));
        car1.move();
        car2.move();
        carRepository.saveAll(List.of(car1, car2));

        // WHEN
        carController.getWinners();

        // THEN
        assertThat(outputStream.toString()).contains("우승자 : car1, car2");
    }
}
