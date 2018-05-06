public class Water {
  
  protected boolean hitStatus;

	public Water() {

		this.hitStatus = false;
	}

	public boolean getHitStatus() {
		return this.hitStatus;
	}

	public void setHitStatus(boolean status) {
		this.hitStatus = status;
	}

	@Override
	public String toString() {
		return (hitStatus) ? "x" : "-";
	}

	public void fireAt() {
		if (!this.getHitStatus()) {
			this.setHitStatus(true);
			System.out.println("you missed");
		} else {
			System.out.println("you already fired at this spot");
		}
	}

}
