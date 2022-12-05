package com.example.buoi6_19dthc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.libs.InterFaces.Methods;
import com.example.libs.Model.RoomListResponse;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<RoomListResponse> call = methods.getAllData();
        call.enqueue(new Callback<RoomListResponse>() {
            @Override
            public void onResponse(Call<RoomListResponse> call, Response<RoomListResponse> response) {
                List<String> roomList = new ArrayList<String>();
                for(int i = 0; i< response.body().data.size();i++){
                    Log.v("log:", response.body().data.get(i).getName());
                    roomList.add(response.body().data.get(i).getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,roomList);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RoomListResponse> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

    public void ClickNew(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityDetail.class);
        startActivity(intent);
    }
}