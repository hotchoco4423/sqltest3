package com.example.sqltest3;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "detect_result")
    private String detectResult;
    @ColumnInfo(name = "message_type")
    private String message_type;
    @ColumnInfo(name = "receive_date")
    @TypeConverters(DateConverter.class)
    private Date receiveDate;
    @ColumnInfo(name = "sender")
    private String sender;
    @ColumnInfo(name = "url_list")
    @TypeConverters(URLConverter.class)
    private List<String> urlList;
    @ColumnInfo(name = "message_body")
    private String messageBody;

    public Todo() {}

    public Todo(String detectResult, String message_type, Date receiveDate, String sender, List<String> urlList, String messageBody) {
        this.detectResult = detectResult;
        this.message_type = message_type;
        this.receiveDate = receiveDate;
        this.sender = sender;
        this.urlList = urlList;
        this.messageBody = messageBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetectResult() {
        return detectResult;
    }

    public void setDetectResult(String detectResult) {
        this.detectResult = detectResult;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", detectResult='" + detectResult + '\'' +
                ", message_type='" + message_type + '\'' +
                ", receiveDate=" + receiveDate +
                ", sender='" + sender + '\'' +
                ", urlList=" + urlList +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
