package hobbyProsjekt;

	public class Hobby {
		private String hobbyNavn;

		public Hobby(String hobby){
				hobbyNavn = hobby;
		}
	
		private void setHobbyNavn(String hobbynavn) {
			this.hobbyNavn = hobbyNavn;
		}
		private String getHobbyNavn() {
			return hobbyNavn;
		}

		public String toString(){
			String s = "<" + getHobbyNavn() + ">";
			return s;
		}

		public boolean equals(Object hobby2){ //FIKS
			Hobby hobbyDenAndre = (Hobby)hobby2;
			return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
		}
}  