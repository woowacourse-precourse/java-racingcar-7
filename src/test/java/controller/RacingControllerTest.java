package controller;

import common.RacingCarBeanFactory;
import dto.OriginalInputDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingControllerTest {


    @DisplayName("빈팩토리에서 서비스를 생성해 주입해준다.")
    @Test
    void provideServiceFromBeanFactory() {
        //given
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInputDTO originalInput = new OriginalInputDTO("dada,ming,mong", "5");
        //when
        RacingController racingController = new RacingController(beanFactory, originalInput);
        //then
        org.assertj.core.api.Assertions.assertThat(racingController).isNotNull();
    }


    @DisplayName("inputData 값의 공백을 제거한다.")
    @Test
    void replaceBlankInput() {
        //given
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInputDTO originalInput = new OriginalInputDTO("dada,ming,mong", "5");
        RacingController racingController = new RacingController(beanFactory, originalInput);

        //when
        OriginalInputDTO replaceBlankInputData = racingController.replaceBlankInput(originalInput.name(), originalInput.count());
        //then
        Assertions.assertThat(replaceBlankInputData.name()).isEqualTo("dada,ming,mong");
        Assertions.assertThat(replaceBlankInputData.count()).isEqualTo("5");
    }

    @DisplayName("inputData 값이 공백이면 에러를 반환한다.")
    @Test
    void isEmptyInput() {
        //given
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInputDTO originalInput = new OriginalInputDTO(" ", " ");
        RacingController racingController = new RacingController(beanFactory, originalInput);
        OriginalInputDTO replaceBlankInputData = racingController.replaceBlankInput(originalInput.name(),originalInput.count());

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        racingController.isEmptyInput(replaceBlankInputData.name(), replaceBlankInputData.count()))
                .isInstanceOf(IllegalArgumentException.class);
    }


}