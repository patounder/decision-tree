package dto;

import java.util.List;

public class TrainingDataset {

    private List<String> attributes;
    private List<TrainingRecord> records;

    public TrainingDataset() {
        super();
    }

    public TrainingDataset(List<String> attributes, List<TrainingRecord> records) {
        super();
        this.attributes = attributes;
        this.records = records;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<TrainingRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TrainingRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "TrainingDataset{" +
                "attributes=" + attributes +
                ", records=" + records +
                '}';
    }
}
