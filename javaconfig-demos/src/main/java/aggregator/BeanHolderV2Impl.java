package aggregator;

import org.springframework.beans.factory.annotation.Autowired;

import hotpackage.Patient;
import otherpackage.Student;

public class BeanHolderV2Impl implements BeanHolderV2 {

	protected Student student;
	protected Patient patient;
	
	public BeanHolderV2Impl() {
		// Full bucket of nothing
	}
	
	/* (non-Javadoc)
	 * @see aggregator.BeanHolderV2#doStuff()
	 */
	public void doStuff() {
		student.payTuition();
		patient.payLotsOfMoney();
	}

	/* (non-Javadoc)
	 * @see aggregator.BeanHolderV2#setStudent(otherpackage.Student)
	 */
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}

	/* (non-Javadoc)
	 * @see aggregator.BeanHolderV2#setPatient(hotpackage.Patient)
	 */
	@Autowired
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
