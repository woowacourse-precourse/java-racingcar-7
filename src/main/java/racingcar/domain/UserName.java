package racingcar.domain;

public class UserName {
    private final int MAXIMUM_LENGTH_USERNAME = 5;
    private String userName;

    public UserName(String userName) {
        checkMaximumLength(userName);
        hasOnlyCharacters(userName);
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    private void hasOnlyCharacters(String userName) {
        for (char each : userName.toCharArray()) {
            if (!Character.isLetter(each)) { // (issue) isLetter는 한글 자음 모음이 분리될 경우 false를 리턴한다
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkMaximumLength(String userName) {
        if (userName.length() > MAXIMUM_LENGTH_USERNAME) {
            throw new IllegalArgumentException();
        }
    }
}
