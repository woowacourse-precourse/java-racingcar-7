package racingcar.global.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.racing.controller.RacingController;
import racingcar.racing.service.RacingService;

class BeanConfigTest {

    @BeforeAll
    static void setUp() {
        ApplicationContext.init();
    }

    @ParameterizedTest
    @ValueSource(classes = {RacingController.class, RacingService.class})
    void 빈_생성_테스트(Class<?> beanClass) {
        // given
        Object bean = BeanConfig.getBean(beanClass);

        // when, then
        Assertions.assertThat(bean)
                .isNotNull()
                .isInstanceOf(beanClass);
    }
}