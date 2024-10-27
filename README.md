# java-racingcar-precourse

## 구현 기능 목록

- [x]  자동차 입력 화면 출력
- [x]  자동차 입력
    - [x]  자동차 이름 5자 이하인지 확인
    - [x]  5자 초과 시 → IllegalArgumentException 발생
    - [x]  `“a,,b”` 와 같이 값이 빈 경우 건너뜀
    - [x] 자동차가 없다면 → IllegalArgumentException 발생
- [x]  시도 횟수 입력 화면 출력
- [x]  시도 횟수 입력
    - [x]  시도 횟수가 숫자인지 확인
    - [x] 시도 횟수가 숫자가 아니라면 → IllegalArgumentException 발생
    - [x]  시도 횟수 양의 정수인지 확인
    - [x]  양의 정수가 아니라면 → IllegalArgumentException 발생
- [x]  각 사용자에 대해) 랜덤 시드 배정 후 4 이상인지 확인
    - [x]  4이상이면 한 칸 증가
    - [x] 회차 진행도 출력
- [x]  우승자 결정
- [x]  우승자 출력

<br/>

- exception
  - 자동차 이름 5글자 초과 시 
  - 자동차가 없을 시
  - 시도 횟수가 숫자가 아닐 시
  - 시도 횟수가 양의 정수가 아닐 시

## 단위 테스트
- [ ] 유효성 검사 테스트
- [ ] start 메서드 테스트
- [ ] selectWinners 메서드 테스트

## 구조
![woowa_2](https://github.com/user-attachments/assets/abb96dd6-e7b9-4b9a-80b3-b57bdfccdf5b)
