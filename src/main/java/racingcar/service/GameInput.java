package racingcar.service;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class GameInput {
    public String getInput() {
        String input = "";

        try {
            input = Console.readLine();
            checkSoloParticipated(input);
        } catch(NoSuchElementException e) {
            handleEmptyInputException();
        }

        return input;
    }

    public int getTurn() {
        String input = "";
        int turn = 0;

        try {
            input = Console.readLine();
            turn = Integer.parseInt(input);
            checkNumberPositive(turn);
        } catch(NoSuchElementException e) {
            handleEmptyInputException();
        } catch(NumberFormatException e) {
            handleIntegerFormatException(input);
        }

        return turn;
    }

    private void handleEmptyInputException() {
        throw new IllegalArgumentException(
            "아무것도 입력하지 않았습니다. 게임을 진행할 수 없습니다"
        );
    }

    private void checkSoloParticipated(String input) {
        if(!input.contains(",")) {
            throw new IllegalArgumentException(
                "최소 2인이 참가해야 대회 진행이 가능합니다 : " + input
            );
        }
    }

    private void handleIntegerFormatException(String wrongInput) {
        throw new IllegalArgumentException(
            "숫자가 아닌 문자를 입력했거나, 제한된 횟수보다 큰 값을 입력하였습니다 : " + wrongInput
        );
    }

    private void checkNumberPositive(int turn) {
        if(turn <= 0) {
            throw new IllegalArgumentException(
                "시도 횟수에는 양수만 입력할 수 있습니다. 입력값 : " + turn
            );
        }
    }
}
