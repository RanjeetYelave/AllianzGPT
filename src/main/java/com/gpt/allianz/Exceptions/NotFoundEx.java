package com.gpt.allianz.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundEx extends RuntimeException {
	private String message;
	private boolean responseStatus;
}
