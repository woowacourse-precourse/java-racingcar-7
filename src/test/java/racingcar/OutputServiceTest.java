package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputServiceTest {
    private final OutputService outputService = new OutputService(new RacingCarService());

    @Test
    void a자동차_n회차_실행_결과_출력() {
        String expect = "a : -";
        RacingCar racingCar = new RacingCar("a", "-");
        String actual = racingCar.getRaceOutcomeForCarInRound(racingCar);
        assertEquals(expect, actual);
    }

    @Test
    void 공동_우승자_출력() {
        String expect1 = "최종 우승자 : pobi, jun";
        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("pobi", "--");
        RacingCar racingCar2 = new RacingCar("jun", "--");
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        String actual = outputService.getWinnerRacingCar(racingCarList);
        assertEquals(expect1, actual);
    }

    @Test
    void 단독_우승자_출력() {
        String expect = "최종 우승자 : pobi";
        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("pobi", "---");
        RacingCar racingCar2 = new RacingCar("jun", "--");
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        String actual = outputService.getWinnerRacingCar(racingCarList);
        assertEquals(expect, actual);
    }

    @Test
    void 기능_작동_테스트(){
        String carList = "pobi,woni,jun";
        int count = 4;
        outputService.run(carList, count);
    }

}
