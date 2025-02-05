package section02.dto;

public class Snake extends Animal{
	
	private boolean isPoison;
	
	public Snake() {
		super("파충류");
	}
	public Snake(boolean isPoison) {
		super("파충류");
		this.isPoison = isPoison;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / 독 유무 : "+isPoison;
	}
	
	@Override
	public void move() {
		System.out.println("뱀 : S자로 슬금슬금 기어다님");
	}

	@Override
	public void eat() {
		System.out.println("뱀 : 통으로 삼킴");
	}

	@Override
	public void sleep() {
		System.out.println("뱀 : 똬리틀고 잠");
	}

}
