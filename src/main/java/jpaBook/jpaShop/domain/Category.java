package jpaBook.jpaShop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
 * Category는 Item과 다대다
 */
@Entity
public class Category extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 이렇게 Category가 셀프로 만듦
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM"
            , joinColumns = @JoinColumn(name = "CATEGORY_ITEM") // 내가 조인하는 아이는 요아이
            , inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대쪽 아이는 요거
    )
    private List<Item> items = new ArrayList<>();

}
