package entity;

import jakarta.persistence.*;

@Entity
public class Favorite extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Kullanıcı bilgisi eklenecekse buraya eklenebilir
    // Örnek: @ManyToOne private User user;

    public Favorite() {
    }

    public Favorite(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
