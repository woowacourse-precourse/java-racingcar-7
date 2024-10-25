package controller;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.domain.policy.RacingCarPolicy;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;

class RacingControllerTest {


    @DisplayName("빈팩토리에서 서비스를 생성해 주입해준다.")
    @Test
    void provideServiceFromBeanFactory() {
        //given
        RacingCarPolicy racingCarPolicy = new RacingCarPolicy();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,ming,mong", 5L);
        RacingCarService racingCarService = new RacingCarService(validatedInputDataDTO, racingCarPolicy,
                new RacingCarRepository(new HashMap<>()));

        //when
        RacingController racingController = new RacingController(racingCarService);
        //then
        org.assertj.core.api.Assertions.assertThat(racingController).isNotNull();
    }

}