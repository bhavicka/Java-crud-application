package com.bhavika.crudapplication.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c.itemCount FROM Category c where c.categoryName = :name")
    int getItemCountByCategoryName(@Param("name") String categoryName);

    Category findByCategoryName(String name);

    @Query("SELECT c.categoryName FROM Category c ORDER BY c.itemCount ASC")
    List<String> findCategoryNamesSortedByItemCount();

    @Query("SELECT i.itemName from Item i JOIN i.itemCategory c WHERE c.categoryName = :name")
    List<String> getItemLisByCategoryName(String name);
}
