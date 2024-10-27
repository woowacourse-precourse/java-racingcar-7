package racingcar.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarInputHandlerTest {
    CarInputHandler carInputHandler = new CarInputHandler();

    @Test
    void 이름입력_테스트() {
        String[] names = carInputHandler.inputRacerNames();

    }

}