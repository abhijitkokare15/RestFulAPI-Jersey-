package com.abhijit.Response_TO_Client;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Student {
	
	private String name;
	
	private int  age;

	@XmlElement(name="studentName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @XmlElement(name="studentage")
	public int getAge() {
		return age;
	}
   
    
	public void setAge(int age) {
		this.age = age;
	}
	
}
