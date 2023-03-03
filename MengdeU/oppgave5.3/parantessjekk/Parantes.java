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

	//Done
	@Override
	public boolean erHogreparentes(char p) {
		Character C = p;
		boolean b = false;
	
		switch(C){
			case ')':
				b = true;
				break;
			case '}':
				b = true;
				break;
			case ']':
				b = true;
				break;
			default:
				b = false;
				break;
		}			
		return b;
	}

	//Done
	@Override
	public boolean erParentes(char p) {
		Character C = p;
		boolean b = false;
	
		switch(C){
			case ')':
				b = true;
				break;
			case '}':
				b = true;
				break;
			case ']':
				b = true;
				break;
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

	//Done
	@Override
	public boolean erPar(char venstre, char hogre) {
		Character V = venstre;
		Character H = hogre;
		Character Match = '0';
		
		switch(V) {
		case '(':
			Match = ')';
			break;
		case '{':
			Match = '}';
			break;
		case '[':
			Match = '}';
			break;
		default:
			break;
		}
		
		if(H.equals(Match)) {
			return true;
		}
		
		return false;
		
		
		
	}

	@Override
	public boolean erBalansert(String s) {
		
		return false;
	}
}
