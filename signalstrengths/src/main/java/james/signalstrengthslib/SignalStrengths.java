package james.signalstrengthslib;

import ohos.app.Context;
import ohos.telephony.RadioInfoManager;
import ohos.telephony.SignalInformation;
import ohos.telephony.TelephonyConstants;
import ohos.utils.Parcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignalStrengths {
    public static final String METHOD_GSM_LEVEL = "getGsmLevel";
    public static final String METHOD_GSM_DBM = "getGsmDbm";
    public static final String METHOD_CDMA_LEVEL = "getCdmaLevel";
    public static final String METHOD_TD_SCDMA_LEVEL = "getTdScdmaLevel";
    public static final String METHOD_TD_SCDMA_DBM = "getTdScdmaDbm ";
    public static final String METHOD_CDMA_DBM = "getCdmaDbm";
    public static final String METHOD_CDMA_ECIO = "getCdmaEcio";
    public static final String METHOD_EVDO_DBM = "getEvdoDbm";
    public static final String METHOD_EVDO_SNR = "getEvdoSnr";
    public static final String METHOD_LTE_LEVEL = "getLteLevel";
    public static final String METHOD_LTE_RSRP = "getLteRsrp";
    public static final String METHOD_LTE_RSRQ = "getLteRsrq";
    public static final String METHOD_LTE_RSSNR = "getLteRssnr";
    public static final String METHOD_WCDMA_DBM = "getWcdmaDbm";
    public static final String METHOD_WCDMA_ECNO = "getWcdmaecno";
    public static final String METHOD_WCDMA_LEVEL = "getWcdmasignallevel";
    public static final String METHOD_NR_RSRP = "getNrRsrp";
    public static final String METHOD_NR_RSRQ = "getNrRsrq";
    public static final String METHOD_NR_SINR = "getNrSinr";
    public static final String METHOD_NR_LEVEL = "getNrLevel";

    private static int[] mnrrsrp = new int[2];
    private static int[] mnrrsrq = new int[2];
    private static int[] mnrsinr = new int[2];
    private static int[] mnrsignallevel = new int[2];
    private static int[] mltersrp = new int[2];
    private static int[] mltersrq = new int[2];
    private static int[] mlterssnr = new int[2];
    private static int[] mltesignallevel = new int[2];
    private static int[] mwcdmarscp = new int[2];
    private static int[] mwcdmaecno = new int[2];
    private static int[] mwcdmasignallevel = new int[2];
    private static int[] mgsmrssi = new int[2];
    private static int[] mgsmsignallevel = new int[2];
    private static int[] mCdmaRssi = new int[2];
    private static int[] mCdmaEcio = new int[2];
    private static int[] mEvdoRssi = new int[2];
    private static int[] mEvdoSnr = new int[2];
    private static int[] mCdmaSignalLevel = new int[2];
    private static int[] mTdscdmaRscp = new int[2];
    private static int[] mTdscdmaSignalLevel = new int[2];

	private SignalStrengths(){
    //Added to resolve sonarqube erros
	}
    private static final List<SignalMethod> methods = new ArrayList<>(Arrays.asList(
            new SignalMethod(METHOD_GSM_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mgsmsignallevel[subId];
                }
            },
            new SignalMethod(METHOD_GSM_DBM) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getDbmLevel(mgsmrssi[subId]);
                }
            },
            new SignalMethod(METHOD_CDMA_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mCdmaSignalLevel[subId];
                }
            },
            new SignalMethod(METHOD_TD_SCDMA_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mTdscdmaSignalLevel[subId];
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_TD_SCDMA_DBM) {
                @Override
                public double getLevel(int subId, Context c) {
                    getAllSignalValues(subId,c);
                    return SignalUtils.getDbmLevel(mTdscdmaRscp[subId]);
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_CDMA_DBM) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getDbmLevel(mCdmaRssi[subId]);
                }
            },
            new SignalMethod(METHOD_CDMA_ECIO) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getEcioLevel(mCdmaEcio[subId]);
                }
            },
            new SignalMethod(METHOD_EVDO_DBM) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getDbmLevel(mEvdoRssi[subId]);
                }
            },
            new SignalMethod(METHOD_EVDO_SNR) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getSnrLevel(mEvdoSnr[subId]);
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_LTE_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mltesignallevel[subId];
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_LTE_RSRP) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getRsrpLevel(mltersrp[subId]);
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_LTE_RSRQ) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getRsrqLevel(mltersrq[subId]);
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_LTE_RSSNR) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getSnrLevel(mlterssnr[subId]);
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            },
            new SignalMethod(METHOD_WCDMA_DBM) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getDbmLevel(mwcdmarscp[subId]);
                }
            },
            new SignalMethod(METHOD_WCDMA_ECNO) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mwcdmaecno[subId];
                }
            },
            new SignalMethod(METHOD_WCDMA_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mwcdmasignallevel[subId];
                }
            },
            new SignalMethod(METHOD_NR_RSRP) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getRsrpLevel(mnrrsrp[subId]);
                }
            },
            new SignalMethod(METHOD_NR_RSRQ) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return SignalUtils.getRsrqLevel(mnrrsrq[subId]);
                }
            },
            new SignalMethod(METHOD_NR_SINR) {
                @Override
                public double getLevel(int subId, Context c) {
				    getAllSignalValues(subId,c);
                    return SignalUtils.getSinrLevel(mnrsinr[subId]);
                }
            },
            new SignalMethod(METHOD_NR_LEVEL) {
                @Override
                public double getLevel(int subId, Context c) {
					getAllSignalValues(subId,c);
                    return mnrsignallevel[subId];
                }

                @Override
                public boolean isMethodExcluded() {
                    return isExcluded == null || isExcluded;
                }
            }
    ));

    public static List<SignalMethod> getMethods() {
        return methods;
    }

    public static double get(String methodName, int subId, Context c) {
        for (SignalMethod method : methods) {
            if (methodName.equals(method.getName()))
                    return method.getLevel(subId,c);
        }

        return 0;
    }

    public static double getFirstValid(int subId, Context c) {
        for (SignalMethod method : methods) {
            if (method.isMethodExcluded()) continue;

            double level;
            level = method.getLevel(subId,c);
            if (SignalUtils.isValidLevel(level) && level > 0)
                return level;
        }

        return 0;
    }

    public static double getAverage(int subId, Context c) {
        List<Double> values = new ArrayList<>();

        for (SignalMethod method : methods) {
            if (method.isMethodExcluded()) continue;
            double level;
            level = method.getLevel(subId,c);
            if (SignalUtils.isValidLevel(level) && level > 0)
                values.add(level);
        }

        double level = 0;
        for (Double value : values) {
            level += value;
        }

        return values.isEmpty() ? level:level / values.size();
    }

    /**
     * This method should be called first to get all Signal details from framework and put it locally
     *
     * @param subId subId for which details are required
	 * @param c application context
     */
    public static void getAllSignalValues(int subId, Context c) {
        Parcel p = Parcel.create();
        if (c != null && p != null) {
            //Obtains the list of signal strength information of the registered network corresponding to a specified SIM card.
            //If the specified SIM card camps on one or more networks, the signal strength of these networks is reported
            //To get the signal level of the signal to which device is connected
            RadioInfoManager radioInfo = RadioInfoManager.getInstance(c);
            if (null != radioInfo) {
                setParams(radioInfo, subId, p);
                p.reclaim();
            }
        }
    }

    /**
     * Method to setParams
     */
    static void setParams(RadioInfoManager radioInfo, int subId, Parcel p) {
        //Obtains the list of signal strength information of the registered network corresponding to a specified SIM card.
        List<SignalInformation> snList = radioInfo.getSignalInfoList(subId);
        for (int in = 0; in < snList.size(); in++) {
            snList.get(in).marshalling(p);
            //To get the signal level of the signal to which device is connected
            //First param in parcel is always network type so read it here before retriving all other values
            int networkType = p.readInt();
            switch (networkType) {
                case TelephonyConstants.NETWORK_TYPE_NR:
                    mnrrsrp[subId] = p.readInt();
                    mnrrsrq[subId] = p.readInt();
                    mnrsinr[subId] = p.readInt();
                    mnrsignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_LTE:
                    mltersrp[subId] = p.readInt();
                    mltersrq[subId] = p.readInt();
                    mlterssnr[subId] = p.readInt();
                    mltesignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_WCDMA:
                    mwcdmarscp[subId] = p.readInt();
                    mwcdmaecno[subId] = p.readInt();
                    mwcdmasignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_GSM:
                    mgsmrssi[subId] = p.readInt();
                    mgsmsignallevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_CDMA:
                    mCdmaRssi[subId] = p.readInt();
                    mCdmaEcio[subId] = p.readInt();
                    mEvdoRssi[subId] = p.readInt();
                    mEvdoSnr[subId] = p.readInt();
                    mCdmaSignalLevel[subId] = snList.get(in).getSignalLevel();
                    break;
                case TelephonyConstants.NETWORK_TYPE_TDSCDMA:
                    mTdscdmaRscp[subId] = p.readInt();
                    mTdscdmaSignalLevel[subId] = snList.get(in).getSignalLevel();
                    break;
                default:
                    break;
            }
        }
    }

}
