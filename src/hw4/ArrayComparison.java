package hw4;

public class ArrayComparison {
    public boolean isArraysAreEqual(
        String[] firstArray,
        String[] secondArray
    ) {
        StringBuilder wordOne = new StringBuilder();

        for (String element : firstArray) {
            wordOne.append(element);
        }

        StringBuilder wordTwo = new StringBuilder();

        for (String element : secondArray) {
            wordTwo.append(element);
        }

        return wordOne.toString().equals(wordTwo.toString());
    }
}