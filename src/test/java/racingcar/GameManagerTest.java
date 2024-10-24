package racingcar;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dto.CarDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.GameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        // 테스트용 GameManager 객체 초기화
        List<String> carNames = List.of("tomi", "ss", "jun");
        int runTimes = 3;
        gameManager = new GameManager(carNames, runTimes);
    }

    @Test
    void 생성자_정상_작동() {
        assertEquals(3, gameManager.raceGameManage().get(0).size());// 사이즈 체크

        List<List<CarDTO>> raceResults = gameManager.raceGameManage();
        assertEquals(3, raceResults.size());  // runTimes 체크
    }

    @Test
    void raceOnce_정상_작동() {
        List<CarDTO> carDTOList = gameManager.raceGameManage().get(0);
        assertEquals(3, carDTOList.size()); // 사이즈 3 이어야 함

        for (int i = 0; i < carDTOList.size(); i++) {
            assertEquals(List.of("tomi", "ss", "jun").get(i), carDTOList.get(i).getName());
            assertTrue(carDTOList.get(i).getDistance() >= 0); // distance 범위 체크
        }
    }

    @Test
    void raceGameManage_정상_작동() {
        List<List<CarDTO>> raceResult = gameManager.raceGameManage();

        assertEquals(3, raceResult.size()); // size 체크
    }

    @ParameterizedTest
    @CsvSource({"1,1,3,jun", "1,3,3,ss:jun", "3,3,3,tomi:ss:jun"})
    void 우승자_선정_정상_작동(String distance1, String distance2, String distance3, String expectedOutput) {
        gameManager.raceGameManage();
        List<Car> carList = gameManager.getCarList();
        carList.get(0).setDistance(parseInt(distance1));
        carList.get(1).setDistance(parseInt(distance2));
        carList.get(2).setDistance(parseInt(distance3));

        List<String> winnerList = Arrays.asList(expectedOutput.split(":"));
        List<String> resultList = new ArrayList<>();
        for (CarDTO carInfo : gameManager.getWinner()) {
            resultList.add(carInfo.getName());
        }
        assertEquals(winnerList.toString(), resultList.toString());

    }

}
