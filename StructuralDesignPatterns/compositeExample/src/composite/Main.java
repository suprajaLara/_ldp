package composite;

public class Main {

    public static void main(String[] args) {
	    Mouse mouse = new Mouse(200, "Hp");
	    Keyboard keyboard = new Keyboard(550.0, "LogiTech");
	    Ram ram = new Ram(1001, "Intel");
	    HardDrive hardDrive = new HardDrive(1570, "SanDisk");
	    MotherBoard motherBoard = new MotherBoard(2500, "Asus");

	    CPU cpu = new CPU();
	    cpu.addComponent(hardDrive);
	    cpu.addComponent(motherBoard);
	    cpu.addComponent(ram);
		System.out.println("Details of Cpu components: ");
		cpu.showDetails();

	    Computer computer = new Computer();
	    computer.addComponent(cpu);
	    computer.addComponent(mouse);
	    computer.addComponent(keyboard);
		System.out.println("\nDetails of Computer components: ");
	    computer.showDetails();
    }
}
