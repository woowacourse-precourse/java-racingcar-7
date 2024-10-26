package racingcar.front.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.back.service.CarRaceGameRunnerService;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;
import racingcar.global.dto.CarRaceResponseDTO;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final CarRaceGameRunnerService carRaceGameRunnerService = new CarRaceGameRunnerServiceImpl();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        // sout을 가로 채기 위함
        System.setOut(new PrintStream(byteArrayOutputStream));
        Console.close();
    }


    @Test
    @DisplayName("서비스를 통해 게임을 싱행하고 최종 게임 결과 테스트 출력 확인")
    void 차수별_실행결과_테스트() {
        //given
        int gamePlayCount = 2;
        List<String> carNames = List.of("kim", "lee");
        //when
        assertRandomNumberInRangeTest(() -> {
            CarRaceResponseDTO carRaceResponseDTO = carRaceGameRunnerService.runGame(carNames, gamePlayCount);
            //then
            outputView.writeGameResult(carRaceResponseDTO);
            assertThat(byteArrayOutputStream.toString()).contains("실행 결과", "kim : ", "kim : ", "lee : ", "lee : ", "최종 우승자 : ", "kim, lee");

        }, STOP, STOP, STOP, STOP);
    }

}