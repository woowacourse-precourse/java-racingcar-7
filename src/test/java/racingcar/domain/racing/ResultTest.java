package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

class ResultTest {

    @DisplayName("경주 결과는 자동차 이름(key)과 현재 위치(value)를 저장한다")
    @Test
    void 경주_결과_저장() {
        Name name = Name.from("pobi");
        Position position = Position.zero();
        Result result = Result.empty();

        result.save(name, position);

        assertThat(result.getResult())
                .containsKey(name)
                .containsValue(position);
    }

}
