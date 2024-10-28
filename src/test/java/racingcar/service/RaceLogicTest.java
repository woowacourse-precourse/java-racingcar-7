package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class RaceLogicTest {

    private RaceLogic raceLogic;

    @BeforeEach
    void setUp() {
        List<String> names = List.of("kim", "lee", "park");
        int number = 3;
        MoveDecision moveDecision = new MoveDecision();
        raceLogic = new RaceLogic(names, number, moveDecision);
    }
    @Test
    @DisplayName("랜덤값에 따른 레이스 결과 테스트")
    public void raceTest() {

        List<Boolean> isFourResult = List.of(true, false, true);

        raceLogic.race(isFourResult);
        Assertions.assertThat(raceLogic.getRaceResult()).isEqualTo(List.of(1,0,1));
    }

    @Test
    @DisplayName("우승자 판별 - 1명")
    public void findWinnersTest1() {

        raceLogic.getRaceResult().set(0, 2);
        raceLogic.getRaceResult().set(1, 0);
        raceLogic.getRaceResult().set(2, 1);

        List<Integer> winners  = raceLogic.findWinners();
        Assertions.assertThat(winners).isEqualTo(List.of(0));
    }

    @Test
    @DisplayName("우승자 판별 - 여러명")
    public void findWinnersTest2() {
        raceLogic.getRaceResult().set(0, 2);
        raceLogic.getRaceResult().set(1, 0);
        raceLogic.getRaceResult().set(2, 2);

        List<Integer> winners  = raceLogic.findWinners();
        Assertions.assertThat(winners).isEqualTo(List.of(0,2));

    }

}