package model;

public class Affiliate {

    private String id;
    private String name;

    private double comissionPaidTillDate;
    private double comissionAmountTillDate;

    public Affiliate(String id, String name) {
        this.id = id;
        this.name = name;
        this.comissionPaidTillDate = 0.0;
        this.comissionAmountTillDate = 0.0;
    }

    public double getComissionPaidTillDate() {
        return comissionPaidTillDate;
    }

    public void setComissionPaidTillDate(double comissionPaidTillDate) {
        this.comissionPaidTillDate = comissionPaidTillDate;
    }

    public double getComissionAmountTillDate() {
        return comissionAmountTillDate;
    }

    public void setComissionAmountTillDate(double comissionAmountTillDate) {
        this.comissionAmountTillDate = comissionAmountTillDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
