package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Player {
	private Long id;

	@NotEmpty
	private String name;

    @NotNull // ②
    @Min(value = 0) // ③
    @Max(value = 150)
	private Long age;

    @Size(max = 20)
	private String team;

    @Size(max = 20)
	private String position;

    private boolean marriage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean getMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}
}
