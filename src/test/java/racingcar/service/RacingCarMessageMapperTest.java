package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.racing.Results;
import racingcar.dto.RacingCarResponse;

class RacingCarMessageMapperTest {

    @DisplayName("경주 결과들과 최종 우승자 이름들을 자동차 경주 응답으로 변환한다")
    @Test
    void 응답_변환() {
        Results results = Results.empty();
        results.saveAll(List.of(new Car("pobi"), new Car("woni")));
        List<Name> winners = List.of(Name.from("pobi"));

        RacingCarResponse response = RacingCarMessageMapper.toResponse(results, winners);

        assertThat(response.racingResults().getFirst())
                .containsKeys("pobi", "woni")
                .containsValues(0, 0);
        assertThat(response.winnerNames()).containsExactly("pobi");
    }

}
