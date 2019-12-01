-- ----------------------------
-- Q1
-- ----------------------------

SELECT name from Student WHERE id = 455;

-- ----------------------------
-- Q2
-- ----------------------------
SELECT name from Student WHERE id BETWEEN 100 AND 300;

-- ----------------------------
-- Q3
-- ----------------------------
SELECT name FROM Student INNER JOIN Transcript ON Student.Id = Transcript.StudId WHERE CrsCode = "crsCode987242";

-- ----------------------------
-- Q4
-- ----------------------------
SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Teaching ON Transcript.CrsCode = Teaching.CrsCode INNER JOIN Professor ON Professor.Id = Teaching.ProfID WHERE Professor.Name = "name671686";

-- ----------------------------
-- Q5
-- ----------------------------
SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = "deptId343480" AND deptID != "deptId573856";

-- ----------------------------
-- Q6
-- ----------------------------
SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = "deptId821846";

