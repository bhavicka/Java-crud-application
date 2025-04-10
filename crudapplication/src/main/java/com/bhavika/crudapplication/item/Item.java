package com.bhavika.crudapplication.item;

import com.bhavika.crudapplication.BaseEntity;
import com.bhavika.crudapplication.category.Category;
import com.bhavika.crudapplication.category.CategoryMapper;
import com.bhavika.crudapplication.category.CategoryRepository;
import com.bhavika.crudapplication.category.CategoryService;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "Item")
public class Item extends BaseEntity {
    @Column(
            unique = true,
            nullable = false
    )
    private String itemName;

    @Column(nullable = false)
    private long itemPrice;

    @Column(nullable = false)
    private int count;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category itemCategory;

    private String itemDescription;

    @Column(nullable = false)
    private boolean inStock;
}
