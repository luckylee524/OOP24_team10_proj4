package ProductManage;

public class Medicine extends Product{
	
	String instruction;
	
	Medicine(String name, int stock, String instruction){
		super(name, stock);
		this.instruction = instruction;
	}
	
	public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

}
