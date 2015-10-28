package net.rahmony.booking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Realm realm =Realm.getInstance(getApplicationContext());
        List<Room> rooms = realm.allObjects(Room.class);
        String [] roomNumbers = new String[rooms.size()];
        for(int i =0 ; i< roomNumbers.length ; i++)
        {
            roomNumbers[i]=""+rooms.get(i).getRoomNumber();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1,roomNumbers);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        final EditText ed_name = (EditText) findViewById(R.id.ed_name);
        final EditText ed_phoneNumber = (EditText) findViewById(R.id.ed_phoneNumber);

        Button bt_booking = (Button)findViewById(R.id.bt_booking);

        final Booking booking = new Booking();



        bt_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                booking.setName(ed_name.getText().toString());
                booking.setPhoneNumber(Integer.parseInt(ed_phoneNumber.getText().toString()));
                booking.setRoomNumber(Integer.parseInt(spinner.getSelectedItem()+""));


                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(booking);
                realm.commitTransaction();


                Toast.makeText(BookingActivity.this, " Done ", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
