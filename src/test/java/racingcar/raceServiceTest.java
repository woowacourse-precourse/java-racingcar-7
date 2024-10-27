package racingcar;

import Controller.RaceController;
import VO.CarVO;
import DAO.RaceDAO;
import Service.RaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceServiceTest {

    private RaceService raceService;
    private RaceDAO raceDAO;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        raceDAO = new RaceDAO();
    }

    @Test
    @DisplayName("자동차 객체를 생성하고 이름이 잘 저장되는지 테스트")
    void createCarNameTest() {
        CarVO car = new CarVO();
        car.setCarName("TestCar");
        assertThat(car.getCarName()).isEqualTo("TestCar");
    }

    @Test
    @DisplayName("자동차 위치 증가 테스트")
    void carPositionIncreaseTest() {
        CarVO car = new CarVO();
        car.setPosition(3);
        int newPosition = raceService.runing(car.getPosition());
        assertThat(newPosition).isGreaterThanOrEqualTo(3);
    }

    @Test
    @DisplayName("최대 위치값 반환 테스트")
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
    @DisplayName("우승 자동차 이름 반환 테스트")
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
    @DisplayName("자동차 리스트 생성 및 크기 확인 테스트")
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
    @DisplayName("자동차 초기 위치 설정 테스트")
    void initialPositionTest() {
        CarVO car = new CarVO();
        car.setPosition(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("위치 값에 따른 자동차 시각화 결과 확인 테스트")
    void carPositionDisplayTest() {
        CarVO car = new CarVO();
        car.setCarName("CarD");
        car.setPosition(3);
        assertThat(car.toString()).isEqualTo("CarD : ---");
    }

    @Test
    @DisplayName("자동차 리스트에서 이름으로 검색하여 자동차 반환 테스트")
    void findCarByNameTest() {
        CarVO car = new CarVO();
        car.setCarName("FindMe");
        raceDAO.inputCar(car);

        CarVO foundCar = raceDAO.findCarName("FindMe");
        assertThat(foundCar).isNotNull();
        assertThat(foundCar.getCarName()).isEqualTo("FindMe");
    }
}
