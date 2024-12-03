package ProductManage;

public class Medicine extends Product{
	
	String instruction;
	
	public Medicine(String name, int stock, String image, String instruction){
		super(name, stock, image);
		this.instruction = instruction;
	}
	
	public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

}
