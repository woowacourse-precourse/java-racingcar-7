package racingcar.domain.referee;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;

class RefereeTest {

    @Test
    void 랩_결과를_통해_우승자를_판별한다() {
        //given
        LapResult lapResult = LapResult.fromCarStatuses(1, List.of(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 2),
                CarStatus.of("자동차 3", 3)
        ));
        Referee sut = new Referee();

        //when
        List<CarStatus> result = sut.judgeWinners(List.of(lapResult));

        //then
        Assertions.assertThat(result).containsExactly(
                CarStatus.of("자동차 3", 3)
        );
    }

    @Test
    void 우승자가_여러명인_경우_여러명을_반환한다() {
        //given
        LapResult lapResult = LapResult.fromCarStatuses(1, List.of(
                CarStatus.of("자동차 1", 3),
                CarStatus.of("자동차 2", 2),
                CarStatus.of("자동차 3", 3)
        ));
        Referee sut = new Referee();

        //when
        List<CarStatus> result = sut.judgeWinners(List.of(lapResult));

        //then
        Assertions.assertThat(result).containsExactly(
                CarStatus.of("자동차 1", 3),
                CarStatus.of("자동차 3", 3)
        );
    }

    @Test
    void 여러_랩이_입력되면_가장_최신의_랩을_기준으로_판별한다() {
        //given
        Referee sut = new Referee();
        LapResult lapResult1 = LapResult.fromCarStatuses(1, List.of(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 1),
                CarStatus.of("자동차 3", 1)
        ));
        LapResult lapResult2 = LapResult.fromCarStatuses(2, List.of(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 2),
                CarStatus.of("자동차 3", 1)
        ));

        //when
        List<CarStatus> result = sut.judgeWinners(List.of(lapResult1, lapResult2));

        //then
        Assertions.assertThat(result).containsExactly(
                CarStatus.of("자동차 2", 2)
        );
    }

    @Test
    void 여러_랩이_입력되었을_때_우승자가_여러명일_수_있다() {
        //given
        Referee sut = new Referee();
        LapResult lapResult1 = LapResult.fromCarStatuses(1, List.of(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 1),
                CarStatus.of("자동차 3", 1)
        ));
        LapResult lapResult2 = LapResult.fromCarStatuses(2, List.of(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 2),
                CarStatus.of("자동차 3", 2)
        ));

        //when
        List<CarStatus> result = sut.judgeWinners(List.of(lapResult1, lapResult2));

        //then
        Assertions.assertThat(result).containsExactly(
                CarStatus.of("자동차 2", 2),
                CarStatus.of("자동차 3", 2)
        );
    }
}