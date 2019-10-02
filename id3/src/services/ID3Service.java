package services;

import dto.*;

import java.util.ArrayList;
import java.util.List;

public class ID3Service {


    public Node treeGrowth(TrainingDataset trainingDataset, List<String> avalaibleAttributes, String targetAttribute){

        if(stoppingCond(trainingDataset, avalaibleAttributes)){
            Node leaf = new LeafNode();
            leaf.setAttributeLabelName(classify(trainingDataset));
            return leaf;

        } else {
            Node root = new TestNode();
            root.setAttributeLabelName(findBestSplit(trainingDataset, avalaibleAttributes));

            List<String> attributesAvailable = getAttributeValues(trainingDataset, root.getAttributeLabelName());

            for(String attributeValue : attributesAvailable){
                TrainingDataset subTrainingDS = getSubTrainingDS(root.getAttributeLabelName(), attributeValue);
                Node child = treeGrowth(subTrainingDS, avalaibleAttributes, targetAttribute);
                root.getChildList().add(child);
            }

            return root;
        }
    }

    private boolean stoppingCond(TrainingDataset trainingDataset, List<String> attributes){
        return false;
    }

    private String classify(TrainingDataset trainingDataset){
        return null;
    }

    private String findBestSplit(TrainingDataset trainingDataset, List<String> attributes){
        //TODO implement entropy
        //TODO implement information gain

        return null;
    }

    public double entropy(TrainingDataset trainingDataset, String targetAttribute){

        double entropyVal = 0;
        List<String> valuesList = getAttributeValues(trainingDataset, targetAttribute);

        for(String valueAttribute : valuesList){
            int occurrences = countValues(trainingDataset, targetAttribute, valueAttribute);
            double proportion = (double)occurrences/trainingDataset.getRecords().size();
            entropyVal = entropyVal - proportion * Math.log(proportion);
        }

        return entropyVal;
    }

    private double gain(TrainingDataset trainingDataset, String targetAttribute){
        return 0;
    }

    //get possible values for attribute
    public List<String> getAttributeValues(TrainingDataset trainingDataset, String targetAttribute){
        // let V : {v|v is a possible outcome of node.test-cond}.
        List<String> valueList = new ArrayList<>();
        int attributeIndex = trainingDataset.getAttributes().indexOf(targetAttribute);

        for(TrainingRecord record : trainingDataset.getRecords()){

            if(!valueList.contains(record.getValues().get(attributeIndex))){
                valueList.add(record.getValues().get(attributeIndex));
            }
        }
        return valueList;
    }

    //get counter of record when targetAttribute equal valueAttribute
    public int countValues(TrainingDataset trainingDataset, String targetAttribute, String valueAttribute){

        int count = 0;
        int attributeIndex = trainingDataset.getAttributes().indexOf(targetAttribute);

        for(TrainingRecord record : trainingDataset.getRecords()){

            if(record.getValues().get(attributeIndex).equalsIgnoreCase(valueAttribute)){
                count++;
            }
        }

        return count;
    }

    private TrainingDataset getSubTrainingDS(String attribute, String value){
        return null;
    }
}
