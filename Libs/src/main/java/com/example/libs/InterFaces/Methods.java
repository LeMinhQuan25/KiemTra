package com.example.libs.InterFaces;

import com.example.libs.Model.BaseResponse;
import com.example.libs.Model.Room;
import com.example.libs.Model.RoomListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Methods {
    @GET("api/Room/get-rooms")
    Call<RoomListResponse> getAllData();
    @POST("api/Room/insert-rooms")
    Call<BaseResponse> insertRoom(@Body Room r);
}