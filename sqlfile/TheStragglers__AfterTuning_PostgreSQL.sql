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
SELECT name FROM (SELECT * FROM Student INNER JOIN Transcript ON Student.Id = Transcript.StudId) AS Q WHERE CrsCode = "crsCode232280";

SELECT name FROM Student INNER JOIN Transcript ON Student.Id = Transcript.StudId WHERE CrsCode = "crsCode232280";

-- ----------------------------
-- Q4
-- ----------------------------
SELECT n FROM (SELECT Student.name AS n, Professor.Name AS pn FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Teaching ON Transcript.CrsCode = Teaching.CrsCode INNER JOIN Professor ON Professor.Id = Teaching.ProfID) AS Q WHERE pn = "name671686";

SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Teaching ON Transcript.CrsCode = Teaching.CrsCode INNER JOIN Professor ON Professor.Id = Teaching.ProfID WHERE Professor.Name = "name671686";

-- ----------------------------
-- Q5
-- ----------------------------
SELECT n FROM (SELECT Student.name as n, deptId as d FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode) AS Q WHERE d = "deptId343480" AND d != "deptId573856";

SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = "deptId343480" AND deptID != "deptId573856";

-- ----------------------------
-- Q6
-- ----------------------------
SELECT n FROM (SELECT Student.name AS n, deptId AS d FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode) AS Q WHERE d = "deptId821846";

SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = "deptId821846";
