package nLayeredProject.dataAccess;

import nLayeredProject.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("It has been added via Hibernate!");
    }
}
