package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 기능_작동_테스트(){
        String carList = "pobi,woni,jun";
        int count = 4;
        outputService.run(carList, count);
    }

}
