package com.example.live_dataa_applicationsecod.Modelclass;

public class Model_class {

    String amount,stats,data;

    public Model_class(String amount, String stats, String data) {
        this.amount = amount;
        this.stats = stats;
        this.data = data;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
