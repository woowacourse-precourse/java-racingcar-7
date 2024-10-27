package racingcar.validation;

import racingcar.message.Message;

public class CountValidation {

    public static int convertToNaturalNum(String stringCount) {
        try {
            int count = Integer.parseInt(stringCount);
            if (count <= 0) {
                throw new IllegalArgumentException(Message.naturalNumber.getMessage());
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.naturalNumber.getMessage());
        }
    }

}
