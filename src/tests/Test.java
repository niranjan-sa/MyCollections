package tests;

public class Test {

	static class Foo {
		public int k;
	}
	
	public static void main(String[] args) {
		String a="abc";
		String b=new String("abc");
		StringBuffer sb=new StringBuffer("abc");
		b=sb.toString();
		
		//b="abc";
		//If the above statement is uncommented than the a==b returns false.
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		System.out.println(compare(2,9));
		
		Foo ak = new Foo();
		ak.k = 89;
		Foo bar=ak;
		changeMe(ak);
		System.out.println(ak.k);
		System.out.println(bar.k);
		
		Integer k=new Integer(12);
		System.out.println(""+(k instanceof Comparable));
	}
	
	static void changeMe(Foo boo) {
		System.out.println(boo);
		boo.k=890;
		
	}
	public static<E> boolean compare(E d1, E d2) {
		return d1==d2;
	}

}
