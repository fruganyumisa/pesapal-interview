package tz.co.pesapal.interview.beans;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Document(collection = "donations")
public class Donations {

    private String donorPhone;
    private Double amount;
    private String donatedAt;

    public String getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(String donatedAt) {
        this.donatedAt = donatedAt;
    }
}
