# 우테코 7기 프리코스 2주차 - 자동차 경주

## 프로그램 구조 떠올리기

1. 이름을 입력 받는다. 이름은 (,)쉼표로 구분된다.
2. 몇번의 이동할 것인지  입력받는다
3. 이동 횟수만큼 게임을 시작한다
   - 각 이름 별로 무작위 값이 4 이상이면 1회 전진한다
4. 가장 많은 거리를 이동한 우승자를 출력한다. 우승자는 여러명일수있다.

## 예외 상황 고려하기

- 입력된 자동차 이름들의 총 개수가 1개 이하일 경우
- 입력된 자동차 이름이 알파벳이 아닌경우
- 구분되어 들어온 이름이 5글자가 넘는경우
- 입력받은 이동 횟수가 음수이거나 숫자가 아닌경우


## 기능 목록 구분하기
```
- [ ] 문자열 입력받기 view/InputView/getInput

- [ ] input을 (,)쉽표 구분자로 나눈 자동차 이름 배열을 반환 domain/ValueExtractor/getDelimitedValue

- [ ] 자동차의 개수가 1개 이상인지 판단 validator/NumberValidator/isEmptyValue & isSeveralValue

- [ ] 배열 요소들의 값이 모두 알파벳인지 확인 validator/StringValidator

- [ ] 배열의 요소중 값이 5글자 이상인 경우 판단 validator/StringValidator

- [ ] 사용자에게 이동 횟수를 입력받음 view/InputView

- [ ] 이동 횟수가 숫자인지 판단 validator/NumberValidator

- [ ] 이동 횟수가 음수인지 판단 validator/NumberValidator

- [ ] 게임을 이동횟수만큼 시작함 controller/RacingGame

- [ ] 랜덤한 숫자가 4 이상인지 판단 validator/NumberValidator

- [ ] 자동차를 전진시킴 domain/forward

- [ ] 자동차 중 이동거리 최대값을 찾음 domain/ValueExtractor

- [ ] 최대값을 가진 자동차들을 가져와 배열로 만듬 domain/ValueExtractor

- [ ] 우승자를 출력함 view/OutputView
```