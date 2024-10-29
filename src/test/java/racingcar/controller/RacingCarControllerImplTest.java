package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.repository.InMemoryCarRepository;
import racingcar.repository.InMemoryRacingHistoryRepository;
import racingcar.service.CarServiceImpl;
import racingcar.service.InputParsingServiceImpl;
import racingcar.service.RacingHistoryServiceImpl;
import racingcar.service.RacingServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

class RacingCarControllerImplTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingCarControllerImpl racingCarController;
    OutputStream out;

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarControllerImpl(
                new ConsoleInputView(),
                new ConsoleOutputView(),
                new InputParsingServiceImpl(),
                new RacingServiceImpl(
                        InMemoryCarRepository.getInstance(),
                        InMemoryRacingHistoryRepository.getInstance()
                ),
                new CarServiceImpl(
                        InMemoryCarRepository.getInstance()
                ),
                new RacingHistoryServiceImpl(
                        InMemoryRacingHistoryRepository.getInstance()
                )
        );
        /** 저장소 초기화 **/
        InMemoryCarRepository.getInstance().updateAll(new ArrayList<>());
        InMemoryRacingHistoryRepository.getInstance().clear();
        out = new ByteArrayOutputStream();
    }

    @AfterEach
    void after() {
        InMemoryCarRepository.getInstance().updateAll(new ArrayList<>());
        InMemoryRacingHistoryRepository.getInstance().clear();
        Console.close();
    }

    @Test
    void 실행_기능_테스트() {
        //given
        String input = String.join("\n", "test1,test2", "1");
        System.setIn(createUserInput(input));
        System.setOut(new PrintStream(out));

        //when
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    racingCarController.run();
                    assertThat(out.toString()).contains(
                            "test1 : -", "test2 : ", "최종 우승자 : test1"
                    );
                }
                , MOVING_FORWARD, STOP
        );

    }

    @Test
    void 같은_이름_실행_기능_테스트() {
        //given
        String input = String.join("\n", "test1,test1", "1");
        System.setIn(createUserInput(input));
        System.setOut(new PrintStream(out));

        //when
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    racingCarController.run();
                    assertThat(out.toString()).contains(
                            "test1 : -", "test1 : ", "최종 우승자 : test1"
                    );
                }
                , MOVING_FORWARD, STOP
        );

    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
