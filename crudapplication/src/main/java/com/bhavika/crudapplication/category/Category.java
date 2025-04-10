package com.bhavika.crudapplication.category;

import com.bhavika.crudapplication.BaseEntity;
import com.bhavika.crudapplication.item.Item;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "Category")
public class Category extends BaseEntity {
    @Column(
            nullable = false,
            unique = true
    )
    private String categoryName;

    @Column(
            nullable = false
    )
    private long itemCount = 0;

    private String description;

    @OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    public void updateItemCount() {
        this.itemCount = (items != null) ? items.size() : 0;
    }

}

//pending
//adding item list
