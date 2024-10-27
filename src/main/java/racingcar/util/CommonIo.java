package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class CommonIo {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public String receiveInput() {
        return Console.readLine();
    }

    public int convertStringToInt(String message) {
        return Integer.parseInt(message);
    }

    public String removeWhiteSpace(String message) {
        return message.replaceAll(Message.WHITE_SPACE.getSentence(), Message.BLANK.getSentence());
    }
}
