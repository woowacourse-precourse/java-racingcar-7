package racingcar.model.dto;

import racingcar.common.exception.ErrorCode;
import racingcar.common.exception.GameException;

public class UserDto {
    public static class Input {

        private final String carName;
        private final int count;

        private Input(String carName, String count) {
            int parsedCount = validateInput(count);
            this.carName = carName;
            this.count = parsedCount;
        }

        public static Input of(String carName, String count) {
            return new Input(carName, count);
        }

        public String getCarName() {
            return this.carName;
        }

        public int getCount() {
            return this.count;
        }

        private int validateInput(String count) {
            try {
                return Integer.parseInt(count);
            } catch (NumberFormatException e) {
                throw new GameException(ErrorCode.PARSING_ERROR);
            }
        }
    }
}
