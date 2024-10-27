# java-racingcar-precourse

"어떻게 구현할 것인가" 보다 "무엇을 테스트할 것인가"를 생각해보고 테스트할 기능들을 리스트로 나열한다.

## 기능 구현 목록
- 기본 입출력 - `StringPrinter`, `StringReader`
  - 사용자 친화 입출력 - `UserInputRequester`
- 사용자 이름 입력
- 사용자 시도 횟수 입력
- 자동차 경주 게임 시작
- 가장 많이 전진한 사람들 확인 
- 자동차 전진
- 자동차 상황 출력
- 자동차 상황 파악
- 전진 조건 확인
- 자동차 이름 확인


## 잠재적 이슈(내 생각)
- [x] 사용자 이름 입력
  - `List<String>`을 반환하는 것보다 더 의미있는 객체를 반환? 
- [x] 사용자 시도 횟수 입력
  - `InputReader`가 너무 많은 역할을 하는 것은 아닐까?
  - [x] `InputReader`의 메시지를 프린트하고 읽어오는 중복 로직
- 자동차 경주 게임 시작
- 가장 많이 전진한 사람들 확인
- [x] 자동차 전진
  - [x] 숫자 직접 비교 이외에 전진 여부를 검증할 더 좋은 방법은 없을까?
  - [x] `Car`에서 `getCarStatus`를 외부로부터 숨기는게 좋지 않을까?
- [x] 자동차 상황 파악
  - [x] 현재 테스트와 상관없는 과한 로직 
- 자동차 상황 출력
- [x] 전진 조건 확인
- [] 자동차 이름 확인
  - [] 자동차에 이름을 붙일 때 문자열 길이를 확인하는게 적절?