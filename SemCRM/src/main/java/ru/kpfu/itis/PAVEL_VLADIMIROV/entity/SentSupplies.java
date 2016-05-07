package ru.kpfu.itis.PAVEL_VLADIMIROV.entity;

import javax.persistence.*;
import java.text.ParseException;

/**
 * Created by Павел on 05.05.2016.
 */
@Entity
@Table(name = "sent_supplies")
public class SentSupplies {
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "req_sup_id")
    private Integer reqSupId;

    @Column(name = "size")
    private Integer size;

    @Column(name = "date")
    private String date;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "mass")
    private Double mass;

    @Column(name = "reciever_id")
    private Integer recieverId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "req_sup_id")
    public Integer getReqSupId() {
        return reqSupId;
    }

    public void setReqSupId(Integer reqSupId) {
        this.reqSupId = reqSupId;
    }

    @Basic
    @Column(name = "size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "date")
    public String getDate() throws ParseException {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = date;
    }

    @Basic
    @Column(name = "sender_id")
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "mass")
    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "reciever_id")
    public Integer getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Integer recieverId) {
        this.recieverId = recieverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentSupplies that = (SentSupplies) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (reqSupId != null ? !reqSupId.equals(that.reqSupId) : that.reqSupId != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        if (mass != null ? !mass.equals(that.mass) : that.mass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (reqSupId != null ? reqSupId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        return result;
    }
}
