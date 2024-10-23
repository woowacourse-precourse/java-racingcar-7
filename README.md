# java-racingcar-precourse

## 1차 기능 구현 목록
- 기본 입력
  - 경주할 자동차 이름 입력 - Console.readLine 활용
    - 쉼표로 구분 : 쉼표가 아닐 시 예외 처리
    - 이름 : 5자 이하가 아닐 시 예외 처리
    - 예외는 IllegalArgumentException으로 관리
  - 시도 횟수 입력

- 경주 진행
  - 자동차마다 0 ~ 9 사이 무작위 값 추출 후 4 이상이면 전진 - Randoms.pickNumberInRange 활용
  
- 경주 종료
  - 우승자 이름 반환
  - 우승자가 여러 명이면 쉼표 이용하여 구분


## 클래스 다이어그램
- 메시지를 선택한 후 메시지를 처리할 책임이 있는 객체를 할당하는 방법으로 클래스 다이어그램을 제작했습니다
  
![자동차 경주 1차 클래스 다이어그램 (1)](https://github.com/user-attachments/assets/bb7d9fb6-7229-4dba-a41a-8047913f59b0)



## 프로그래밍 요구사항
- 들여쓰기는 2까지 허용
- 삼항 연산자 금지
- 함수는 한 가지 일만 하도록
- Junit과 AssertJ를 이용하여 기능 목록 테스트
