package tz.co.pesapal.interview.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Document(collection = "donors")
public class Donor {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int donorType;  // 1 - One -Off, 2 -Monthly and 3- Annually
    private LocalDate createdAt;
    private LocalDate lastDonation;
    private LocalDate scheduledOn;

}
