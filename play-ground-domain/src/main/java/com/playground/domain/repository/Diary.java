package com.playground.domain.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Entity
@Data
@Table(name = "diary")
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "userId")
	private String userId;

	@Column(name = "year")
	private Integer year;

	@Column(name = "month")
	private Integer month;

	@Column(name = "day")
	private Integer day;

	@Column(name = "content")
	private String content;
}
