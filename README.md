# java-racingcar-precourse

## 구현 기능 목록

- [x]  자동차 입력 화면 출력
- [x]  자동차 입력
    - [x]  자동차 이름 5자 이하인지 확인
    - [x]  5자 초과 시 → IllegalArgumentException 발생
    - [x]  `“a,,b”` 와 같이 값이 빈 경우 건너뜀
    - [ ] 자동차의 개수가 너무 많다면 → IllegalArgumentException 발생
- [x]  시도 횟수 입력 화면 출력
- [x]  시도 횟수 입력
    - [ ]  시도 횟수가 숫자인지 확인
    - [ ] 시도 횟수가 숫자가 아니라면 → IllegalArgumentException 발생
    - [x]  시도 횟수 양의 정수인지 확인
    - [x]  양의 정수가 아니라면 → IllegalArgumentException 발생
- [ ]  각 사용자에 대해) 랜덤 시드 배정 후 4 이상인지 확인
    - [ ]  4이상이면 한 칸 증가
    - [ ]  게임의 현재 회차 증가
    - [ ] 회차 진행도 출력
- [ ]  우승자 결정
- [ ]  우승자 출력

<br/>

- exception
  - 자동차 이름 5글자 초과 시 
  - 자동차의 개수가 너무 많을 시
  - 시도 횟수가 숫자가 아닐 시
  - 시도 횟수가 양의 정수가 아닐 시
  - 시도 횟수의 값이 너무 클 시