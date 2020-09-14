DROP TABLE IF EXISTS student;

CREATE TABLE student (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250),
  COURSE VARCHAR(255),
  ADMISSION_YEAR INT NOT NULL
);

INSERT INTO student (ID,NAME, COURSE,ADMISSION_YEAR) VALUES
  (null,'John', 'physics', '2020'),
   (null,'Ashi', 'chemistry', '1997'),
   (null,'Martin', 'maths', '1998'),
    (null,'A', 'physics', '1998'),
     (null,'B', 'chemistry', '2000'),
      (null,'C', 'maths', '2001'),
       (null,'D', 'physics', '2020'),
         (null,'E', 'chemistry', '2020'),
         (null,'F', 'maths', '2020'),
          (null,'G', 'physics', '2020'),
            (null,'H', 'chemistry', '2020'),
            (null,'I', 'maths', '2020'),
             (null,'J', 'physics', '2020'),
               (null,'K', 'chemistry', '2020'),
               (null,'Z', 'maths', '2020'),
                (null,'P', 'physics', '2020'),
                  (null,'Q', 'chemistry', '2020'),
                  (null,'R', 'maths', '1997'),
                   (null,'T', 'physics', '1999'),
                     (null,'S', 'chemistry', '1800'),
                     (null,'Y', 'maths', '2020'),
                      (null,'W', 'physics', '2020'),
                        (null,'V', 'chemistry', '2020'),
                        (null,'U', 'maths', '2020');


