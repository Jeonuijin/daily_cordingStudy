SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG
 FROM STUDENT
 ORDER BY ID
;
---------------------------------------------
SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG
 FROM STUDENT
WHERE ID = :id --보안상의 이유로 prepared statement를 쓰는 것이 좋다.
;
----------------------
--UPDATE
SELECT * FROM STUDENT;
SELECT * FROM STUDENT WHERE ID = '2023002';

UPDATE STUDENT
    SET NAME = '홍길동UPD'
       , KOR = 98
       , ENG = 88
       , MATH = 78
WHERE ID = '2023002';

--PREPARED 방식으로 삭제하기
DELETE FROM SUDENT
WHERE ID = :id;