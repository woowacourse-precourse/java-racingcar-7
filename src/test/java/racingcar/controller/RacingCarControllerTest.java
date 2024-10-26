package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

class RacingCarControllerTest {

    private final RacingCarRepositoryImpl racingCarRepository = new RacingCarRepositoryImpl();
    private final RacingCarService racingCarService = new RacingCarService(racingCarRepository);
    private final RacingCarController racingCarController = new RacingCarController(racingCarService);
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("setRacingCar 메서드를 통해 새로운 자동차 객체들을 생성할 수 있다.")
    void t001() {

        //given
        String testInput = "seo";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        //when
        racingCarController.setRacingCar(inputView);

        //then
        assertThat(racingCarService.getByName(testInput).isPresent()).isTrue();
    }

    @Test
    @DisplayName("setRacingCar 메서드를 통하여도 특정 글자수 이상의 자동차는 등록 불가하다")
    void t002() {

        //given
        String testInput = "seomoon";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.setRacingCar(inputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}