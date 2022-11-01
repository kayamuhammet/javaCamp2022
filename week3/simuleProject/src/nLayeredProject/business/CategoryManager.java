package nLayeredProject.business;

import nLayeredProject.core.logging.Logger;
import nLayeredProject.dataAccess.CategoryDao;
import nLayeredProject.entities.Category;

public class CategoryManager {
    private CategoryDao categoryDao;
    private Category[] categories;
    private Logger[] loggers;

    public CategoryManager(CategoryDao categoryDao,  Category[] categories, Logger[] loggers){
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }

    public void addCategory(Category category) throws Exception{
        // categoryName Controller
        for (Category currentCategory : categories){
            if(currentCategory != category){
                if(currentCategory.getCategoryName() == category.getCategoryName()){
                    throw new Exception("Category can not be the same!");
                }
            }
        }
        // id Controller
        for (Category currentCategory : categories){
            if(currentCategory != category){
                if(currentCategory.getId() == category.getId()){
                    throw new Exception("ID of the categories can not be the same!");
                }
            }
        }
        categoryDao.add(category);

        for(Logger logger: loggers){
            logger.log(category.getCategoryName());
        }


    }
}
