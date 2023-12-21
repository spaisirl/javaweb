package board;

import java.sql.Date;

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

public class BoardVO {
	
	private int bno; //글 번호
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private Date regdate;
	
	private String attach_file;
}
