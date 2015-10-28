package net.rahmony.booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_add = (Button) findViewById(R.id.bt_add);
        Button bt_show = (Button) findViewById(R.id.bt_show);

        bt_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this , AddRoomActivity.class);
                startActivity(intent);

            }
        });


        bt_show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAllActivity.class);
                startActivity(intent);

            }
        });


        Button bt_reservation = (Button)findViewById(R.id.bt_reservation);
        bt_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });






    }


    protected void onResume() {
        super.onResume();

        Realm realm = Realm.getInstance(getApplicationContext());
        List<Room> rooms = realm.allObjects(Room.class);

        EditText count = (EditText)findViewById(R.id.ed_roomNumbers);
        count.setText(rooms.size() + "");
    }
}
