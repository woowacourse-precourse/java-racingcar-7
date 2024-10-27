package racingcar.io;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.dto.RaceResult;
import racingcar.testutil.testdouble.WriterFake;

class RaceOutputHandlerTest {

    @Test
    void RaceResult를_Writer에_작성한다() {
        //given
        WriterFake writerFake = new WriterFake();
        RaceOutputHandler sut = new RaceOutputHandler(writerFake, new RaceResultParser(), new RaceResultValidator());

        //when
        sut.handle(getRaceResult());

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactly(
                """
                        
                        실행 결과
                        a : -
                        b :\s
                        c : -
                        
                        a : --
                        b : -
                        c : -
                        
                        a : ---
                        b : --
                        c : -
                        
                        최종 우승자 : a""");
    }

    private static RaceResult getRaceResult() {
        List<CarStatus> lap1Status = List.of(
                CarStatus.of("a", 1),
                CarStatus.of("b", 0),
                CarStatus.of("c", 1)
        );
        List<CarStatus> lap2Status = List.of(
                CarStatus.of("a", 2),
                CarStatus.of("b", 1),
                CarStatus.of("c", 1)
        );
        List<CarStatus> lap3Status = List.of(
                CarStatus.of("a", 3),
                CarStatus.of("b", 2),
                CarStatus.of("c", 1)
        );
        List<CarStatus> winners = List.of(
                CarStatus.of("a", 3)
        );
        List<LapResult> lapResults = List.of(
                LapResult.fromCarStatuses(1, lap1Status),
                LapResult.fromCarStatuses(2, lap2Status),
                LapResult.fromCarStatuses(3, lap3Status)
        );
        return RaceResult.of(lapResults, winners);
    }
}