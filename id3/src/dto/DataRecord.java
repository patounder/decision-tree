package dto;

import java.util.List;

public class DataRecord {

    private List<String> values;

    public DataRecord(){
        super();
    }

    public DataRecord(List<String> values) {
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
        return "DataRecord{" +
                "values=" + values +
                '}';
    }
}
