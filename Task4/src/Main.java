import City.StateValue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StateValue> stateValues = new ArrayList<>();

        stateValues.add(new StateValue("SP", 67836.43));
        stateValues.add(new StateValue("RJ", 36678.66));
        stateValues.add(new StateValue("MG", 29229.88));
        stateValues.add(new StateValue("ES", 27165.48));
        stateValues.add(new StateValue("Outros", 19849.53));

        double total = stateValues.stream().mapToDouble(StateValue::getStateValue).sum();

        for (StateValue state : stateValues) {
            System.out.println(state.getStateName() +
                    " apresentou " +
                    String.format("%.2f", (state.getStateValue()/total * 100)) +
                    "% do valor total.");
        }
    }
}