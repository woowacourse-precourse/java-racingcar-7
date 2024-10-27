# java-racingcar-precourse

[입력]

1. 자동차 이름
    - 공백 제거
    - 글자 수 유효성 검증(5자 초과 입력시 IllegalArgumentException() 던지기)
2. 시도할 횟수
    - 입력 유효성 검증(양수 제외 입력시 IllegalArgumentException() 던지기)

[로직]

1. 조건에 따라 전진/멈춤 + 차수별 실행 결과 출력
    - 범위 내에서 난수 생성 후 조건에 따라 진행
    - 경계값 이상일 때 전진
2. 최종 우승자 도출 + 단독 및 공동 우승자 안내 문구(여러 명일땐 콤마로 구분) 출력
