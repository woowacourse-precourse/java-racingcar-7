# java-racingcar-precourse

# 기능 목록

## 경주
- [x] 주어진 이동할 횟수 만큼 경주를 진행할 수 있다.
- [x] 각 자동차의 진행도에 따라 누가 우승했는지 알려줄 수 있다.

## 자동차
- [x] 자동차는 이름과 진행도를 가진다.
- [x] 자동차는 문제에서 주어진 조건에 따라 이동할 수 있다.

## 유틸리티
- [x] 0 ~ 9 사이의 무작위 값을 생성한 후 그 값이 4 이상인지 판별할 수 있다.


## 입력
- [x] 자동차의 이름을 입력받을 수 있다.
- [x] 이동할 횟수를 입력받을 수 있다.


## 입력 검증
- [x] 5글자를 초과한 이름을 입력받으면 예외처리한다.
- [x] 양의 정수가 아닌 이동 횟수를 입력받으면 예외처리한다.
- [x] 중복된 이름을 입력받으면 예외처리한다.
- [x] 빈 이름을 입력받으면 예외처리한다.
- [x] 너무 큰 수를 입력받을 경우 예외처리한다.

## 출력
- [x] 경주 진행 과정을 출력할 수 있다.
- [x] 누가 게임에서 우승했는지 출력할 수 있다.


# 학습 목표

---

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- [1주 차 공통 피드백](https://docs.google.com/document/d/1MdiqBV5nhSfFB96-p5LlKrGM8uLopXslh1vEzwxR9Bo/edit?tab=t.0)을 최대한 반영한다.



## 개인 학습 목표

- 기능을 조금 더 세부적으로 작성하고 커밋 단위를 잘게 쪼개자
- 변수명과 클래스명에 좀 더 신경을 쓰자
- 싱글톤 패턴을 적용시키면서 기능 구현하기
  - 자바 프로젝트이므로 싱글톤 홀더 방식으로 구현한다.
- 2주차 미션이 끝나고 코드리뷰를 통해 새로운 지식 배우기



## 판단한 내용

- MovementDecider는 의존성 주입이 필요없고 간단한 구조이므로 인스턴스 생성 없이 정적 메서드만
사용하도록 판단했다. 이후 기능확장이 필요하다면 그 때 인스턴스를 생성하도록 리팩토링을 해주면 된다.