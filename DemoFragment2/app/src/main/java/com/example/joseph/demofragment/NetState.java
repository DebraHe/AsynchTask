package com.example.joseph.demofragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

/**
 * Created by Joseph on 2017/3/17.
 */

class NetState extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if(!gprs.isConnected() && !wifi.isConnected())
        {
            AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setMessage("网络连接断开，请检查网络");
            ab.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            }).show();

        }
        else{
            AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setMessage("网络连接成功");
            ab.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub

                    dialog.dismiss();
                }
            }).show();

        }
    }
}
