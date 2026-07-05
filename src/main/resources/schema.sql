-- schema.sql 은 테이블 구조 뼈대를 생성할 때 작성하는 SQL
-- data.sql  은 초기 데이터를 삽입할 때 작성하는 SQL
CREATE TABLE IF NOT EXISTS posts
(
    id      BIGINT AUTO_INCREMENT primary key,
    title   varchar(100) not null,
    content TEXT         NOT NULL

)

-- SQL 은 대소문자 구분이 크게 없다.
-- 스네이크 케이스로 보통 컬럼 명칭 내 구분 표기를 작성해준다.