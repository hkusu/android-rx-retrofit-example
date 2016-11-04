package io.github.hkusu.rxRetrofit.service.api;

import java.util.List;

import io.github.hkusu.rxRetrofit.model.entity.QiitaItem;
import retrofit2.http.GET;
import rx.Observable;

public interface QiitaApiService {
    @GET("items?per_page=10&page=1")
    Observable<List<QiitaItem>> items();
}
