package composite;

import java.util.ArrayList;
import java.util.List;

public class CPU implements ComputerComponent{
    private List<ComputerComponent> CPUComponents = new ArrayList<>();

    @Override
    public void showDetails() {
        for(ComputerComponent component : CPUComponents){
            component.showDetails();
        }
    }

    public void addComponent(ComputerComponent computerComponent){
        CPUComponents.add(computerComponent);
    }

}
