package io.github.hkusu.rxRetrofit;

import android.app.Application;

import io.github.hkusu.rxRetrofit.di.AppComponent;
import io.github.hkusu.rxRetrofit.di.AppModule;
import io.github.hkusu.rxRetrofit.di.DaggerAppComponent;

public class RxRetrofitApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Dagger
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
