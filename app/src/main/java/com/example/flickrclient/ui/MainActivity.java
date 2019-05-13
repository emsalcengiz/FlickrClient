package com.example.flickrclient.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.flickrclient.R;
import com.example.flickrclient.adapter.PhotoAdapter;
import com.example.flickrclient.model.Flicker;
import com.example.flickrclient.model.FlickerPhotos;
import com.example.flickrclient.model.GetDataService;
import com.example.flickrclient.model.Photo;
import com.example.flickrclient.model.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PhotoAdapter photoAdapter;
    RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //yaşam döngüsünde activity baslatıldıgında ilk çalışacak method (onCreate)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//MainActivity sınıfımızın hangi View'i kullanacağını set ediyoruz

        getAllPhotos();

    }

    private void getAllPhotos()
    {
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Flicker> call = service.getRecentPhotos("05a77164db91225833ae8ddc4b9c8076",15);
        call.enqueue(new Callback<Flicker>() {
            @Override
            public void onResponse(Call<Flicker> call, Response<Flicker> response) {
                progressDoalog.dismiss();
                Flicker flicker = response.body();
                FlickerPhotos flickerPhotos = flicker.getPhotos();
                List<Photo> photos = flickerPhotos.getPhoto();
                generateDataList(photos);
            }

            @Override
            public void onFailure(Call<Flicker> call, Throwable t) {
                progressDoalog.dismiss();
//                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Photo> photos) {
        recyclerView = findViewById(R.id.recycler_view); //id si recycler_view olan recyclerview ı getir
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2 ));
        recyclerView.setHasFixedSize(true);
        photoAdapter = new PhotoAdapter(photos,this);
        recyclerView.setAdapter(photoAdapter);
    }

}
