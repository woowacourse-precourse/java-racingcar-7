# java-racingcar-precourse

## 구현 기능 목록

### InputView
- [x]  자동차 입력
- [x]  시도 횟수 입력

### InputValidator
- [x]  자동차 이름 5자 이하인지 확인
   - [x]  5자 초과 시 → IllegalArgumentException 발생
- [x]  `“a,,b”` 와 같이 값이 빈 경우 건너뜀
   - [x] 자동차가 없다면 → IllegalArgumentException 발생
- [x]  시도 횟수가 숫자인지 확인
   - [x] 시도 횟수가 숫자가 아니라면 → IllegalArgumentException 발생
- [x]  시도 횟수 양의 정수인지 확인
   - [x]  양의 정수가 아니라면 → IllegalArgumentException 발생

### InputParser
- [x] `,`로 자동차 이름 추출
- [x] 시도 횟수 정수로 변환
  - [x] 정수변환 불가 시 -> IllegalArgumentException 발생

### Car
- [x]  랜덤 시드 배정 후 4 이상인지 확인
- [x]  4이상이면 한 칸 증가

### RacingGame
- [x] 게임 시작
  - [x] 각 라운드 시작
  - [x] 회차 진행도 반환
- [x] 우승자 결정

### OutputView
- [x] 회차 별 진행도 출력
- [x] 우승자 출력

### Exception
- 빈 문자열 입력 시
- 자동차 이름 5글자 초과 시 
- 자동차가 없을 시 (ex. `,,,`)
- 시도 횟수가 숫자가 아닐 시
- 시도 횟수가 양의 정수가 아닐 시

## 단위 테스트
- [ ] RacingGame 단위 테스트
    - [x] 정적 팩토리 메서드 생성 확인
    - [x] start 메서드 반환 확인
    - [ ] selectWinner 확인
- [ ] Car 단위 테스트
  - [ ] 랜덤한 수가 나오는지 확인
  - [ ] totalDistance가 증가되었는지 확인
  - [ ] compareTo 정렬 결과 확인
- [ ] InputValidator 단위 테스트
  - [ ] 빈 문자열 예외처리
  - [ ] 레이싱카 배열이 비었다면 예외처리
  - [ ] 레이싱카 이름이 5글자 초과 시 예외처리
  - [ ] 시도 횟수가 숫자가 아니라면 예외처리
- [ ] InputParser 단위 테스트
  - [ ] 레이싱카의 이름이 `,`단위로 파싱되는지 확인
  - [ ] 시도 횟수가 숫자로 변환되는지 확인

## 구조
