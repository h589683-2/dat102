package parantessjekk;

public class Parantes implements Parentessjekker {

	//done
	@Override
	public boolean erVenstreparentes(char p) {
		Character C = p;
		boolean b = false;
	
		switch(C){
			case '(':
				b = true;
				break;
			case '{':
				b = true;
				break;
			case '[':
				b = true;
				break;
			default:
				b = false;
				break;
		}			
		return b;
	}

	
	@Override
	public boolean erHogreparentes(char p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erParentes(char p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
