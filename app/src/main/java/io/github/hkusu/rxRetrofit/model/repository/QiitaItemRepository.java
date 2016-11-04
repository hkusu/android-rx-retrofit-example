package io.github.hkusu.rxRetrofit.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.hkusu.rxRetrofit.model.entity.QiitaItem;
import io.github.hkusu.rxRetrofit.service.api.QiitaApiService;
import rx.Observable;

@Singleton
public class QiitaItemRepository {
    private final QiitaApiService qiitaApiService;

    @Inject
    public QiitaItemRepository(QiitaApiService qiitaApiService) {
        this.qiitaApiService = qiitaApiService;
    }

    public Observable<List<QiitaItem>> getNewPostItems() {
        return qiitaApiService.items();
    }
}
