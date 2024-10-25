package racingcar.model;

public class Round {
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "정수를 입력해주세요.";
    private int length;

    public Round(String lengthStringInput) {
        try {
            this.length = Integer.valueOf(lengthStringInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public int length() {
        return length;
    }
    /*
    list의 길이를 구하기 위해서 length() 메소드를 받는 것에 착안해서
    getLength() 처럼 get...을 쓰는 컨벤션을 버리고, 새로운 방식으로
    getter 이름을 정해봤다!
    */
}
