package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ErrorVerificationServiceTest {

    @Test
    void 공백_및_null_입력(){
        String inputEmpty = "";
        String inputNull = null;
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(inputEmpty);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(inputNull);
                });

    }

    @Test
    void 자동차_이름_입력_중_공백_포함(){
        String input = "a, b,c";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(input);
                });
    }

    @Test
    void 구분자_존재(){
        String input = "abcabcabc";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(input);
                });
    }
    @Test
    void 구분자_중복사용(){
        String input = "abc,,abc,abc";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(input);
                });
    }


    @Test
    void 이름이_여섯글자_이상(){
        String input = "qw123,as1234,zx124";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(input);
                });
    }

    @Test
    void 이름이_중복(){
        String input = "asd,asd,avc";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    RacingCarList racingCarList = new RacingCarList(input);
                });
    }
    @Test
    void 숫자_외_다른_문자_입력(){
        String count = "12a34";
        Application application = new Application();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    application.countNumberCheck(count);
                });
    }

}

