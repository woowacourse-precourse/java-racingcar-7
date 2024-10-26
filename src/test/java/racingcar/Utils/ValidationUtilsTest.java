package racingcar.Utils;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    ValidationUtils validationUtils=new ValidationUtils();
    @Test
    @DisplayName("리스트의 길이가 5를 넘는지 체크")
    void 리스트_값_길이제한_테스트(){
        String input="qweqwe,www,eee";

        List<String> carNames = Arrays.asList(input.split(","));

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            validationUtils.validateCarNames(carNames);
        });
    }
    @Test
    @DisplayName("공백이 포함된 입력 체크")
    void 공백포함_입력테스트(){
        String input=",www,eee";

        List<String> carNames = Arrays.asList(input.split(","));

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            validationUtils.validateCarNames(carNames);
        });
    }
}
