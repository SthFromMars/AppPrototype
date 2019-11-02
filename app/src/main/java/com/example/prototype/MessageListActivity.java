package com.example.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_grid_layout);

        viewMessages();
    }
    void viewMessages(){
        ListView messageListView = findViewById(R.id.listView);
        ArrayList<Message> mesages = OrganizerManager.getInstance().signedIn.getMessageList();
        Message tmp = new Message("Naujas uzsakymas", "Jus gavote nauja uzsakyma","administratorius", "me");
        OrganizerManager.getInstance().signedIn.addMessage(tmp);
        MessageListAdapter adapter = new MessageListAdapter(this, R.layout.adapter_message_layout, mesages, this);
        messageListView.setAdapter(adapter);
    }
}
