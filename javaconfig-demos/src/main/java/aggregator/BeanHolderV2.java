package aggregator;

import hotpackage.Patient;
import otherpackage.Student;

public interface BeanHolderV2 {

	public abstract void doStuff();

	public abstract void setStudent(Student student);

	public abstract void setPatient(Patient patient);

}