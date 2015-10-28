package net.rahmony.booking;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by User-Sai on 10/24/2015.
 */
public class Booking extends RealmObject {

    @PrimaryKey
    private int roomNumber;
    private String name ;
    private int phoneNumber ;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
