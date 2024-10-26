package racingcar.message;

public enum Message {
    enterName("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    count("시도할 횟수는 몇 회인가요?"),
    newLine("\n"),
    colon(" : "),
    bar("-"),
    winner("최종 우승자 : "),
    result("실행 결과"),
    duplicateName("중복된 이름이 존재하지 않아야 합니다."),
    emptyName("자동차 이름이 빈 값입니다."),
    lengthLimit("이름의 길이는 5자 이하여야 합니다."),
    naturalNumber("입력한 횟수가 자연수가 아닙니다."),
    emptyCarList("자동차 리스트가 비어 있습니다.");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
