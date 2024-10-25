package racingcar.domain.policy;

public interface RacingPolicy {
    Boolean isMoveForward(int randomNumber);
    String getMoveForwardSymbol();
    String getNameSeparator();
    int getNameLengthPolicy();
}
