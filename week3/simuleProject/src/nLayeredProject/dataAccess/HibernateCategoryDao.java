package nLayeredProject.dataAccess;

import nLayeredProject.entities.Category;

public class HibernateCategoryDao implements CategoryDao{

    @Override
    public void add(Category category) {
        System.out.println("Added via Hibernate!");
    }
}
