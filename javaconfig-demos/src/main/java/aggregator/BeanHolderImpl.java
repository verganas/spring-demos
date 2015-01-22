package aggregator;

import hotpackage.Patient;
import otherpackage.Student;

public class BeanHolderImpl implements BeanHolder {

	protected Student student;
	protected Patient patient;

	public BeanHolderImpl(Student student, Patient patient) {
		this.student = student;
		this.patient = patient;
	}

	/* (non-Javadoc)
	 * @see aggregator.BeanHolder#delegateToBeans()
	 */
	public void delegateToBeans() {
		student.payTuition();
		patient.payLotsOfMoney();
	}

}
