package pro13;

public class Testing {

	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());

	}
	

}

class SutdaCard {
	int num;
	boolean iskwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean iskwang) {
		this.num = num;
		this.iskwang = iskwang;
	}
	
	String info() {
		return num + ( iskwang? "K" : "");
	}
	
}