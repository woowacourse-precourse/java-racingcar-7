package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp(){
        this.inputView = new InputView();
    }
    @Test
    public void 차이름_유효성_검사(){
        boolean isValidateCarName = inputView.isValidateCarName("차이름");
        assertThat(isValidateCarName).isTrue();
    }
    @Test
    public void 시도숫자_유효성_검사(){
        boolean isValidateTryNum = inputView.isValidateTryNum("1");
        assertThat(isValidateTryNum).isTrue();
    }
    @Test
    void 차이름_공백인지_검사(){
        boolean isBlankCarName = inputView.isValidateCarName("      ");
        assertThat(isBlankCarName).isFalse();
    }
    @Test
    public void 시도숫자_공백값인지_검사(){
        boolean isValidateTryNum = inputView.isValidateTryNum(" ");
        assertThat(isValidateTryNum).isFalse();
    }

}