package racingcar.view;

import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void 자동차_위치를_나타내는_선_만들기(){
        //Given
        OutputView outputView = new OutputView();
        outputView.outputTrialResult();
    }
}
