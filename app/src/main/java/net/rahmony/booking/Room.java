package net.rahmony.booking;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by User-Sai on 10/23/2015.
 */
public class Room extends RealmObject {

    @PrimaryKey
    private int roomNumber ;
    private int floor;
    private String comment ;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
