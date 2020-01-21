package snowfall;

// Represents a snowfall logger
public class SnowfallLogger {
    public static final int THRESHOLD = 15;  // threshold snowfall amount in cms for a snow day
    int record;
    int day;
    int snowDay;
    double average;

    // EFFECTS: constructs snowfall logger with no snowfall records
    public SnowfallLogger() {
        this.record = 0;
        this.day = 0;
        this.snowDay = 0;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: records a snowfall of amount centimetres; if amount is at least THRESHOLD cms, records a snow day
    public void addSnowfallRecord(int amount) {
        if (amount > 0) {
            this.record = this.record + amount;
            if (amount >= THRESHOLD) {
                this.snowDay = this.snowDay + 1;
            }
            this.day = this.day + 1;
        }
    }

    // MODIFIES: this
    // EFFECTS: resets the logger so that no snowfall records are recorded
    public void reset() {
        this.record = 0;
        this.day = 0;
        this.snowDay = 0;
    }

    // REQUIRES: getNumSnowfallRecords() > 0
    // EFFECTS: returns the average snowfall across all records added
    public double getAverageSnowfall() {
        if (getNumSnowfallRecords() > 0) {
            double answer = this.record;
            average = answer / day;
        }
        return average;
    }

    // EFFECTS: returns the number of snowfall records added
    public int getNumSnowfallRecords() {
        return this.day;
    }

    // EFFECTS: returns the number of snow days based on snowfall records added
    public int getNumSnowDays() {
        return this.snowDay;
    }
}
