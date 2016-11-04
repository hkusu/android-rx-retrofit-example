package io.github.hkusu.rxRetrofit.di;

import javax.inject.Singleton;

import dagger.Component;
import io.github.hkusu.rxRetrofit.model.repository.QiitaItemRepository;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    QiitaItemRepository qiitaItemRepository();
}
