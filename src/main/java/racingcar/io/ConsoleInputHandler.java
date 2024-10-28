package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInputHandler {

    public String getVehicleListInput() {
        String vehicleListInput = Console.readLine();
        if (vehicleListInput == null || vehicleListInput.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return vehicleListInput;
    }

    public int getMoveTryCount() {
        try {
            String moveTryCountString = Console.readLine();

            if (moveTryCountString == null || moveTryCountString.isBlank()) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            int moveTryCount = Integer.valueOf(moveTryCountString);

            if(moveTryCount < 0)
                throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");

            return moveTryCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");}

    }

}
