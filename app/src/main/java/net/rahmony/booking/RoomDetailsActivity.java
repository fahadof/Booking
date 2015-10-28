package net.rahmony.booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class RoomDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        int id = getIntent().getIntExtra("id",0);
        final Realm realm = Realm.getInstance(getApplicationContext());
        List<Room> rooms = realm.allObjects(Room.class);
        final Room room = rooms.get(id);
        TextView roomNumber = (TextView)findViewById(R.id.tv_roomNumber);
        TextView floor = (TextView)findViewById(R.id.tv_floor);
        TextView comment = (TextView)findViewById(R.id.tv_comment);
        roomNumber.setText(room.getRoomNumber()+"");
        floor.setText(room.getFloor()+"");
        comment.setText(room.getComment() + "");

        Button bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                room.removeFromRealm();
                realm.commitTransaction();

                Toast.makeText(RoomDetailsActivity.this , " Done " , Toast.LENGTH_LONG).show();

                finish();
            }
        });

       Button bt_toBooking = (Button)findViewById(R.id.bt_toBooking);
        bt_toBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomDetailsActivity.this , BookingActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
