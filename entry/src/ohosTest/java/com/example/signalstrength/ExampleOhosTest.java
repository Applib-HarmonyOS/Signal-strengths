/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        assertEquals("getGsmLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_GSM_LEVEL, subId, context));
        assertEquals("getGsmDbm", "1", SignalStrengths.get(SignalStrengths.METHOD_GSM_DBM, subId, context));
        assertEquals("getCdmaLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_CDMA_LEVEL, subId, context));
        assertEquals("getScdmaLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_TD_SCDMA_LEVEL, subId, context));
        assertEquals("getTdCdmaDbm", "-1", SignalStrengths.get(SignalStrengths.METHOD_TD_SCDMA_DBM, subId, context));
        assertEquals("getCdmaDbm", "-1", SignalStrengths.get(SignalStrengths.METHOD_CDMA_DBM, subId, context));
        assertEquals("getCdmaEcio", "4", SignalStrengths.get(SignalStrengths.METHOD_CDMA_ECIO, subId, context));
        assertEquals("getEvdoDbm", "-1", SignalStrengths.get(SignalStrengths.METHOD_EVDO_DBM, subId, context));
        assertEquals("getEvdoSnr", "0", SignalStrengths.get(SignalStrengths.METHOD_EVDO_SNR, subId, context));
        assertEquals("getLteLevel", "5", SignalStrengths.get(SignalStrengths.METHOD_LTE_LEVEL, subId, context));
        assertEquals("getLteRsrq", "4", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSRQ, subId, context));
        assertEquals("getLteRsrp", "4", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSRP, subId, context));
        assertEquals("getLteRssnr", "16.0", SignalStrengths.get(SignalStrengths.METHOD_LTE_RSSNR, subId, context));
        assertEquals("getWcdmaDbm", "-1", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_DBM, subId, context));
        assertEquals("getWcdmaEcno", "0", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_ECNO, subId, context));
        assertEquals("getWcdmaLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_WCDMA_LEVEL, subId, context));
        assertEquals("getNrRsrp", "4", SignalStrengths.get(SignalStrengths.METHOD_NR_RSRP, subId, context));
        assertEquals("getNrRsrq", "4", SignalStrengths.get(SignalStrengths.METHOD_NR_RSRQ, subId, context));
        assertEquals("getNrSinr", "1", SignalStrengths.get(SignalStrengths.METHOD_NR_SINR, subId, context));
        assertEquals("getNrLevel", "0", SignalStrengths.get(SignalStrengths.METHOD_NR_LEVEL, subId, context));
    }

}