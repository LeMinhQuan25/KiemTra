package com.example.buoi6_19dthc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libs.InterFaces.Methods;
import com.example.libs.Model.BaseResponse;
import com.example.libs.Model.Room;
import com.example.libs.Model.RoomListResponse;
import com.example.libs.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityDetail extends AppCompatActivity {
    EditText txtName, txtCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        txtName = findViewById(R.id.txtName);
        txtCode = findViewById(R.id.txtCode);
    }

    public void Save(View view) {
        Room r = new Room();
        r.setName(txtName.getText().toString());
        r.setCode( txtCode.getText().toString());
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<BaseResponse> call = methods.insertRoom(r);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                finish();
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(MainActivityDetail.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}