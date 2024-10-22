package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void updateDistance() {
        //given
        Car boye = new Car("boye", 0);
        Car sumin = new Car("sumin", 0);

        //when
        Car newboye = boye.updateDistance(boye, true);
        Car newsumin = sumin.updateDistance(sumin, false);

        //then
        Assertions.assertThat(newboye.distance()).isEqualTo(1);
        Assertions.assertThat(newsumin.distance()).isEqualTo(0);
    }
}