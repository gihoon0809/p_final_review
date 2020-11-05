package pizzalgh;

public class Addordered extends AbstractEvent {

    private Long id;
    private Long addpizzaId;
    private String addorderstatus;
    private Long addqty;

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
}