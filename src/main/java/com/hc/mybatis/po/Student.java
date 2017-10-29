package com.hc.mybatis.po;

public class Student {
    private Integer id;

    private String name;

    private Float chinese;

    private Float english;

    private Float math;

    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getChinese() {
        return chinese;
    }

    public void setChinese(Float chinese) {
        this.chinese = chinese;
    }

    public Float getEnglish() {
        return english;
    }

    public void setEnglish(Float english) {
        this.english = english;
    }

    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", chinese=" + chinese + ", english=" + english + ", math="
				+ math + ", sex=" + sex + "]";
	}
}