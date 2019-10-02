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
            root.setAttributeLabelName(findBestSplit(trainingDataset, avalaibleAttributes, targetAttribute));

            List<String> attributesAvailable = getAttributeValues(trainingDataset, root.getAttributeLabelName());

            for(String attributeValue : attributesAvailable){
                TrainingDataset subTrainingDS = getSubTrainingDS(trainingDataset, root.getAttributeLabelName(), attributeValue);
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

    private String findBestSplit(TrainingDataset trainingDataset, List<String> attributes, String targetAttribute){
        //TODO implement entropy
        //TODO implement information gain

        String selectedAttribute = null;
        double gralEntropy = entropy(trainingDataset, targetAttribute);
        double sumatory = 0;

        for(String attribute : attributes){

            List<String> valuesList = getAttributeValues(trainingDataset, attribute);
            for(String valueAttribute : valuesList){
                int occurrences = countValues(trainingDataset, targetAttribute, valueAttribute);

            }


            double attributeGain = 0;

        }

        return null;
    }

    //size purity of training dataset
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

    //get subset training dataset where attribute is value
    public TrainingDataset getSubTrainingDS(TrainingDataset trainingDataset, String attribute, String value){
        int attributeIndex = trainingDataset.getAttributes().indexOf(attribute);
        List<TrainingRecord> records = new ArrayList<>();

        for(TrainingRecord record : trainingDataset.getRecords()){
            if(record.getValues().get(attributeIndex).equalsIgnoreCase(value)){
                records.add(record);
            }
        }

        return new TrainingDataset(trainingDataset.getAttributes(), records);
    }

    //get counter of record when targetAttribute equal valueAttribute
    public int countValues(TrainingDataset trainingDataset, String targetAttribute, String valueAttribute){
        return getSubTrainingDS(trainingDataset, targetAttribute, valueAttribute).getRecords().size();
    }
}
