package racingcar.io.read;

public class IntegerReader extends AbstractReader<Integer> {

    @Override
    public Integer read() {
        String read = super.readString();
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
