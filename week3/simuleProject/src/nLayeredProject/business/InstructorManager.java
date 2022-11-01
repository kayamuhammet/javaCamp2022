package nLayeredProject.business;

import nLayeredProject.core.logging.Logger;
import nLayeredProject.dataAccess.InstructorDao;
import nLayeredProject.entities.Instructor;

public class InstructorManager {
    private Instructor[] instructors;
    private InstructorDao instructorDao;
    private Logger[] loggers;

    public InstructorManager(InstructorDao instructorDao, Instructor[] instructors,  Logger[] loggers){
        this.instructors = instructors;
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    public void addInstructor(Instructor instructor) throws Exception{
        for(Instructor instructor1 : instructors){
            if(instructor1 != instructor){
                if(instructor1.getInstructorName() == instructor.getInstructorName()){
                    throw new Exception("Instructor names cannot be the same!");
                }
            }
        }

        instructorDao.add(instructor);
        for(Logger logger: loggers){
            logger.log(instructor.getInstructorName());
        }

    }
}