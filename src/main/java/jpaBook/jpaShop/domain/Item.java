package jpaBook.jpaShop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Item은 OrderItem과 1대다
 * Category와 다대다
 * 만약 Item은 테이블이 필요가 없을 경우 abstract
 * 그리고 상속 관계는 단일 테이블일 경우
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn // 단일 테이블이기 때문에 써도 되고 안써도 됨.
public abstract class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
