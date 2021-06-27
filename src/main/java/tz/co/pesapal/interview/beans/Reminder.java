package tz.co.pesapal.interview.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Document(collection = "reminders")
public class Reminder {
    private String phone;
    private Date reminderDate;
    private Date reminderTime;
    private boolean isReminded;
}
