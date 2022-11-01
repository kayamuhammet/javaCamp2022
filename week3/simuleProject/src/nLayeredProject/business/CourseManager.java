package nLayeredProject.business;

import nLayeredProject.core.logging.Logger;
import nLayeredProject.dataAccess.CourseDao;
import nLayeredProject.entities.Course;

public class CourseManager {
    private CourseDao courseDao;
    private Course[] courses;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, Course[] courses, Logger[] loggers){
        this.courseDao = courseDao;
        this.courses = courses;
        this.loggers = loggers;

    }

    public void addCourse(Course course) throws Exception{
        if (course.getCoursePrice() < 0){
            throw new Exception("Course prices could not be lower than 0!");
        }
        //name controller
        for (Course currentCourse: courses){
            if(currentCourse != course){
                if(currentCourse.getCourseName() == course.getCourseName()){
                    throw new Exception("Name of the courses could not be the same!");
                }
            }
        }
        // id controller
        for (Course currentCourse: courses){
            if (currentCourse != course){
                if (currentCourse.getId() == course.getId()){
                    throw new Exception("Id of the courses could not be the same");
                }
            }
        }
        courseDao.add(course);
        for(Logger logger: loggers){
            logger.log(course.getCourseName());
        }

    }

}
