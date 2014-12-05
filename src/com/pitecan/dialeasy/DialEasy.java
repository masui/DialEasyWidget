package com.pitecan.dialeasy;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

//ホームスクリーンウィジェットを提供するブロードキャストレシーバー
public class DialEasy extends AppWidgetProvider {
    //ホームスクリーンウィジェット更新時に呼ばれる
    @Override
    public void onUpdate(Context context,
        AppWidgetManager appWidgetManager,int[] appWidgetIds) {

        //ホームスクリーンウィジェットのイベント処理を担当するサービスの起動
        Intent intent=new Intent(context,DialEasyService.class);
        context.startService(intent);
    }
}
