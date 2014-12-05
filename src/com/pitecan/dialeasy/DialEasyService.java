package com.pitecan.dialeasy;
import java.util.Random;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import android.util.Log;
     
//ホームウィジェットを制御するサービス
public class DialEasyService extends Service {
    private static final String ACTION_CALL =
        "com.pitecan.dialeasy.ACTION_CALL";
    
    //サービス開始時に呼ばれる
    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {
        super.onStartCommand(intent,flags,startId);
        
	Log.v("DialEasy", "OnStart");

        //リモートビューの生成
        RemoteViews view=new RemoteViews(getPackageName(),R.layout.dialeasy);

        //ペンディングインテントの設定
        Intent newintent=new Intent();
        newintent.setAction(ACTION_CALL);
        PendingIntent pending=PendingIntent.getService(this,0,newintent,0);
        view.setOnClickPendingIntent(R.id.imagebutton,pending);

	Log.v("DialEasy", "SetIntent");
        
        //振るボタンがクリックされた時の処理
        if (ACTION_CALL.equals(intent.getAction())) {
            btnClicked(view);
        }
        
        //ホームスクリーンウィジェットの画面更新
        AppWidgetManager manager=AppWidgetManager.getInstance(this);
        ComponentName widget=new ComponentName(
            "com.pitecan.dialeasy",
            "com.pitecan.dialeasy.DialEasy");
        manager.updateAppWidget(widget,view);
        return START_STICKY;
    }
     
    //バインダを返す
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
     
    //振るボタンがクリックされた時の処理
    public void btnClicked(RemoteViews view){
	Log.v("DialEasy", "Button Clicked");
    }
    
    //乱数の取得
    private static Random rand=new Random();
    public static int rand(int num) {
        return (rand.nextInt()>>>1)%num;
    }    
}
