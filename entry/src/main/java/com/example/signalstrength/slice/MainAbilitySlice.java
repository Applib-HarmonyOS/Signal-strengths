/* Copyright (C) 2021 Applib Group, All Rights Reserved*/

package com.example.signalstrength.slice;
import com.example.signalstrength.ResourceTable;
import com.example.signalstrength.SignalStrengths;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;
import ohos.app.Context;
import ohos.telephony.*;

import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private Text tvnrrsrp;
    private Text tvnrrsrq;
    private Text tvnrsinr;
    private Text tvnrsignallevel;
    private Text tvltersrp;
    private Text tvltersrq;
    private Text tvlterssnr;
    private Text tvltesignallevel;
    private Text tvwcdmarscp;
    private Text tvwcdmaecno;
    private Text tvwcdmasignallevel;
    private Text tvgsmrssi;
    private Text tvgsmsignallevel;
    private Text tvCdmaRssi;
    private Text tvCdmaEcio;
    private Text tvEvdoRssi;
    private Text tvEvdoSnr;
    private Text tvCdmaSignalLevel;
    private Text tvTdscdmaRscp;
    private Text tvTdscdmaSignalLevel;
    private SignalStrengths sValues;
    private int mask = RadioStateObserver.OBSERVE_MASK_SIGNAL_INFO | RadioStateObserver.OBSERVE_MASK_NETWORK_STATE;
    private LocalNetworkStateObserver radioStateObserver;
    private RadioInfoManager radioInfo;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Context context = getApplicationContext();
        //Here passing DEFAULT_SLOT_ID for testing purpose
        radioStateObserver = new LocalNetworkStateObserver(TelephonyConstants.DEFAULT_SLOT_ID);
        radioInfo = RadioInfoManager.getInstance(context);
        sValues = new SignalStrengths(context);
        tvnrrsrp = (Text) findComponentById(ResourceTable.Id_nrrsrp);
        tvnrrsrq = (Text) findComponentById(ResourceTable.Id_nrrsrq);
        tvnrsinr = (Text) findComponentById(ResourceTable.Id_nrsinr);
        tvnrsignallevel = (Text) findComponentById(ResourceTable.Id_nrsignallevel);
        tvltersrp = (Text) findComponentById(ResourceTable.Id_ltersrp);
        tvltersrq = (Text) findComponentById(ResourceTable.Id_ltersrq);
        tvlterssnr = (Text) findComponentById(ResourceTable.Id_lterssnr);
        tvltesignallevel = (Text) findComponentById(ResourceTable.Id_ltesignallevel);
        tvwcdmarscp = (Text) findComponentById(ResourceTable.Id_wcdmarscp);
        tvwcdmaecno = (Text) findComponentById(ResourceTable.Id_wcdmaecno);
        tvwcdmasignallevel = (Text) findComponentById(ResourceTable.Id_wcdmasignallevel);
        tvgsmrssi = (Text) findComponentById(ResourceTable.Id_gsmrssi);
        tvgsmsignallevel = (Text) findComponentById(ResourceTable.Id_gsmsignallevel);
        tvCdmaRssi = (Text) findComponentById(ResourceTable.Id_cdmaRssi);
        tvCdmaEcio = (Text) findComponentById(ResourceTable.Id_cdmaEcio);
        tvEvdoRssi = (Text) findComponentById(ResourceTable.Id_evdoRssi);
        tvEvdoSnr = (Text) findComponentById(ResourceTable.Id_evdoSnr);
        tvCdmaSignalLevel = (Text) findComponentById(ResourceTable.Id_cdmaSignalLevel);
        tvTdscdmaRscp = (Text) findComponentById(ResourceTable.Id_tdscdmaRscp);
        tvTdscdmaSignalLevel = (Text) findComponentById(ResourceTable.Id_tdscdmaSignalLevel);
    }

    @Override
    public void onActive() {
        super.onActive();
        updateValues(TelephonyConstants.DEFAULT_SLOT_ID);
        radioInfo.addObserver(radioStateObserver, mask);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        radioInfo.removeObserver(radioStateObserver);
    }

    /**
     * Method to update UI
     *
     * @param subId Sub id  for which details to be obtained
     */
    //Here passing DEFAULT_SLOT_ID for testing purpose
    private void updateValues(int subId) {
        sValues.getAllSignalValues(subId);
        tvnrrsrp.setText("RSRP= " + sValues.getNrrsrp(subId));
        tvnrrsrq.setText("RSRQ= " + sValues.getNrrsrq(subId));
        tvnrsinr.setText("SINR= " + sValues.getNrsinr(subId));
        tvnrsignallevel.setText("Nr Signal Level=" + sValues.getNrsignallevel(subId));
        tvltersrp.setText("RSRP= " + sValues.getLtersrp(subId));
        tvltersrq.setText("RSRQ= " + sValues.getLtersrq(subId));
        tvlterssnr.setText("RSSNR= " + sValues.getLterssnr(subId));
        tvltesignallevel.setText("LTE Signal Level=" + sValues.getLtesignallevel(subId));
        tvwcdmarscp.setText("RSCP= " + sValues.getWcdmarscp(subId));
        tvwcdmaecno.setText("ECNO= " + sValues.getWcdmaecno(subId));
        tvwcdmasignallevel.setText("Wcdma Signal Level=" + sValues.getWcdmasignallevel(subId));
        tvgsmrssi.setText("RSSI= " + sValues.getGsmrssi(subId));
        tvgsmsignallevel.setText("GSM Signal Level=" + sValues.getGsmsignallevel(subId));
        tvCdmaRssi.setText("RSSI= " + sValues.getCdmaRssi(subId));
        tvCdmaEcio.setText("ECIO= " + sValues.getCdmaEcio(subId));
        tvEvdoRssi.setText("EvdoRssi= " + sValues.getevdoRssi(subId));
        tvEvdoSnr.setText("EvdoSnr= " + sValues.getevdoSnr(subId));
        tvCdmaSignalLevel.setText("CDMA Signal Level=" + sValues.getCdmaSignalLevel(subId));
        tvTdscdmaRscp.setText("RSCP= " + sValues.getTdscdmaRscp(subId));
        tvTdscdmaSignalLevel.setText("TDCDMA Signal Level=" + sValues.getTdscdmaSignalLevel(subId));
    }

    private class LocalNetworkStateObserver extends RadioStateObserver {
        private final int lSlotId;

        LocalNetworkStateObserver(int slotId) {
            super(slotId);
            lSlotId = slotId;
        }

        @Override
        public void onSignalInfoUpdated(List<SignalInformation> signalInfos) {
            super.onSignalInfoUpdated(signalInfos);
            updateValues(lSlotId);
        }

        @Override
        public void onNetworkStateUpdated(NetworkState networkState) {
            super.onNetworkStateUpdated(networkState);
            updateValues(lSlotId);
        }
    }
}
