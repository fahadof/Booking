package net.rahmony.booking;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;

public class ShowAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        Realm realm =Realm.getInstance(getApplicationContext());
        List<Room> rooms = realm.allObjects(Room.class);
        String [] roomNumbers = new String[rooms.size()];
        for(int i =0 ; i< roomNumbers.length ; i++)
        {
            roomNumbers[i]="Room Nummber is : "+rooms.get(i).getRoomNumber();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1,roomNumbers);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShowAllActivity.this , RoomDetailsActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });


    }
}
