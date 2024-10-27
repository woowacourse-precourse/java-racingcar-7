package racingcar.racingcar.service.racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.move.MoveService;
import racingcar.racingcar.service.racing.dto.RacingResult;
import racingcar.racingcar.service.racing.impl.RacingResultCalculator;
import racingcar.racingcar.service.racing.impl.WinningCar;
import racingcar.trynumber.domain.TryNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingProcessTest {

    @Test
    @DisplayName("공동 우승자 3명")
    void testThreeJointWinners() {
        List<RacingCar> racingCarList = List.of(
                RacingCar.of("pobi"),
                RacingCar.of("woni"),
                RacingCar.of("jun")
        );

        String executeResult = String.join("\n",
                "pobi : -",
                "woni : -",
                "jun : -",
                "",
                "pobi : --",
                "woni : --",
                "jun : --",
                "",
                "pobi : ---",
                "woni : ---",
                "jun : ---",
                "",
                "pobi : ----",
                "woni : ----",
                "jun : ----",
                "",
                "pobi : -----",
                "woni : -----",
                "jun : -----"
        );

        String winnerStatistic = "pobi, woni, jun";

        RacingCarInfo racingCarInfo = new RacingCarInfo(racingCarList);
        TryNumber tryNumber = TryNumber.of(5);
        RacingService racingService = new RacingProcessImplTest(
                new ThreeJointFirstPlace(),
                new WinningCar(new RacingResultCalculator()),
                List.of(executeResult, winnerStatistic)
        );
        racingService.racing(racingCarInfo, tryNumber);
    }

    @Test
    @DisplayName("공동 우승자 2명")
    void testTwoJointWinners() {
        List<RacingCar> racingCarList = List.of(
                RacingCar.of("pobi"),
                RacingCar.of("woni"),
                RacingCar.of("jun")
        );

        String executeResult = String.join("\n",
                "pobi : -",
                "woni : -",
                "jun : ",
                "",
                "pobi : --",
                "woni : --",
                "jun : ",
                "",
                "pobi : ---",
                "woni : ---",
                "jun : ",
                "",
                "pobi : ----",
                "woni : ----",
                "jun : ",
                "",
                "pobi : -----",
                "woni : -----",
                "jun : "
        );

        String winnerStatistic = "pobi, woni";

        RacingCarInfo racingCarInfo = new RacingCarInfo(racingCarList);
        TryNumber tryNumber = TryNumber.of(5);
        RacingService racingService = new RacingProcessImplTest(
                new TwoJointFirstPlace(),
                new WinningCar(new RacingResultCalculator()),
                List.of(executeResult, winnerStatistic)
        );
        racingService.racing(racingCarInfo, tryNumber);
    }

    @Test
    @DisplayName("우승자 1명")
    void testSingleWinner() {
        List<RacingCar> racingCarList = List.of(
                RacingCar.of("pobi"),
                RacingCar.of("woni"),
                RacingCar.of("jun")
        );

        String executeResult = String.join("\n",
                "pobi : -",
                "woni : ",
                "jun : ",
                "",
                "pobi : --",
                "woni : ",
                "jun : ",
                "",
                "pobi : ---",
                "woni : ",
                "jun : ",
                "",
                "pobi : ----",
                "woni : ",
                "jun : ",
                "",
                "pobi : -----",
                "woni : ",
                "jun : "
        );

        String winnerStatistic = "pobi";

        RacingCarInfo racingCarInfo = new RacingCarInfo(racingCarList);
        TryNumber tryNumber = TryNumber.of(5);
        RacingService racingService = new RacingProcessImplTest(
                new FirstPlace(),
                new WinningCar(new RacingResultCalculator()),
                List.of(executeResult, winnerStatistic)
        );
        racingService.racing(racingCarInfo, tryNumber);
    }
}

class RacingProcessImplTest implements RacingService {
    private final MoveService moveProcess;
    private final WinningCar winningCar;
    private final List<String> expectedInfo;

    public RacingProcessImplTest(MoveService moveProcess, WinningCar winningCar, List<String> expectedInfo) {
        this.moveProcess = moveProcess;
        this.winningCar = winningCar;
        this.expectedInfo = expectedInfo;
    }

    @Override
    public void racing(RacingCarInfo racingCarInfo, TryNumber tryNumber) {
        assertThat(executeRace(racingCarInfo, tryNumber).toString().trim()).isEqualTo(expectedInfo.get(0).trim());
        assertThat(winningCarStatistic(racingCarInfo).trim()).isEqualTo(expectedInfo.get(1).trim());
    }

    private String winningCarStatistic(RacingCarInfo racingCarInfo) {
        return winningCar.WinningCarsResult(racingCarInfo);
    }

    private String move(RacingCarInfo racingCarInfo) {
        return moveProcess.move(racingCarInfo);
    }

    private RacingResult executeRace(RacingCarInfo racingCarInfo, TryNumber tryNumber) {
        return Stream.generate(() -> move(racingCarInfo))
                .limit(tryNumber.getCount())
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingResult::new));
    }
}

class ThreeJointFirstPlace implements MoveService {
    @Override
    public String move(RacingCarInfo racingCarInfo) {
        racingCarInfo.getRacingCarInfo().forEach(this::move);
        return racingCarInfo.toString();
    }

    public void move(RacingCar racingCar) {
        racingCar.increaseMoveCount();
    }
}

class TwoJointFirstPlace implements MoveService {
    @Override
    public String move(RacingCarInfo racingCarInfo) {
        racingCarInfo.getRacingCarInfo().forEach(this::move);
        return racingCarInfo.toString();
    }

    public void move(RacingCar racingCar) {
        if (racingCar.equals(RacingCar.of("pobi")) || racingCar.equals(RacingCar.of("woni")))
            racingCar.increaseMoveCount();
    }
}

class FirstPlace implements MoveService {
    @Override
    public String move(RacingCarInfo racingCarInfo) {
        racingCarInfo.getRacingCarInfo().forEach(this::move);
        return racingCarInfo.toString();
    }

    public void move(RacingCar racingCar) {
        if (racingCar.equals(RacingCar.of("pobi"))) racingCar.increaseMoveCount();
    }
}
