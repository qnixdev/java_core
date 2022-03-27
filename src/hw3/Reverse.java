package hw3;

public class Reverse {
    private final String string;

    public Reverse(String stringToFlip) {
        this.string = stringToFlip;
    }

    public String reverseString() {
        String[] stringToArray = this.string.split("Z");
        StringBuilder resultString = new StringBuilder();

        for (String word : stringToArray) {
            if (word.length() == 0) {
                continue;
            }

            StringBuilder nextWord = new StringBuilder(word);
            resultString.append(nextWord.reverse());
            resultString.append(' ');
        }

        return resultString.toString().trim();
    }
}
