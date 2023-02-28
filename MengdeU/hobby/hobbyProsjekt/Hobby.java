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

		public boolean equals(Object hobby2){
			// eventuelt fylle ut først med "standard" kode
			// som vi ofte har med overkjøring av
			// equals-metoden generert av Eclipse
			Hobby hobbyDenAndre = (Hobby)hobby2;
			return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
		}
}  