package hello;

import java.util.List;

public class Upload {

    /**
     * activity : 0
     * startTime : 2017-08-25T07:41:13.604Z
     * endTime : 2017-08-25T07:41:13.604Z
     * sampleFrequency : 0
     * accelerations : [{"x":0,"y":0,"z":0}]
     * rotationRates : [{"x":0,"y":0,"z":0}]
     */

    private int activity;
    private String startTime;
    private String endTime;
    private int sampleFrequency;
    private List<AccelerationsBean> accelerations;
    private List<RotationRatesBean> rotationRates;

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSampleFrequency() {
        return sampleFrequency;
    }

    public void setSampleFrequency(int sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    public List<AccelerationsBean> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<AccelerationsBean> accelerations) {
        this.accelerations = accelerations;
    }

    public List<RotationRatesBean> getRotationRates() {
        return rotationRates;
    }

    public void setRotationRates(List<RotationRatesBean> rotationRates) {
        this.rotationRates = rotationRates;
    }

    public static class AccelerationsBean {
        public AccelerationsBean(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        /**
         * x : 0
         * y : 0
         * z : 0
         */

        private float x;
        private float y;
        private float z;

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }
    }

    public static class RotationRatesBean {
        /**
         * x : 0
         * y : 0
         * z : 0
         */
        private float x;
        private float y;
        private float z;

        public RotationRatesBean(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }
    }
}
