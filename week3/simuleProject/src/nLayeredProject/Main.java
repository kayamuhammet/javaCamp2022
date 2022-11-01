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


        Instructor instructor1 = new Instructor("Engin Demirog");

        Course course1 = new Course(0,"Java-React",0.00, category1,instructor1);
        Course course2 = new Course(1,"C#-Angular",0.00,category1,instructor1);
        Course course3 = new Course(2,"Javascript",0.00,category1,instructor1);
        Course course4 = new Course(3,"Senior .NET",0.00,category1,instructor1);
        Course course5 = new Course(4,"Java 2022",0.00,category1,instructor1);
        Course course6 = new Course(5,"Temel Kurs",0.00,category1,instructor1);

        Instructor[] instructors = {instructor1};
        Course[] courses = {course1,course2,course3,course4,course5,course6};
        Category[] categories = {category1};
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
