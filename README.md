## SignalStrengths
SignalStrengths is a library and sample application with the purpose of getting an accurate signal strength on phones.
For testing and experimentation purposes, a sample app code can be downloaded [here](https://github.com/applibgroup/Signal-strengths).

## Source
This library has been inspired by (https://github.com/fennifith/SignalStrengths) version 1.0, released on October 19, 2018.

## Usage

### Setup

The Gradle dependency is available through jCenter, which is used by default in Deveco Studio. To add the module to your project, copy this line into the dependencies section of your build.gradle file.
``` gradle
compile 'com.example.signalstrength'
```

### Listening for Signal Changes

To get your app to listen for a signal change, use RadioStateObserver.
RadioStateObserver Monitors state updates of a device, including updates of the network state, signal strength, and cell information.
You can use RadioInfoManager#addObserver to add the RadioStateObserver with a specific observer mask.
The corresponding method is invoked when the state updates.
You need to override the method to receive the state information. Access to certain information is permission-protected.
You must declare the appropriate permissions in the profile of the application.
You can use RadioInfoManager#removeObserver to delete the RadioStateObserver. The observer must be the same as that added.
Refer RadioStateObserver  API detaids for all information.

### Getting a Signal Value

To get signal Strength values for the network to which device is attached use SignalValues methods, 
Initilize SignalValues class by passing context, further use getAllSignalValues to get Signal Strength for required SubID
This will internally use RadioInfoManager instance and get list of all the signal the SIM card can latch to.
For example, if the device camps on both the CDMA and LTE networks, CdmaSignalInformation and LteSignalInformation instances are returned.
If an empty list is returned, there is no signal.

#### Using a Specific Method

This allows you to specify exactly which method you want to obtain a value from.

``` java
SignalStrength sValues = new SignalStrength(context)
int signalLevel = sValues.getNrsignallevel(subId);
int nrRSRP = sValues.getNrrsrp(subId);
```
## License
```
Copyright 2021 Applibgroup

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

See LICENSE.md
```
