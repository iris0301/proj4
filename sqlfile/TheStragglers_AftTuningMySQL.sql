#set profiling to track duration of query time
SET profiling =  1;
SET @v1 = 204050;
SET @v2 = 204050;
SET @v3 = 808125;
SET @v4 = 'crsCode792250';
SET @v5 = 'name650236';
SET @v6 = 'deptId60146';
SET @v7 = 'deptId978847';
SET @v8 = 'deptId617917';

CREATE INDEX sInds ON Student (name);
CREATE INDEX cIndDep ON Course (deptId asc);
CREATE INDEX pIndsNam ON Professor (name asc);
CREATE INDEX tInds ON Transcript (studId asc);
CREATE INDEX tIndsCrs ON Transcript (crsCode asc);
CREATE INDEX teInds ON Teaching (crsCode asc);
CREATE INDEX teIndsPro ON Teaching (profId asc);

#query 1
Select * from Student where id = @v1; 

#query 2
Select * from Student where id between @v2 and @v3; 

#query 3 CHANGED TO INNER JOINS
Select s.name from Student s INNER JOIN Transcript t ON s.id = t.studId INNER JOIN Course c USING (crsCode) WHERE crsCode = @v4;

#query 4 CHANGED TO INNER JOINS
Select s.name from Student s INNER JOIN Transcript t ON s.id = t.studId INNER JOIN Teaching te USING (crsCode) INNER JOIN Professor p ON te.profId = p.id WHERE p.name = @v5;

#query 5 CHANGED TO INNER JOINS
Select s.name from Student s INNER JOIN Transcript t ON t.studId = s.id INNER JOIN Course c USING (crsCode) WHERE c.deptId = @v6 AND c.deptId!= @v7;

#query 6 CHANGED TO INNER JOINS
Select s.name from Student s INNER JOIN Transcript t ON s.id = t.studId INNER JOIN Course c USING (crsCode) WHERE c.deptId = @v8;

#displays the profile table that keeps track of query duration
SHOW PROFILES;