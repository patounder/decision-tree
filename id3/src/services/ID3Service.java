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

    //select best attribute (effectiveness) to classify training data
    private String findBestSplit(TrainingDataset trainingDataset, List<String> attributes, String targetAttribute){

        String selectedAttribute = null;
        double informationGain = 0;

        for(String attribute : attributes){
            double informationGainAttribute = gain(trainingDataset, attribute, targetAttribute);

            if(informationGainAttribute > informationGain){
                selectedAttribute = attribute;
                informationGain = informationGainAttribute;
            }
        }

        return selectedAttribute;
    }

    //size purity of training dataset
    public double entropy(TrainingDataset trainingDataset, String targetAttribute){

        double entropyVal = 0;
        List<String> valuesList = getAttributeValues(trainingDataset, targetAttribute);

        for(String valueAttribute : valuesList){
            int occurrences = countValues(trainingDataset, targetAttribute, valueAttribute);
            double proportion = (double)occurrences/trainingDataset.getRecords().size();
            entropyVal = entropyVal - proportion * (Math.log10(proportion)/Math.log10(2));
        }

        return entropyVal;
    }

    //calc information gain for selected attribute by target attribute
    public double gain(TrainingDataset trainingDataset, String selectedAttribute, String targetAttribute){
        double gralEntropy = entropy(trainingDataset, targetAttribute);
        double summa = 0;

        //TODO calc summa
        List<String> valuesList = getAttributeValues(trainingDataset, selectedAttribute);

        for(String value : valuesList){
            TrainingDataset subset  = getSubTrainingDS(trainingDataset, selectedAttribute, value);
            double subsetEntropy = entropy(subset, targetAttribute);
            double proportion = (double)subset.getRecords().size()/trainingDataset.getRecords().size();
            summa = summa + proportion * subsetEntropy;
        }

        return gralEntropy - summa;
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
