package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void racingcarInputView() {
        String racingcarNames = "pobi,woni\n3";
        InputStream writeName = new ByteArrayInputStream(racingcarNames.getBytes());
        System.setIn(writeName);


        Object[] nameAndCount = InputView.racingcarInputView();
        String racingcarName=(String)nameAndCount[0];
        String moveCount=(String)nameAndCount[1];

        System.out.println("racingCarName = " + racingcarName);
        System.out.println("racingCarCount = " + moveCount);

    }
}