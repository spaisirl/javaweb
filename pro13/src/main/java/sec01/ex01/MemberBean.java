package sec01.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberBean {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String joindate;

}
