package hw7;

public enum DistanceAnswer {
    WILL_ENOUGH("There will be enough fuel in the tank"),
    NEED_REFUEL("Will need to refuel");

    private final String answer;

    DistanceAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.answer;
    }
}