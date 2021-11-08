package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// 모든 속성을 사용한 생성자
@AllArgsConstructor
// 비어있는 생성자
@NoArgsConstructor
public class SampleVO {

	private Integer Mno;
	private String firstName;
	private String lastName;
	
}
