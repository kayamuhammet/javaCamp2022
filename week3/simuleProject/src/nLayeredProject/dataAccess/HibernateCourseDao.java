package nLayeredProject.dataAccess;

import nLayeredProject.entities.Course;

public class HibernateCourseDao implements CourseDao{
    @Override
    public void add(Course course) {
        System.out.println("It has been added via Hibernate!");
    }
}
