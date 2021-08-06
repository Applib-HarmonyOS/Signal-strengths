package james.signalstrengthslib;

import ohos.app.Context;

public abstract class SignalMethod {

    protected Boolean isExcluded;
    private String name;

    protected SignalMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getLevel(int subId, Context c);

    public boolean isMethodExcluded() {
        return isExcluded != null && isExcluded;
    }

    public void setExcluded(boolean setExcluded) {
        this.isExcluded = setExcluded;
    }

}
