package buildingcompany.enums;

public enum CitiesPlanned {
        ATLANTA("Atlanta"),
        MARIETTA("Marietta"),
        SMYRNA("Smyrna"),
        ALPHARETTA("Alpharetta");
        private String cities;
        CitiesPlanned(String cities) {

            this.cities = cities;
        }

        public String getCities() {
            return cities;
        }
    }

