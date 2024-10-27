package racingcar.config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ControllerConfigTest {

    @Test
    void ControllerConfig가_싱글톤으로_인스턴스_1개만_반환되는지_확인() {
        ControllerConfig instance1 = ControllerConfig.getInstance();
        ControllerConfig instance2 = ControllerConfig.getInstance();

        assertThat(instance1).isSameAs(instance2);
    }
}
