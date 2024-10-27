package racingcar.io;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceRequest;
import racingcar.testutil.testdouble.ReaderFake;
import racingcar.testutil.testdouble.WriterFake;

class RaceInputHandlerTest {

    @Test
    void 자동차_이름과_시도_횟수를_입력하면_RaceInputDto객체가_반환된다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        RaceInputHandler sut = new RaceInputHandler(
                readerFake,
                writerFake,
                new RaceInputValidator()
        );
        readerFake.setInput("a,b,c,d", "3");

        //when
        RaceRequest result = sut.handle();

        //then
        Assertions.assertThat(result.getCarNames()).isEqualTo("a,b,c,d");
        Assertions.assertThat(result.getLapCount()).isEqualTo(3);
    }

    @Test
    void 자동차_이름과_시도_횟수를_입력하면_설명이_출력된다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        RaceInputHandler sut = new RaceInputHandler(
                readerFake,
                writerFake,
                new RaceInputValidator()
        );
        readerFake.setInput("a,b,c,d", "3");

        //when
        sut.handle();

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactlyInAnyOrder(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n",
                "시도할 횟수는 몇 회인가요?\n"
        );
    }

    @Test
    void 자동차_이름이_비어있으면_예외가_발생한다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        RaceInputHandler sut = new RaceInputHandler(
                readerFake,
                writerFake,
                new RaceInputValidator()
        );
        readerFake.setInput("", "3");

        //expected
        Assertions.assertThatThrownBy(() ->
                        sut.handle())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    void 시도_횟수가_비어있으면_예외가_발생한다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        RaceInputHandler sut = new RaceInputHandler(
                readerFake,
                writerFake,
                new RaceInputValidator()
        );
        readerFake.setInput("a,b,c,d", "");

        //expected
        Assertions.assertThatThrownBy(() -> sut.handle())
                .isInstanceOf(IllegalArgumentException.class);
    }
}