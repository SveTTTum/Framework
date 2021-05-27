package model;

public class DataCalculator {
    public static final String NUMBER_INSTANCES = "number.instances";
    public static final String WHAT_INSTANCES_FOR = "what.instances.for";
    public static final String OPERATING_SYSTEM = "operating.system";
    public static final String MACHINE_CLASS = "machine.class";
    public static final String SERIES = "series";
    public static final String MACHINE_TYPE = "machine.type";
    public static final String NUMBER_GPUS = "numberGPUs";
    public static final String TYPE_GPUS = "typeGPUs";
    public static final String LOCAL_SSD = "localSSD";
    public static final String DATACENTER_LOCATION = "datacenter.location";
    public static final String COMMITED_USAGE = "commited.usage";

    public DataCalculator() {
    }

    public static String getNumberInstances() {
        return NUMBER_INSTANCES;
    }

    public static String getWhatInstancesFor() {
        return WHAT_INSTANCES_FOR;
    }

    public static String getOperatingSystem() {
        return OPERATING_SYSTEM;
    }

    public static String getMachineClass() {
        return MACHINE_CLASS;
    }

    public static String getSERIES() {
        return SERIES;
    }

    public static String getMachineType() {
        return MACHINE_TYPE;
    }

    public static String getNumberGpus() {
        return NUMBER_GPUS;
    }

    public static String getTypeGpus() {
        return TYPE_GPUS;
    }

    public static String getLocalSsd() {
        return LOCAL_SSD;
    }

    public static String getDatacenterLocation() {
        return DATACENTER_LOCATION;
    }

    public static String getCommitedUsage() {
        return COMMITED_USAGE;
    }

    @Override
    public String toString() {
        return "DataCalculator{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
