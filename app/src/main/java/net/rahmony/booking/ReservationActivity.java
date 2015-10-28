package net.rahmony.booking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;

public class ReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Realm realm =Realm.getInstance(getApplicationContext());
        List<Booking> booking = realm.allObjects(Booking.class);
        String [] roomNumbers = new String[booking.size()];
        for(int i =0 ; i< roomNumbers.length ; i++)
        {
            roomNumbers[i]=""+booking.get(i).getRoomNumber();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1,roomNumbers);
        ListView listView2 = (ListView)findViewById(R.id.listView2);
        listView2.setAdapter(adapter);
    }
}
