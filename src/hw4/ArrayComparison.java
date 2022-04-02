package hw4;

public class ArrayComparison {
    public boolean isArraysAreEqual(String[] firstArray, String[] secondArray) {
        String wordOne = String.join("", firstArray);
        String wordTwo = String.join("", secondArray);

        return wordOne.equals(wordTwo);
    }
}