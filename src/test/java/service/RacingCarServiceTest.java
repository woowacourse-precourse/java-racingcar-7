package service;

import static org.junit.jupiter.api.Assertions.*;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import dto.ValidatedInputDataDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.Repository;

class RacingCarServiceTest {

    @DisplayName("자동차 객체를 생성하여 repository에 저장한다.")
    @Test
    void generateCar() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 3L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);

        //when
        String result = racingService.racingStart();
        Repository repository = racingService.getRepository();

        //then
        Assertions.assertThat(repository.size()).isEqualTo(3);
    }

    @DisplayName("이름에는 중복값이 올 수 없다.")
    @Test
    void isDuplicateName() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dada", 3L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);

        //when
        Repository repository = racingService.getRepository();

        //then
        Assertions.assertThatThrownBy(racingService::racingStart).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름은 사용할 수 없습니다.");
    }

}