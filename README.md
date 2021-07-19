SignalStrength is a simple library to get Signal Strength information of the current network to which device is latched.

Usage: 

Getting a Signal Value
To get signal Strength values for the network to which device is attached use SignalValues methods, 
Initilize SignalValues class by passing context, further use getAllSignalValues to get Signal Strength for required SubID
This will internally use RadioInfoManager instance and get list of all the signal the SIM card can latch to.
For example, if the device camps on both the CDMA and LTE networks, CdmaSignalInformation and LteSignalInformation instances are returned.
If an empty list is returned, there is no signal.

Listening for Signal Changes
To get your app to listen for a signal change, use RadioStateObserver.
RadioStateObserver Monitors state updates of a device, including updates of the network state, signal strength, and cell information.
You can use RadioInfoManager#addObserver to add the RadioStateObserver with a specific observer mask.
The corresponding method is invoked when the state updates.
You need to override the method to receive the state information. Access to certain information is permission-protected.
You must declare the appropriate permissions in the profile of the application.
You can use RadioInfoManager#removeObserver to delete the RadioStateObserver. The observer must be the same as that added.
Refer RadioStateObserver  API detaids for all information.

Extending RadioStateObserver we get 2 call backs onSignalInfoUpdated and onNetworkStateUpdated
Required permission: ohos.permission.GET_NETWORK_INFO and ohos.permission.LOCATION

Note: CDMA TDCDMA networks not tested as of due to non avalibility of test setup
