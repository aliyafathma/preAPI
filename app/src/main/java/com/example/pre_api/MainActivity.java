package com.example.pre_api;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.pre_api.adapter.ItemAdapter;
import com.example.pre_api.databinding.ActivityMainBinding;
import com.example.pre_api.model.User;
import com.example.pre_api.model.UserResponse;
import com.example.pre_api.model.UserkuResponse;
import com.example.pre_api.network.ApiClient;
import com.example.pre_api.network.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ItemAdapter adapter;
    ActivityMainBinding binding;

    private final String TAG = MainActivity.class.getSimpleName();

    private void initList() {
        adapter = new ItemAdapter(new ArrayList<User>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvItem.setLayoutManager(layoutManager);
        this.binding.mainRcvItem.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initList();

        loadUserAsync(20);
    }

    private void loadUserAsync(int result) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<UserResponse> call = apiInterface.getTopRatedMovies(result);
        Call<UserResponse> call = apiInterface.getUser(result);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                showData(userResponse);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }

    private void showData(UserResponse userResponse) {
        adapter = new ItemAdapter(userResponse.getUsers());
        binding.setAdapter(adapter);
    }
}
