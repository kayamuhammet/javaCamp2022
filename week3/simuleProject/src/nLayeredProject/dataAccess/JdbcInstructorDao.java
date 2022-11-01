package nLayeredProject.dataAccess;

import nLayeredProject.entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("Added with JDBC.");
    }
}
