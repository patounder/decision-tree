package services;

import dto.*;

import java.util.ArrayList;
import java.util.List;

public class ID3Service {


    public Node treeGrowth(TrainingDataset trainingDataset, List<String> availableAttributes, String targetAttribute){

        if(stoppingCond(trainingDataset, availableAttributes, targetAttribute)){
            Node leaf = new LeafNode();
            leaf.setAttributeLabelName(classify(trainingDataset, targetAttribute));
            return leaf;
        } else {
            Node root = new TestNode();
            root.setAttributeLabelName(findBestSplit(trainingDataset, availableAttributes, targetAttribute));

            List<String> availableAttributesUpdate = new ArrayList<>(availableAttributes);
            availableAttributesUpdate.remove(root.getAttributeLabelName());

            List<String> attributeValues = getAttributeValues(trainingDataset, root.getAttributeLabelName());

            for(String attributeValue : attributeValues){
                TrainingDataset subTrainingDS = getSubTrainingDS(trainingDataset, root.getAttributeLabelName(),
                        attributeValue);
                Node child = treeGrowth(subTrainingDS, availableAttributesUpdate, targetAttribute);
                root.getChildList().add(child);
            }

            return root;
        }
    }

    private boolean stoppingCond(TrainingDataset trainingDataset, List<String> attributes, String targetAttribute){

        double entropy = entropy(trainingDataset, targetAttribute);

        if(entropy == 0){
            return true;
        }

        return attributes.isEmpty();
    }

    private String classify(TrainingDataset trainingDataset, String targetAttribute){

        int count = 0;
        String selectedLabel = null;
        List<String> valuesList = getAttributeValues(trainingDataset, targetAttribute);
        int attributeIndex = trainingDataset.getAttributes().indexOf(targetAttribute);

        for (String value : valuesList){
            long counterRecord = trainingDataset.getRecords().stream().filter( r ->
                    value.equalsIgnoreCase(r.getValues().get(attributeIndex))).count();

            if(counterRecord > count){
                selectedLabel = value;
            }
        }


        return selectedLabel;
    }

    //select best attribute (effectiveness) to classify training data
    public String findBestSplit(TrainingDataset trainingDataset, List<String> attributes, String targetAttribute){

        String selectedAttribute = null;
        double informationGain = 0;
        List<String> attributesWithoutTarget = new ArrayList<>(attributes);
        attributesWithoutTarget.remove(targetAttribute);

        for(String attribute : attributesWithoutTarget){
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
