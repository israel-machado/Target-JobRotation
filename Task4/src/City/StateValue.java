package City;

public class StateValue {
    private String stateName;
    private Double stateValue;

    public StateValue(String stateName, Double stateValue) {
        this.stateName = stateName;
        this.stateValue = stateValue;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Double getStateValue() {
        return stateValue;
    }

    public void setStateValue(Double stateValue) {
        this.stateValue = stateValue;
    }
}
