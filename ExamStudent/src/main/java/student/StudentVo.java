package student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

	private Integer s_no;
	private String s_name;
	private Integer s_year;
	private String s_gender;
	private String s_major;
	private Integer s_score;
}
