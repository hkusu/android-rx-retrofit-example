package io.github.hkusu.rxRetrofit.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.hkusu.rxRetrofit.service.api.QiitaApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application application() {
        return application;
    }

    @Provides
    @Singleton
    public QiitaApiService qiitaApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://qiita.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(QiitaApiService.class);
    }
}
