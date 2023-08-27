package com.gpt.allianz.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {

	private int id;
	private String question;
	private String date;
	private String time;

}
