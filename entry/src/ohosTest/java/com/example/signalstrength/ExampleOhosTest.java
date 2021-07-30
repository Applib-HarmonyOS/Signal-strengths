package com.example.signalstrength;

import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.app.Context;
import ohos.telephony.TelephonyConstants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ExampleOhosTest {
    private final Context context =
            AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
    private final SignalStrengths signal = new SignalStrengths(context);

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.example.signalstrength", actualBundleName);
    }
    @Test
    public void testGetAllSignalValues() {
        signal.getAllSignalValues(TelephonyConstants.DEFAULT_SLOT_ID);
        assertEquals("getNrrsrp", 0, signal.getNrrsrp(TelephonyConstants.DEFAULT_SLOT_ID));
        assertEquals("getNrrsrq",0, signal.getNrrsrq(TelephonyConstants.DEFAULT_SLOT_ID));
        assertEquals("getNrsinr",0, signal.getNrsinr(TelephonyConstants.DEFAULT_SLOT_ID));
        assertEquals("getNrsignallevel",0, signal.getNrsignallevel(TelephonyConstants.DEFAULT_SLOT_ID));
        assertEquals("getLtersrp", -44, signal.getLtersrp(0));
        assertEquals("getLtersrq", -3, signal.getLtersrq(0));
        assertEquals("getLterssnr", 32, signal.getLterssnr(0));
        assertEquals("getLtesignallevel", 5, signal.getLtesignallevel(0));
        assertEquals("getWcdmarscp", 0, signal.getWcdmarscp(0));
        assertEquals("getWcdmaecno", 0, signal.getWcdmaecno(0));
        assertEquals("getWcdmasignallevel", 0, signal.getWcdmasignallevel(0));
        assertEquals("getGsmrssi", 0, signal.getGsmrssi(0));
        assertEquals("getGsmsignallevel", 0, signal.getGsmsignallevel(0));
        assertEquals("getCdmaRssi", 0, signal.getCdmaRssi(0));
        assertEquals("getCdmaEcio", 0, signal.getCdmaEcio(0));
        assertEquals("getevdoRssi", 0, signal.getevdoRssi(0));
        assertEquals("getevdoSnr", 0, signal.getevdoSnr(0));
        assertEquals("getCdmaSignalLevel", 0, signal.getCdmaSignalLevel(0));
        assertEquals("getTdscdmaRscp", 0, signal.getTdscdmaRscp(0));
        assertEquals("getTdscdmaSignalLevel", 0, signal.getTdscdmaSignalLevel(0));
    }

}