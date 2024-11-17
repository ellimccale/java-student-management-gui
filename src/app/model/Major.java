package app.model;

/**
 * Represents various academic majors, each with a unique code and a
 * display-friendly name.
 * 
 * @author Aidan Reed
 * @author Elli Steck
 */
public enum Major {

	// A
    ACCN("Accounting"),
    ANTH("Anthropology"),
    ARCT("Architectural Technology"),
    AUTO("Automotive Technician"),
    AVIA("Aviation Technology"),
    
    // B
    BIOL("Biology"),
    BIOT("Biotechnology"),
    BUSM("Business Management"),
    
    // C
    CNAS("Certified Nursing Assistant"),
    CHEM("Chemistry"),
    COMM("Communication"),
    CSIS("Computer Science and Information Systems"),
    CRIM("Criminal Justice"),
    CULA("Culinary Arts"),
    
    // D
    DENT("Dental Hygiene"),
    
    // E
    ECON("Economics"),
    EDUC("Education"),
    ENGR("Engineering"),
    ENGL("English"),
    ENVR("Environmental Geology"),
    
    // F
    FAMH("Family and Human Studies"),
    FASH("Fashion Institute"),
    FILM("Film Production Technician"),
    
    // G
    GEOG("Geography"),
    GEOS("Geoscience"),
    
    // H
    HLTH("Health Sciences"),
    HIST("History"),
    HOSP("Hospitality Management"),
    HUMN("Humanities"),
    
    // I
    INDS("Interior Design"),
    INTS("International Studies"),
    
    // L
    LANG("Languages"),
    LEGL("Legal Studies"),
    
    // M
    MFGN("Manufacturing Engineering"),
    MARK("Marketing Management"),
    MATH("Mathematics"),
    MORT("Mortuary Science"),
    MUSC("Music"),
    
    // N
    NURS("Nursing"),
    
    // O
    OTAS("Occupational Therapy Assistant"),
    
    // P
    PERF("Performing Arts"),
    PHIL("Philosophy"),
    PTAS("Physical Therapist Assistant"),
    PHYS("Physics"),
    POLS("Political Science"),
    PSYC("Psychology"),
    
    // R
    RADT("Radiologic Technology"),
    RELS("Religious Studies"),
    
    // S
    SOCW("Social Work"),
    SOCI("Sociology"),
    
    // V
    VART("Visual Art & Design"),
    
    // W
    WELD("Welding Fabrication");

    private final String displayName;

    /**
     * Constructs a new {@code Major} enum constant with a display-friendly name.
     *
     * @param displayName the name of the major to be used for display purposes
     */
    Major(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display-friendly name of the major.
     *
     * @return the display name of the major
     */
    @Override
    public String toString() {
        return displayName;
    }

}
