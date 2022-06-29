package emp;

public class Sales extends Permanent implements IBusinessTrip {
	private int incentive;

	public Sales() {
	}

	public Sales(String id, String name, int pay, int incentive) {
		super(id, name, pay);
		this.incentive = incentive;
	}

	@Override
	public int getPay() {
		return super.getPay() + incentive;
	}

	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void goBusinessTrip(int day) {
		setIncentive(incentive + 100000 + day);
	}
}