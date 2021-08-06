package james.signalstrengthslib;

import ohos.app.Context;

public abstract class SignalMethod {

    public Boolean isExcluded;
    private String name;

    public SignalMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getLevel(int subId, Context c) throws Exception;

    public boolean isExcluded() {
        return isExcluded != null && isExcluded;
    }

    public void setExcluded(boolean isExcluded) {
        this.isExcluded = isExcluded;
    }

}
