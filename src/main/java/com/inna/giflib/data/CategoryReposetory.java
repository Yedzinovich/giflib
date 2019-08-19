package com.inna.giflib.data;

import com.inna.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryReposetory {
    private static final List<Category> ALL_CATEGORY = Arrays.asList(
            new Category(1, "Tech"),
            new Category(2, "People"),
            new Category(3, "Fun")
    );

    public List<Category> getAllCategory(){
        return ALL_CATEGORY;
    }

    public Category findById(int id){
        for(Category category : ALL_CATEGORY){
            if(category.getId() == id)
                return category;
        }
        return null;
    }
}
