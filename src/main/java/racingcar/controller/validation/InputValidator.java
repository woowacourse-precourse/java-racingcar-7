package racingcar.controller.validation;

public interface InputValidator<T> {
    void validate(T value);
} // T가 머냐, 메세지 어케 던짐?
// TODO: 시도 횟수 + 입력 이름들은 어떻게 관리할겨?
// TODO: Car.setName 어디서 할겨?