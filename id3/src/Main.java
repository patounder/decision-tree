import dto.TrainingDataset;
import dto.TrainingRecord;
import services.ID3Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ID3Service id3Service = new ID3Service();
        //int count = id3Service.countValues(buildTrainingDataset(), "playtennis", "yes");
        //System.out.println(id3Service.getAttributeValues(buildTrainingDataset(), "outlook"));
        System.out.println(id3Service.entropy(buildTrainingDataset(), "playtennis"));
    }


    public static TrainingDataset buildTrainingDataset(){

        List<String> attributes = new ArrayList<>();
        attributes.add("outlook");
        attributes.add("temperature");
        attributes.add("humidity");
        attributes.add("wind");
        attributes.add("playtennis");

        List<TrainingRecord> records = new ArrayList<>();
        records.add(new TrainingRecord(Arrays.asList("sunny", "hot", "high", "weak", "no")));
        records.add(new TrainingRecord(Arrays.asList("sunny", "hot", "high", "strong", "no")));
        records.add(new TrainingRecord(Arrays.asList("overcast", "hot", "high", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("rain", "mild", "high", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("rain", "cool", "normal", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("rain", "cool", "normal", "strong", "no")));
        records.add(new TrainingRecord(Arrays.asList("overcast", "cool", "normal", "strong", "yes")));
        records.add(new TrainingRecord(Arrays.asList("sunny", "mild", "high", "weak", "no")));
        records.add(new TrainingRecord(Arrays.asList("sunny", "cool", "normal", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("rain", "mild", "normal", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("sunny", "mild", "normal", "strong", "yes")));
        records.add(new TrainingRecord(Arrays.asList("overcast", "mild", "high", "strong", "yes")));
        records.add(new TrainingRecord(Arrays.asList("overcast", "hot", "normal", "weak", "yes")));
        records.add(new TrainingRecord(Arrays.asList("rain", "mild", "high", "strong", "no")));

        return new TrainingDataset(attributes, records);
    }
}
