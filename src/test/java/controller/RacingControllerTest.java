package controller;

import common.RacingCarBeanFactory;
import dto.ValidatedInputDataDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingControllerTest {


    @DisplayName("빈팩토리에서 서비스를 생성해 주입해준다.")
    @Test
    void provideServiceFromBeanFactory() {
        //given
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,ming,mong", 5L);
        //when
        RacingController racingController = new RacingController(beanFactory, validatedInputDataDTO);
        //then
        org.assertj.core.api.Assertions.assertThat(racingController).isNotNull();
    }

}