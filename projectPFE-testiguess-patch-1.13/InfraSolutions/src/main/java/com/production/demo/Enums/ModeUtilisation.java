package com.production.demo.Enums;

//ModeUtilisation
	public enum ModeUtilisation {
		ComptageBoucle("CB"), ClassificationPiezo("CP"), PesagePiezo("PP");

		private final String code;

		ModeUtilisation(String code) {

			this.code = code;
		}

		public static ModeUtilisation fromCode(String code) {
			if (code == "CB" || code == "cb") {
				return ComptageBoucle;
			}
			if (code == "CP" || code == "cp") {
				return ClassificationPiezo;
			}
			if (code == "PP" || code == "pp") {
				return PesagePiezo;
			}
			throw new UnsupportedOperationException("The code " + code + " is not supported!");
		}

		public String getCode() {
			return code;
		}
	}
