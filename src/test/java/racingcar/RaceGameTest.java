package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.config.RaceGameConfig;
import racingcar.testutil.config.TestMoveProviderConfig;
import racingcar.testutil.config.TestReaderConfig;
import racingcar.testutil.config.TestWriterConfig;
import racingcar.testutil.testdouble.MoveProviderFake;
import racingcar.testutil.testdouble.ReaderFake;
import racingcar.testutil.testdouble.WriterFake;

class RaceGameTest {

    @Test
    void 자동차_경주를_시작한다() {
        //given
        ReaderFake reader = new ReaderFake();
        WriterFake writer = new WriterFake();
        MoveProviderFake moveProvider = new MoveProviderFake(true, false);
        RaceGameConfig config = new RaceGameConfig(
                new TestReaderConfig(reader),
                new TestWriterConfig(writer),
                new TestMoveProviderConfig(moveProvider)
        );
        RaceGame sut = new RaceGame(config);
        reader.setInput("a,b,c", "3");

        //when
        sut.play();

        //then
        Assertions.assertThat(writer.getOutputs()).contains(
                """
                        
                        실행 결과
                        a : -
                        b :\s
                        c : -
                        
                        a : -
                        b : -
                        c : -
                        
                        a : --
                        b : -
                        c : --
                        
                        최종 우승자 : a, c""");
    }
}