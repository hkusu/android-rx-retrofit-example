package io.github.hkusu.rxRetrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private QiitaApiService qiitaApiService;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // qiitaApiService = ((MainApplication) getApplication()).getQiitaApiService();
        qiitaApiService = Provider.provideQiitaApiService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Qiitaの新着アイテムを取得
        subscription = qiitaApiService.items()
                .subscribeOn(Schedulers.io()) // バックグランドで実行
                .observeOn(AndroidSchedulers.mainThread()) // UIスレッドで購読
                .subscribe(aQiitaItemList -> {
                    // ログにタイトルを出力
                    for (QiitaItem qiitaItem: aQiitaItemList) {
                        Log.d("QiitaItem:", qiitaItem.title);
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 購読解除
        subscription.unsubscribe();
    }
}
