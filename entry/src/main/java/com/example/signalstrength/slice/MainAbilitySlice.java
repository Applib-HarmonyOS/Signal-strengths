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

    package com.example.signalstrength.slice;

    import com.example.signalstrength.ResourceTable;
    import james.signalstrengthslib.SignalMethod;
    import james.signalstrengthslib.SignalStrengths;
    import james.signalstrengthslib.SignalUtils;
    import ohos.aafwk.ability.AbilitySlice;
    import ohos.aafwk.content.Intent;
    import ohos.agp.components.TableLayout;
    import ohos.agp.components.Text;
    import ohos.agp.utils.Color;
    import ohos.app.Context;
    import ohos.telephony.*;

    import java.util.List;

    public class MainAbilitySlice extends AbilitySlice {
        private int mask = RadioStateObserver.OBSERVE_MASK_SIGNAL_INFO | RadioStateObserver.OBSERVE_MASK_NETWORK_STATE;
        private LocalNetworkStateObserver radioStateObserver;
        private RadioInfoManager radioInfo;
        private TableLayout tableLayout;
        private Text firstValid;
        private Text average;
        private Context context;
        @Override
        public void onStart(Intent intent) {
            context = getApplicationContext();
            super.onStart(intent);
            super.setUIContent(ResourceTable.Layout_ability_main);
            //Here passing DEFAULT_SLOT_ID for testing purpose
            radioStateObserver = new LocalNetworkStateObserver(TelephonyConstants.DEFAULT_SLOT_ID);
            radioInfo = RadioInfoManager.getInstance(context);
            tableLayout = (TableLayout) findComponentById(ResourceTable.Id_gridLayout);
            firstValid = (Text) findComponentById(ResourceTable.Id_firstValid);
            average = (Text) findComponentById(ResourceTable.Id_average);
        }

        @Override
        public void onActive() {
            super.onActive();
            updateValues();
            radioInfo.addObserver(radioStateObserver, mask);
        }

        @Override
        protected void onInactive() {
            super.onInactive();
            radioInfo.removeObserver(radioStateObserver);
        }

        private class LocalNetworkStateObserver extends RadioStateObserver {
            LocalNetworkStateObserver(int slotId) {
                super(slotId);
            }

            @Override
            public void onSignalInfoUpdated(List<SignalInformation> signalInfos) {
                super.onSignalInfoUpdated(signalInfos);
            }

            @Override
            public void onNetworkStateUpdated(NetworkState networkState) {
                super.onNetworkStateUpdated(networkState);
            }
        }
        private void updateValues(){
        for (SignalMethod method : SignalStrengths.getMethods()) {
            Text nameView = new Text(this);
            nameView.setPadding(10, 10, 10, 10);
            nameView.setTextSize(40);
            nameView.setText(method.getName());

            Text valueView = new Text(this);
            valueView.setPadding(10, 10, 10, 10);
            valueView.setTextSize(40);
            valueView.setTag(method.getName());

            tableLayout.addComponent(nameView);
            tableLayout.addComponent(valueView);
            firstValid.setText(String.valueOf(SignalStrengths.getFirstValid(TelephonyConstants.DEFAULT_SLOT_ID, context)));
            average.setText(String.valueOf(SignalStrengths.getAverage(TelephonyConstants.DEFAULT_SLOT_ID, context)));
            double level = 0;
            level = method.getLevel(TelephonyConstants.DEFAULT_SLOT_ID, context);
            valueView.setText(String.valueOf(level));
        }
    }

    }
