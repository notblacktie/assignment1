package assignment3.DESIGNPATTERNS.task9;

public abstract class RequisitionBase extends AbstractEntity {
    public User user;
    public String name;
    public String mail;
    public String utmMark;
    public String webinarType;
    public String promoCode;

    public RequisitionBase() {
    }

    public RequisitionBase(RequisitionBase other) {
        super(other);
        this.user = (other.user == null) ? null : (User) other.user.clone();
        this.name = other.name;
        this.mail = other.mail;
        this.utmMark = other.utmMark;
        this.webinarType = other.webinarType;
        this.promoCode = other.promoCode;
    }
}
