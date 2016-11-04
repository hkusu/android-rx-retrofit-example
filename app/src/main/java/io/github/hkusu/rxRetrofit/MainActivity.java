package io.github.hkusu.rxRetrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.github.hkusu.rxRetrofit.di.AppComponent;
import io.github.hkusu.rxRetrofit.model.entity.QiitaItem;
import io.github.hkusu.rxRetrofit.model.repository.QiitaItemRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    private QiitaItemRepository qiitaItemRepository;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Qiitaアイテムリポジトリのインスタンス参照を取得
        AppComponent appComponent = ((RxRetrofitApplication) getApplication()).getAppComponent();
        qiitaItemRepository = appComponent.qiitaItemRepository();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // CompositeSubscription でまとめて購読を管理
        compositeSubscription.add(
                // Qiitaの新着アイテムを取得
                qiitaItemRepository.getNewPostItems()
                        .subscribeOn(Schedulers.io()) // バックグランドで実行
                        .observeOn(AndroidSchedulers.mainThread()) // UIスレッドで購読
                        .subscribe(aQiitaItemList -> {
                            // ログにタイトルを出力
                            for (QiitaItem qiitaItem: aQiitaItemList) {
                                Log.d("QiitaItem:", qiitaItem.title);
                            }
                        })
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 購読解除
        compositeSubscription.clear();
    }
}
