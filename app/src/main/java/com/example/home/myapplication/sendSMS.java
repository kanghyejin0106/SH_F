package com.example.home.myapplication;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

class Messenger {
    private Context mContext;

    public Messenger(Context mContext) {
        this.mContext = mContext;
    }  // Messenger 클래스의 생성자, 현재 어플의 정보를 얻어옴


    public void sendMessageTo(String phoneNum) {
        SmsManager smsManager = SmsManager.getDefault(); // SmsManager 객체 생성
        String message = createNumCode();

        smsManager.sendTextMessage(phoneNum, null, message, null, null);
        // (수신자 번호, 서비스센터번호(기본값:null), 메시지 내용, sentIntent, deliveryIntent)
        // sentIntent : SMS 전송 성공, 실패 등의 이벤트를 알리기 위한 PendingIntent
        // deliveryIntent : 답장이 올 경우 SMS수신 이벤트를 알리기 위한 PendingIntent
        // PendingIntent 객체는 메시지를 전송한 후 다른 액티비티를 보여주기 위해 사용됨

        Toast.makeText(mContext, "The authentication number was sent.", Toast.LENGTH_SHORT).show();
    }

    private String createNumCode(){
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String newCode = new String();

        for (int x = 0; x < 4; x++) {
            int random = (int) (Math.random() * str.length);
            newCode += str[random];
        }

        return newCode;
    }


}

/*
public class sendSMS {
    private void sendSMS(String phoneNumber, String message) {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);

        // -- when the SMS has been sent --
        registerReciver(new BroadcastReceiver() {
            public void onRecive(Context arg0, Intent arg1) {
                switch(getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "알림 문자 메시지가 전송되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        } , new IntentFilter(SENT));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }

} */