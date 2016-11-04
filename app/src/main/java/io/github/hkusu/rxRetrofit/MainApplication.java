package io.github.hkusu.rxRetrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {
    private QiitaApiService qiitaApiService = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public QiitaApiService getQiitaApiService() {
        if (qiitaApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://qiita.com/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            qiitaApiService = retrofit.create(QiitaApiService.class);
        }
        return  qiitaApiService;
    }
}
