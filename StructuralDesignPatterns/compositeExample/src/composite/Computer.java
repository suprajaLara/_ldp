package composite;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponent{
    private List<ComputerComponent> ComputerComponents = new ArrayList<>();

    @Override
    public void showDetails() {
        for(ComputerComponent component : ComputerComponents){
            component.showDetails();
        }
    }

    public void addComponent(ComputerComponent computerComponent){
        ComputerComponents.add(computerComponent);
    }

}
