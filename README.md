# java-calculator-precourse

## 목차

- [기능요구사항](#기능-요구-사항)
- [기능 목록](#기능-목록)
- [예외 처리](#예외-처리)
- [알아갈 것](#알아갈-것)

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록

- [x] 초기 클래스 설계
- [x] 사용자 입력 구현
- [x] 사용자의 입력으로부터 차 이름 분리 구현 
- [x] 0부터 9 의 랜덤값을 통한 차 움직임 로직 구현 
- [x] 1등 추출 로직 구현 
- [] 예외 처리 

## 예외 처리
 


## 알아갈 것

- 삼항 연산자를 왜 쓰지 말아야 하는지
- Junit 을 통한 테스트 코드 사용법
- 함수의 단위 생각해보기 
- 기존 피드백을 반영한 MVC 모델로 구현 해보기
- 기존 피드백을 반영한 커스텀 Exception 으로 예외 처리 