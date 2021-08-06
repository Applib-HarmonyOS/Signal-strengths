[![Build](https://github.com/applibgroup/Signal-strengths/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/Signal-strengths/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_Signal-strengths&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_Signal-strengths)
# Signal-strengths
SignalStrengths is a library and sample application with the purpose of getting an accurate signal strength on different HMOS phones.

For testing and experimentation purposes, a sample apk can be downloaded [here](https://github.com/applibgroup/Signal-strengths).

# Source
This library has been inspired by (https://github.com/fennifith/SignalStrengths) version 1.0, released on October 19, 2018.
## Dependency
The Gradle dependency is available through jCenter, which is used by default in Deveco Studio. To add the module to your project, copy this line into the dependencies section of your build.gradle file.
``` gradle
compile 'james.signalstrengths:signalstrengths:0.0.4'
```
## Usage

### Setup

### Listening for Signal Changes

To get your app to listen for a signal change, use RadioStateObserver class
### Getting a Signal Value

To obtain a signal value from a `SignalStrength` , simply pass subscription Id and Context to one of the methods in the `SignalStrengths` class, which will return a number from 0-4, or -1 if an error occurs. Some examples of this are below.

#### Using a Specific Method

This allows you to specify exactly which method you want to obtain a value from.

``` java
double level = SignalStrengths.get(SignalStrengths.METHOD_LEVEL, subId, context);
```

#### First Valid Level

This gets the first valid signal level available from any method in order of accuracy. This is the most recommended way of getting a signal value, as it is the most consistently accurate across different phones and versions. See Excluding Methods, and Custom Methods sections for for ways to change this method's behavior.

``` java
double level = SignalStrengths.getFirstValid(signalStrength);
```

#### Average Level

This gets the average of all the valid levels. To exclude a level, see [Excluding Methods](#excluding-methods).

``` java
double level = SignalStrengths.getAverage(subId,context);
```

### Excluding Methods

The list of methods used by `SignalStrengths` can be accessed using `SignalStrengths.getMethods()`. An example of how to exclude a method is below.

``` java
SignalStrengths.getMethods().get(5).setExcluded(true);
```

### Custom Methods

It is also possible to add your own method to the list of methods used by SignalStrengths. An example for how to create a new method is below.

``` java
SignalStrengths.getMethods().add(new SignalMethod("Method Id") {
  @Override
  public double getLevel(int subId, Context c) {
    return new Random().nextDouble();
  }
});
```
##License


   Copyright 2016 James Fenn

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
