package assignment3.DESIGNPATTERNS.task9;

public abstract class RequisitionWithPhone extends RequisitionBase {
    public String phone;

    public RequisitionWithPhone() {
    }

    public RequisitionWithPhone(RequisitionWithPhone other) {
        super(other);
        this.phone = other.phone;
    }
}
