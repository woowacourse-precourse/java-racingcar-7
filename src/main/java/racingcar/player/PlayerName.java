package racingcar.player;

import static racingcar.player.policy.PlayerNamePolicy.MAX_LENGTH;
import static racingcar.player.policy.PlayerNamePolicy.MIN_LENGTH;

import racingcar.player.exception.PlayerNameException.NameLengthExceededException;
import racingcar.player.exception.PlayerNameException.NameLengthShortException;

public class PlayerName {
    private final String value;

    private PlayerName(String name) {
        validateLength(name);
        this.value = name;
    }
    public static PlayerName create(String name){
        return new PlayerName(name);
    }
    private void validateLength(String name){
        validateMinLength(name);
        validateMaxLength(name);
    }

    private void validateMinLength(String name){
        if(name.length()<MIN_LENGTH){
            throw new NameLengthShortException();
        }
    }

    private void validateMaxLength(String name){
        if(name.length()> MAX_LENGTH){
            throw new NameLengthExceededException();
        }
    }

    public String getValue() {
        return this.value;
    }

}
