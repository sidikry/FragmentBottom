package com.timkontrakan.coronavirusinfo.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.timkontrakan.coronavirusinfo.R;
import com.timkontrakan.coronavirusinfo.api.API;
import com.timkontrakan.coronavirusinfo.api.IRetrofit;
import com.timkontrakan.coronavirusinfo.api.RetrofitClient;
import com.timkontrakan.coronavirusinfo.model.Corona;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tv_positif, tv_sembuh, tv_meninggal;
    private IRetrofit iRetrofit;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tv_positif = view.findViewById(R.id.total_positif);
        tv_sembuh = view.findViewById(R.id.total_sembuh);
        tv_meninggal = view.findViewById(R.id.total_meninggal);

        getData();
        return view;
    }

    private void getData() {

        iRetrofit = RetrofitClient.getClient(API.url).create(IRetrofit.class);
        iRetrofit.getData().enqueue(new Callback<List<Corona>>() {
            @Override
            public void onResponse(Call<List<Corona>> call, Response<List<Corona>> response) {
                tv_positif.setText(response.body().get(0).getPositif() + "Orang");
                tv_meninggal.setText(response.body().get(0).getMeninggal() + "Orang");
                tv_sembuh.setText(response.body().get(0).getSembuh() + "Orang");
            }

            @Override
            public void onFailure(Call<List<Corona>> call, Throwable t) {

            }
        });
    }
}
