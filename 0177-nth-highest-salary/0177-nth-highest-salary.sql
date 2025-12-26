CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
Set N=N-1;
  RETURN (
      # Write your MySQL query statement below.
        Select distinct salary from Employee order by salary desc limit 1 offset n

  );
END