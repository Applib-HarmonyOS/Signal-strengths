package com.example.signalstrength;

import james.signalstrengthslib.SignalStrengths;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.app.Context;
import ohos.telephony.TelephonyConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleOhosTest {
    private final Context context =
            AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
    private int subId = TelephonyConstants.DEFAULT_SLOT_ID;
    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.example.signalstrength", actualBundleName);
    }

    @Test
    public void testGetAllSignalValues() {
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_GSM_LEVEL, subId, context));
        assertEquals("getLevel", "1", SignalStrengths.get(SignalStrengths.METHOD_GSM_DBM, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_CDMA_LEVEL, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_TD_SCDMA_LEVEL, subId, context));
        assertEquals("getLevel", "-1", SignalStrengths.get(SignalStrengths.METHOD_TD_SCDMA_DBM, subId, context));
        assertEquals("getLevel", "-1", SignalStrengths.get(SignalStrengths.METHOD_CDMA_DBM, subId, context));
        assertEquals("getLevel", "4", SignalStrengths.get(SignalStrengths.METHOD_CDMA_ECIO, subId, context));
        assertEquals("getLevel", "-1", SignalStrengths.get(SignalStrengths.METHOD_EVDO_DBM, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_EVDO_SNR, subId, context));
        assertEquals("getLevel", "5", SignalStrengths.get(SignalStrengths.METHOD_LTE_LEVEL, subId, context));
        assertEquals("getLevel", "4", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSRQ, subId, context));
        assertEquals("getLevel", "4", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSRP, subId, context));
        assertEquals("getLevel", "16.0", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSSNR, subId, context));
        assertEquals("getLevel", "-1", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_RSCP, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_ECNO, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_LEVEL, subId, context));
        assertEquals("getLevel", "4", SignalStrengths.get(SignalStrengths.METHOD_NR_RSRP, subId, context));
        assertEquals("getLevel", "4", SignalStrengths.get(SignalStrengths.METHOD_NR_RSRQ, subId, context));
        assertEquals("getLevel", "1", SignalStrengths.get(SignalStrengths.METHOD_NR_SINR, subId, context));
        assertEquals("getLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_NR_LEVEL, subId, context));
    }

}