package com.example.android.sunshine.app.sync;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;

public class SunshineListenerService extends WearableListenerService {

    private static final String START_ACTIVITY_PATH = "/start-sunshine-watch-face";

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {

        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() != DataEvent.TYPE_CHANGED)
                continue;

            if (dataEvent.getDataItem().getUri().getPath().equals(START_ACTIVITY_PATH)) {
                SunshineSyncAdapter.syncImmediately(this, true);
            }

        }
    }
}
