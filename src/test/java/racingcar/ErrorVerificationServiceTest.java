package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ErrorVerificationServiceTest {
    ErrorVerificationService errorVerificationService = new ErrorVerificationService();

    @Test
    void 공백_및_null_입력(){
        String input = "";
        String count = "2";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(null,count);
                });

    }

    @Test
    void 자동차_이름_입력_중_공백_포함(){
        String input = "a, b,c";
        String count = "2";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input, count);
                });
    }

    @Test
    void 구분자_존재(){
        String input = "abcabcabc";
        String count = "2";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
    }
    @Test
    void 구분자_중복사용(){
        String input = "abc,,abc,abc";
        String count = "2";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
    }


    @Test
    void 이름이_여섯글자_이상(){
        String input = "qw123,as1234,zx124";
        String count = "2";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
    }

    @Test
    void 이름이_중복(){
        String input = "asd,asd,avc";
        String count = "2";

        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
    }
    @Test
    void 숫자_외_다른_문자_입력(){
        String input = "abc,asd,avc";
        String count = "12a34";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    errorVerificationService.checkInputValidity(input,count);
                });
    }

}

