package net.rahmony.booking;
/*
* ##################################################################
*
* ########       ##         ####    ####        ##       ######    #
* ########     ######        ##      ##       ######     ##   ##   #
* ###        ####  ####      ##      ##     ####  ####   ##    ##  #
* ###        ##      ##      ##########     ##      ##   ##     ## #
* ########   ##      ##      ##########     ##      ##   ##     ## #
* ########   ##########      ##      ##     ##########   ##    ##  #
* ###        ##      ##      ##      ##     ##      ##   ##   ##   #
* ###       ####    ####    ####    ####   ####    ####  ######    #
*
* ##################################################################
* */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class AddRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        final EditText ed_roomNumber = (EditText) findViewById(R.id.ed_roomNumber);
        final EditText ed_floor = (EditText) findViewById(R.id.ed_floor);
        final EditText ed_comment = (EditText) findViewById(R.id.ed_comment);
        Button bt_addRoom = (Button)findViewById(R.id.bt_addRoom);

        final Room room = new Room();



        bt_addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                room.setRoomNumber(Integer.parseInt(ed_roomNumber.getText().toString()));
                room.setFloor(Integer.parseInt(ed_floor.getText().toString()));
                room.setComment(ed_comment.getText().toString());

                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(room);
                realm.commitTransaction();


                Toast.makeText(AddRoomActivity.this , " Done " , Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
