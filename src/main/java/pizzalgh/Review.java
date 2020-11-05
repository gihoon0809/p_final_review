package pizzalgh;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long addpizzaId;
    private String addorderstatus = "AddedOrdered";
    private Long addqty;
    private Long orderedId;
    private String reviewtext;

    @PostPersist
    public void onPostPersist(){
        Written written = new Written();
        BeanUtils.copyProperties(this, written);
        written.publishAfterCommit();


        Addordered addordered = new Addordered();
        BeanUtils.copyProperties(this, addordered);
        addordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        pizzalgh.external.Order order = new pizzalgh.external.Order();
        // mappings goes here

        if(this.getAddqty() != null && this.getAddqty() != 0 )
        {
            order.setOrderStatus("Ordered");
            order.setPizzaId(addordered.getAddpizzaId());
            order.setQty(addordered.getAddqty());

            ReviewApplication.applicationContext.getBean(pizzalgh.external.OrderService.class)
                    .order(order);

        }




    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getAddpizzaId() {
        return addpizzaId;
    }

    public void setAddpizzaId(Long addpizzaId) {
        this.addpizzaId = addpizzaId;
    }
    public String getAddorderstatus() {
        return addorderstatus;
    }

    public void setAddorderstatus(String addorderstatus) {
        this.addorderstatus = addorderstatus;
    }
    public Long getAddqty() {
        return addqty;
    }

    public void setAddqty(Long addqty) {
        this.addqty = addqty;
    }
    public Long getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(Long orderedId) {
        this.orderedId = orderedId;
    }
    public String getReviewtext() {
        return reviewtext;
    }

    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext;
    }




}
