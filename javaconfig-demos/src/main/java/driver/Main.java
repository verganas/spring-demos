package driver;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import otherpackage.Student;
import aggregator.BeanHolder;
import aggregator.BeanHolderV2;
import config.EducationConfig;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(EducationConfig.class); // This config class includes all the rest
		ctx.refresh();

		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		
		Student student = ctx.getBean(Student.class);
		student.payTuition();
		
		BeanHolder bh = ctx.getBean(BeanHolder.class);
		bh.delegateToBeans();
		
		BeanHolderV2 bhv2 = ctx.getBean(BeanHolderV2.class);
		bhv2.doStuff();
		
		ctx.close();
	}
}
