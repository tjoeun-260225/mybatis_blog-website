-- sql 에서는 " ' 를 작 작성해야 한다
-- ' 문자열 값 리터럴 - 이건 텍스트 데이터다
-- " 식별자(테이블명/컬럼명) 이건 테이블이나 컬럼이름이다.
INSERT  INTO  posts (title, content)
VALUES ('첫 번째 글','안녕하세요');

INSERT  INTO  posts (title, content)
VALUES ('두 번째 글','mybatis로 연습 중 입니다.');