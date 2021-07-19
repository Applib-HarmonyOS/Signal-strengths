/* Copyright (C) 2021 Applib Group, All Rights Reserved*/

package com.example.signalstrength;

import ohos.app.Context;
import ohos.telephony.RadioInfoManager;
import ohos.telephony.SignalInformation;
import ohos.telephony.TelephonyConstants;
import ohos.utils.Parcel;

import java.util.List;

public class SignalStrengths {
    private int mnrrsrp[] = new int[2],
            mnrrsrq[] = new int[2],
            mnrsinr[] = new int[2],
            mnrsignallevel[] = new int[2],
            mltersrp[] = new int[2],
            mltersrq[] = new int[2],
            mlterssnr[] = new int[2],
            mltesignallevel[] = new int[2],
            mwcdmarscp[] = new int[2],
            mwcdmaecno[] = new int[2],
            mwcdmasignallevel[] = new int[2],
            mgsmrssi[] = new int[2],
            mgsmsignallevel[] = new int[2],
            mCdmaRssi[] = new int[2],
            mCdmaEcio[] = new int[2],
            mEvdoRssi[] = new int[2],
            mEvdoSnr[] = new int[2],
            mCdmaSignalLevel[] = new int[2],
            mTdscdmaRscp[] = new int[2],
            mTdscdmaSignalLevel[] = new int[2];
    private Context mContext;

    /**
     * Constructor to initilize conext
     *
     * @param c context to be passed from calling ability
     */
    public SignalStrengths(Context c) {
        mContext = c;
    }

    /**
     * This method should be called first to get all Signal details from framework and put it locally
     *
     * @param subId subId for which details are required
     */
    public void getAllSignalValues(int subId) {
        Parcel p = Parcel.create();
        if (mContext != null && p != null) {
            //Obtains the list of signal strength information of the registered network corresponding to a specified SIM card.
            //If the specified SIM card camps on one or more networks, the signal strength of these networks is reported
            //To get the signal level of the signal to which device is connected
            RadioInfoManager radioInfo = RadioInfoManager.getInstance(mContext);
            if (null != radioInfo) {
                setParams(radioInfo,subId,p);
                p.reclaim();
            }
        }
    }
    /**
     * Method to setParams
     */
    void setParams(RadioInfoManager radioInfo, int subId, Parcel p){
        //Obtains the list of signal strength information of the registered network corresponding to a specified SIM card.
        List<SignalInformation> snList = radioInfo.getSignalInfoList(subId);
        for (int in = 0; in < snList.size(); in++) {
            snList.get(in).marshalling(p);
            //To get the signal level of the signal to which device is connected
            //First param in parcel is always network type so read it here before retriving all other values
            int networkType = p.readInt();
            switch (networkType) {
                case TelephonyConstants.NETWORK_TYPE_NR:
                    mnrrsrp[subId] = p.readInt();
                    mnrrsrq[subId] = p.readInt();
                    mnrsinr[subId] = p.readInt();
                    mnrsignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_LTE:
                    mltersrp[subId] = p.readInt();
                    mltersrq[subId] = p.readInt();
                    mlterssnr[subId] = p.readInt();
                    mltesignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_WCDMA:
                    mwcdmarscp[subId] = p.readInt();
                    mwcdmaecno[subId] = p.readInt();
                    mwcdmasignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_GSM:
                    mgsmrssi[subId] = p.readInt();
                    mgsmsignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_CDMA:
                    mCdmaRssi[subId] = p.readInt();
                    mCdmaEcio[subId] = p.readInt();
                    mEvdoRssi[subId] = p.readInt();
                    mEvdoSnr[subId] = p.readInt();
                    mCdmaSignalLevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_TDSCDMA:
                    mTdscdmaRscp[subId] = p.readInt();
                    mTdscdmaSignalLevel[subId] = snList.get(in).getSignalLevel();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Method to get NR RSRP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getNrrsrp(int subId) { return mnrrsrp[subId]; }

    /**
     * Method to get NR RSRQ values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getNrrsrq(int subId) { return mnrrsrq[subId]; }

    /**
     * Method to get NR SINR values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getNrsinr(int subId) { return mnrsinr[subId]; }

    /**
     * Method to get NR Signal Lebvel values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getNrsignallevel(int subId) { return mnrsignallevel[subId]; }

    /**
     * Method to get LTE RSRP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getLtersrp(int subId) { return mltersrp[subId]; }

    /**
     * Method to get LTE RSRQ values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getLtersrq(int subId) { return mltersrq[subId]; }

    /**
     * Method to get LTE RSSNR values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getLterssnr(int subId) { return mlterssnr[subId]; }

    /**
     * Method to get LTE Signal Level values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getLtesignallevel(int subId) { return mltesignallevel[subId]; }

    /**
     * Method to get WCDMA RSCP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getWcdmarscp(int subId) {
        return mwcdmarscp[subId];
    }

    /**
     * Method to get WCDMA ECNO values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getWcdmaecno(int subId) {
        return mwcdmaecno[subId];
    }

    /**
     * Method to get WCDMA Signal Level values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getWcdmasignallevel(int subId) {
        return mwcdmasignallevel[subId];
    }

    /**
     * Method to get GSM RSSI values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getGsmrssi(int subId) {
        return mgsmrssi[subId];
    }

    /**
     * Method to get GSM Signal Level values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getGsmsignallevel(int subId) {
        return mgsmsignallevel[subId];
    }

    /**
     * Method to get CDMA RSSI values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getCdmaRssi(int subId) {
        return mCdmaRssi[subId];
    }

    /**
     * Method to get CDMA ECIO values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getCdmaEcio(int subId) {
        return mCdmaEcio[subId];
    }

    /**
     * Method to get NR RSRP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getevdoRssi(int subId) {
        return mEvdoRssi[subId];
    }

    /**
     * Method to get NR RSRP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getevdoSnr(int subId) {
        return mEvdoSnr[subId];
    }

    /**
     * Method to get CDMA Signal Level RSRP values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getCdmaSignalLevel(int subId) {
        return mCdmaSignalLevel[subId];
    }

    /**
     * Method to get TDCDMA RSCP values for required Sub ID
     *
     * @param subId subscription id either 0 or 1
     */
    public int getTdscdmaRscp(int subId) {
        return mTdscdmaRscp[subId];
    }

    /**
     * Method to get TDCDMA Signal Level values for required Sub ID
     * Range 0-5 : 5 Excellent , 0 : No Signal
     * @param subId subscription id either 0 or 1
     */
    public int getTdscdmaSignalLevel(int subId) {
        return mTdscdmaSignalLevel[subId];
    }

}
