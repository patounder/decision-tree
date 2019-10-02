package dto;

import java.util.List;

public class TrainingRecord {

    private List<String> values;

    public TrainingRecord(){
        super();
    }

    public TrainingRecord(List<String> values) {
        super();
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "TrainingRecord{" +
                "values=" + values +
                '}';
    }
}
