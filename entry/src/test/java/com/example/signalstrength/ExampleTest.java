package com.example.signalstrength;

import com.example.signalstrength.slice.MainAbilitySlice;
import ohos.app.Context;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
    /**
     * Test SignalStrength methods
     */
    @Test
    public void checkNetworkValues() {
        SignalStrengths sn = new SignalStrengths(MainAbilitySlice.ContextProvider.getTestContext());
        assertEquals("getNrrsrp", 0, sn.getNrrsrp(0));
        assertEquals("getNrrsrq", 0, sn.getNrrsrq(0));
        assertEquals("getNrsinr", 0, sn.getNrsinr(0));
        assertEquals("getNrsignallevel", 0, sn.getNrsignallevel(0));
        assertEquals("getLtersrp", 0, sn.getLtersrp(0));
        assertEquals("getLtersrq", 0, sn.getLtersrq(0));
        assertEquals("getLterssnr", 0, sn.getLterssnr(0));
        assertEquals("getLtesignallevel", 0, sn.getLtesignallevel(0));
        assertEquals("getWcdmarscp", 0, sn.getWcdmarscp(0));
        assertEquals("getWcdmaecno", 0, sn.getWcdmaecno(0));
        assertEquals("getWcdmasignallevel", 0, sn.getWcdmasignallevel(0));
        assertEquals("getGsmrssi", 0, sn.getGsmrssi(0));
        assertEquals("getGsmsignallevel", 0, sn.getGsmsignallevel(0));
        assertEquals("getCdmaRssi", 0, sn.getCdmaRssi(0));
        assertEquals("getCdmaEcio", 0, sn.getCdmaEcio(0));
        assertEquals("getevdoRssi", 0, sn.getevdoRssi(0));
        assertEquals("getevdoSnr", 0, sn.getevdoSnr(0));
        assertEquals("getCdmaSignalLevel", 0, sn.getCdmaSignalLevel(0));
        assertEquals("getTdscdmaRscp", 0, sn.getTdscdmaRscp(0));
        assertEquals("getTdscdmaSignalLevel", 0, sn.getTdscdmaSignalLevel(0));
        }

    /**
     * Test SignalStrength methods
     */
    @Test
    public void checkNetworkValuesForSubId() {
        SignalStrengths sn = new SignalStrengths(MainAbilitySlice.ContextProvider.getTestContext());
        assertEquals("getNrrsrp", 0, sn.getNrrsrp(1));
        assertEquals("getNrrsrq", 0, sn.getNrrsrq(1));
        assertEquals("getNrsinr", 0, sn.getNrsinr(1));
        assertEquals("getNrsignallevel", 0, sn.getNrsignallevel(1));
        assertEquals("getLtersrp", 0, sn.getLtersrp(1));
        assertEquals("getLtersrq", 0, sn.getLtersrq(1));
        assertEquals("getLterssnr", 0, sn.getLterssnr(1));
        assertEquals("getLtesignallevel", 0, sn.getLtesignallevel(1));
        assertEquals("getWcdmarscp", 0, sn.getWcdmarscp(1));
        assertEquals("getWcdmaecno", 0, sn.getWcdmaecno(1));
        assertEquals("getWcdmasignallevel", 0, sn.getWcdmasignallevel(1));
        assertEquals("getGsmrssi", 0, sn.getGsmrssi(1));
        assertEquals("getGsmsignallevel", 0, sn.getGsmsignallevel(1));
        assertEquals("getCdmaRssi", 0, sn.getCdmaRssi(1));
        assertEquals("getCdmaEcio", 0, sn.getCdmaEcio(1));
        assertEquals("getevdoRssi", 0, sn.getevdoRssi(1));
        assertEquals("getevdoSnr", 0, sn.getevdoSnr(1));
        assertEquals("getCdmaSignalLevel", 0, sn.getCdmaSignalLevel(1));
        assertEquals("getTdscdmaRscp", 0, sn.getTdscdmaRscp(1));
        assertEquals("getTdscdmaSignalLevel", 0, sn.getTdscdmaSignalLevel(1));
    }
}
