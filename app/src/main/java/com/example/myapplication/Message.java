package com.example.myapplication;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    ORM - отображение на объекты
    Интерфейс / Модель / Фабрика по работе с сообщениями
*/
public class Message {
    private static SimpleDateFormat sqlFormat = new SimpleDateFormat(App.getResourses().getString(R.string.message_data_format) );
    //model
    private String author;
    private String text;
    private Date moment;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getMoment() {
        return moment;
    }

    //Interface(не ООП понятие, а про взаимодействие)

    public Message(String author, String text, Date moment) {
        this.author = author;
        this.text = text;
        this.moment = moment;
    }
    public Message(String author, String text) {
        this.author = author;
        this.text = text;
        moment = new Date();
    }

    public String toString(){
        return this.author + R.string.dash + this.text;
    }

    // Fabric
    public static Message fromJsonToString(String json){
        //{ "id":22, "author":"Name", "text":"Message", "moment":"2020-11-11 12:12:12"
        Message msg;
        String author;
        String text;
        Date date;
        try{
            JSONObject jo = new JSONObject(json);
            author = jo.getString("author");
            text = jo.getString("text");
            date = sqlFormat.parse(jo.getString("Date"));
            return new Message(author, text, date);
        }
        catch (Exception ignored){
            return null;
        }

    }
    public static Message fromToStringToJson(JSONObject jo){
        //{ "id":22, "author":"Name", "text":"Message", "moment":"2020-11-11 12:12:12"
        Message msg;
        String author;
        String text;
        Date date;
        try{
            author = jo.getString("author");
            text = jo.getString("text");
            date = sqlFormat.parse(jo.getString("Date"));
            return new Message(author, text, date);
        }
        catch (Exception ignored){
            return null;
        }

    }
}
