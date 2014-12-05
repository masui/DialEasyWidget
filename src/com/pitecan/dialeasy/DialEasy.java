package com.pitecan.dialeasy;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import android.widget.RemoteViews;

import android.net.Uri;
import android.util.Log;

//ホームスクリーンウィジェットを提供するブロードキャストレシーバー
public class DialEasy extends AppWidgetProvider {
    //ホームスクリーンウィジェット更新時に呼ばれる
    @Override
    public void onUpdate(Context context,
        AppWidgetManager appWidgetManager,int[] appWidgetIds) {

        //リモートビューの生成
        RemoteViews view=new RemoteViews(context.getPackageName(),R.layout.dialeasy);

	Intent intent = new Intent(Intent.ACTION_CALL);
	intent.setData(Uri.parse("tel:"+"0467235838")); 
	PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
	view.setOnClickPendingIntent(R.id.imagebutton, pending);

        //ホームスクリーンウィジェットの画面更新
	appWidgetManager.updateAppWidget(appWidgetIds, view);
    }
}
