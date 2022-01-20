package games;

public abstract class Games {
	protected String msg;
	protected int executeCount;
	protected boolean errorFlag;
	protected boolean endFlag;
	
	public abstract void init();
	public abstract Games execute(final Object input);
	public abstract String getResult();
	protected abstract void reset();
	
	public boolean getErrorFlag() {
		return this.errorFlag;
	}
	
	public boolean getEndFlag() {
		return this.endFlag;
	}
	
}
