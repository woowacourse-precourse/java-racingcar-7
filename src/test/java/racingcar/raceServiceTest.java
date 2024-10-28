package racingcar;

import VO.CarVO;
import DAO.RaceDAO;
import Service.RaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    private RaceService raceService;
    private RaceDAO raceDAO;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        raceDAO = new RaceDAO();
    }

    @Test
    void createCarNameTest() {
        CarVO car = new CarVO();
        car.setCarName("TestCar");
        assertThat(car.getCarName()).isEqualTo("TestCar");
    }

    @Test
    void carPositionIncreaseTest() {
        CarVO car = new CarVO();
        car.setPosition(3);
        int newPosition = raceService.runing(car.getPosition());
        assertThat(newPosition).isGreaterThanOrEqualTo(3);
    }

    @Test
    void getMaxPositionTest() {
        CarVO car1 = new CarVO();
        car1.setCarName("TestCar1");
        car1.setPosition(5);
        CarVO car2 = new CarVO();
        car2.setCarName("TestCar2");
        car2.setPosition(7);
        CarVO car3 = new CarVO();
        car3.setCarName("TestCar3");
        car3.setPosition(3);

        raceDAO.inputCar(car1);
        raceDAO.inputCar(car2);
        raceDAO.inputCar(car3);

        int maxPosition = raceService.getMaxPosition(raceDAO.Carlist());
        assertThat(maxPosition).isEqualTo(7);
    }

    @Test
    void winnerCarsTest() {
        CarVO car1 = new CarVO();
        car1.setCarName("CarA");
        car1.setPosition(5);

        CarVO car2 = new CarVO();
        car2.setCarName("CarB");
        car2.setPosition(7);

        CarVO car3 = new CarVO();
        car3.setCarName("CarC");
        car3.setPosition(7);

        raceDAO.inputCar(car1);
        raceDAO.inputCar(car2);
        raceDAO.inputCar(car3);

        List<String> winners = raceService.winnerCars(raceDAO.Carlist());
        assertThat(winners).containsExactly("CarB", "CarC");
    }


    @Test
    void carListSizeTest() {
        CarVO car1 = new CarVO();
        CarVO car2 = new CarVO();
        car1.setCarName("CarA");
        car1.setPosition(5);
        car2.setPosition(7);
        car2.setCarName("CarB");
        raceDAO.inputCar(car1);
        raceDAO.inputCar(car2);

        assertThat(raceDAO.Carlist()).hasSize(2);
    }


    @Test
    void initialPositionTest() {
        CarVO car = new CarVO();
        car.setPosition(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void carPositionDisplayTest() {
        CarVO car = new CarVO();
        car.setCarName("CarD");
        car.setPosition(3);
        assertThat(car.toString()).isEqualTo("CarD : ---");
    }

}
