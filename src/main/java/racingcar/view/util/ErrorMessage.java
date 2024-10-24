package racingcar.view.util;

public enum ErrorMessage {
    차_입력_에러("차 이름은 최소 2개 이상 입력해야 합니다."),
    차_이름_크기_에러("이름 사이즈가 5를 넘으면 안됩니다."),
    라운드_숫자_입력_에러("총 라운드를 나타내는 숫자가 아닙니다. 자연수를 입력해주세요."),
    라운드_양수_입력_에러("총 라운드를 나타낼 수 있는 양수만 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
