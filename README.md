# java-racingcar-precourse

## 기능목록

- [x]  입력
    - [x]  경주할 자동차 이름
    - [x]  시도할 횟수
- [x]  자동차 등록 (쉼표를 기준)
    - [x] 쉼표를 기준으로 List 만들기
    - [x] List의 자동차들 등록하기
- [x]  시도할 횟수 만큼
    - [x]  각 자동차마다 무작위 번호 추출 후 이동
    - [x]  결과 출력
- [x]  우승자 선택 (여러 명 가능 - 쉼표로 구분)

🚨 이름 입력은 쉼표사이에 띄어쓰기 없고 출력에는 있음

## 예외 처리
- [x]  자동차 이름 5글자 초과하는 경우
- [x]  시도할 횟수가 숫자가 아닌 경우
- [x]  빈문자열 입력
- [x]  공백 입력 (이름 입력할 때 공백 불가능으로 변경)

→`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료

---
### 요구사항
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

---
### 전체 플로우
```
 racingcar
├── Application.class
├── controller
│   └── RacingCarController.class
├── model
│   └── Cars.class
├── validator
│   └── Validator.class
└── view
    ├── InputView.class
    └── OutputView.class
```