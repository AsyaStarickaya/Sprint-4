public class UserData {

    private String userName;
    private String userSurname;
    private String userPhone;
    private String metroStation;
    private String deliverDate;
    private String rentPeriodSelect;

    public UserData(String userName, String userSurname, String userPhone, String metroStation, String deliverDate, String rentPeriodSelect) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPhone = userPhone;
        this.metroStation = metroStation;
        this.deliverDate = deliverDate;
        this.rentPeriodSelect = rentPeriodSelect;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public String getRentPeriodSelect() {
        return rentPeriodSelect;
    }
}