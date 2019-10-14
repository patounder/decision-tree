import dto.DataRecord;
import dto.Node;
import dto.TrainingDataset;
import services.ID3Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TrainingDataset trainingDataset = buildTrainingDataset();
        ID3Service id3Service = new ID3Service();


        //System.out.println(id3Service.countValues(buildTrainingDataset(), "playtennis", "yes"));
        //System.out.println(id3Service.getAttributeValues(buildTrainingDataset(), "outlook"));
        //System.out.println(id3Service.entropy(buildTrainingDataset(), "playtennis"));
        //System.out.println(id3Service.gain(buildTrainingDataset(), "wind", "playtennis"));
        //System.out.println(id3Service.getSubTrainingDS(buildTrainingDataset(), "wind", "strong"));
        //System.out.println(id3Service.findBestSplit(trainingDataset, trainingDataset.getAttributes(), "playtennis"));
        //System.out.println(id3Service.getLeafLabel(trainingDataset, "playtennis"));
        Node tree = id3Service.treeGrowth(trainingDataset, trainingDataset.getAttributes(), "playtennis",
                "root");
        System.out.println(tree);

        String classifyLabel = id3Service.classifyRecord(buildDataRecord(), tree, trainingDataset.getAttributes());
        System.out.println(classifyLabel);
    }


    public static TrainingDataset buildTrainingDataset(){

        List<String> attributes = new ArrayList<>();
        attributes.add("outlook");
        attributes.add("temperature");
        attributes.add("humidity");
        attributes.add("wind");
        attributes.add("playtennis");

        List<DataRecord> records = new ArrayList<>();
        records.add(new DataRecord(Arrays.asList("sunny", "hot", "high", "weak", "no")));
        records.add(new DataRecord(Arrays.asList("sunny", "hot", "high", "strong", "no")));
        records.add(new DataRecord(Arrays.asList("overcast", "hot", "high", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("rain", "mild", "high", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("rain", "cool", "normal", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("rain", "cool", "normal", "strong", "no")));
        records.add(new DataRecord(Arrays.asList("overcast", "cool", "normal", "strong", "yes")));
        records.add(new DataRecord(Arrays.asList("sunny", "mild", "high", "weak", "no")));
        records.add(new DataRecord(Arrays.asList("sunny", "cool", "normal", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("rain", "mild", "normal", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("sunny", "mild", "normal", "strong", "yes")));
        records.add(new DataRecord(Arrays.asList("overcast", "mild", "high", "strong", "yes")));
        records.add(new DataRecord(Arrays.asList("overcast", "hot", "normal", "weak", "yes")));
        records.add(new DataRecord(Arrays.asList("rain", "mild", "high", "strong", "no")));

        return new TrainingDataset(attributes, records);
    }

    public static DataRecord buildDataRecord(){
        return new DataRecord(Arrays.asList("rain", "mild", "high", "weak", "yes"));
    }
}
