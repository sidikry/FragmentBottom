package com.timkontrakan.coronavirusinfo.api;

import com.airbnb.lottie.L;
import com.timkontrakan.coronavirusinfo.model.Corona;
import com.timkontrakan.coronavirusinfo.model.CoronaGlobal;
import com.timkontrakan.coronavirusinfo.model.ProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {

    @GET("indonesia")
    Call<List<Corona>> getData();

    @GET("indonesia/provinsi")
    Call<List<ProvinsiResponse>> getProvinsi();

    @GET("positif")
    Call<List<CoronaGlobal>> getGlobal();

    @GET("sembuh")
    Call<List<CoronaGlobal>> getSembuh();

    @GET("meninggal")
    Call<List<CoronaGlobal>> getMeninggal();
}
