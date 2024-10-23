package common;

import dto.ValidatedInputDataDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingService;

class RacingCarBeanFactoryTest {

    @DisplayName("레이싱카서비스 빈을 가져올 수 있다.")
    @Test
    void getRacingService() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,dodo,lala", Long.parseLong("5"));

        //when
        RacingService racingCarService = beanFactory.provideRacingService(validatedInputDataDTO);

        //then
        Assertions.assertThat(racingCarService).isNotNull();
    }

}