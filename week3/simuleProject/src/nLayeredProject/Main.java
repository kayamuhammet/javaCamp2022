package nLayeredProject;

import nLayeredProject.business.CategoryManager;
import nLayeredProject.business.CourseManager;
import nLayeredProject.business.InstructorManager;
import nLayeredProject.core.logging.DatabaseLogger;
import nLayeredProject.core.logging.FileLogger;
import nLayeredProject.core.logging.Logger;
import nLayeredProject.core.logging.MailLogger;
import nLayeredProject.dataAccess.HibernateCategoryDao;
import nLayeredProject.dataAccess.HibernateCourseDao;
import nLayeredProject.dataAccess.HibernateInstructorDao;
import nLayeredProject.dataAccess.JdbcCourseDao;
import nLayeredProject.entities.Category;
import nLayeredProject.entities.Course;
import nLayeredProject.entities.Instructor;

public class Main {
    public static void main(String[] args) throws Exception {
        Category category1 = new Category(0,"Programming");
        Category category2 = new Category(1,"Digital Marketing");
        Category category3 = new Category(2,"Design");
        Category category4 = new Category(3,"Personal Development");

        Instructor instructor1 = new Instructor("11111111111","Muhammet Kaya");
        Instructor instructor2 = new Instructor("22222222222","March Mathieu");
        Instructor instructor3 = new Instructor("33333333333","Calvin Klein");
        Instructor instructor4 = new Instructor("44444444444","Robin Sharma");

        Course course1 = new Course(0,"Java Programming",249.99, category1,instructor1);
        Course course2 = new Course(1,"Digital Marketing 101",59.99,category2,instructor2);
        Course course3 = new Course(2,"Web Design 101",59.99,category3,instructor3);
        Course course4 = new Course(3,"Leadership 101",59.99,category4,instructor4);

        Instructor[] instructors = {instructor1,instructor2,instructor3,instructor4};
        Course[] courses = {course1,course2,course3,course4};
        Category[] categories = {category1,category2,category3,category4};
        Logger[] loggers  = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), categories, loggers);
        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), courses, loggers);
        InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao() ,instructors,  loggers);


        System.out.println("    Logging Instructors    ");
        for(Instructor instructor: instructors){
            instructorManager.addInstructor(instructor);
            System.out.println("\n");
        }
        System.out.println("    Logging Categories     ");
        for (Category category: categories){
            categoryManager.addCategory(category);
            System.out.println("\n");
        }
        System.out.println("    Logging Courses        ");
        for (Course course:courses){
            courseManager.addCourse(course);
            System.out.println("\n");
        }



        System.out.println();
        System.out.println("*****    Contents    ***** ");
        System.out.println();

        for(Course course : courses){

            System.out.println("Course name: " + course.getCourseName() + "\nCourse Id: "+ course.getId()+
                    "\nCourse price: " + course.getCoursePrice()+ "$" +
                    "\nCourse Category: "+ course.getCategory().getCategoryName()+
                    "\nInstructor of the course: "+ course.getInstructor().getInstructorName());
            System.out.println();
        }

    }
}
