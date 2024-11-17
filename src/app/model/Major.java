package app.model;

public enum Major {
    // A
    ACCOUNTING("Accounting"),
    ANTHROPOLOGY("Anthropology"),
    ARCHITECTURAL_TECHNOLOGY("Architectural Technology"),
    AUTOMOTIVE_TECHNICIAN("Automotive Technician"),
    AVIATION_TECHNOLOGY("Aviation Technology"),
    
    // B
    BIOLOGY("Biology"),
    BIOTECHNOLOGY("Biotechnology"),
    BUSINESS_MANAGEMENT("Business Management"),
    
    // C
    CERTIFIED_NURSING_ASSISTANT("Certified Nursing Assistant"),
    CHEMISTRY("Chemistry"),
    COMMUNICATION("Communication"),
    COMPUTER_SCIENCES_AND_INFORMATION_SYSTEMS("Computer Sciences and Information Systems"),
    CRIMINAL_JUSTICE("Criminal Justice"),
    CULINARY_ARTS("Culinary Arts"),
    
    // D
    DENTAL_HYGIENE("Dental Hygiene"),
    
    // E
    ECONOMICS("Economics"),
    EDUCATION("Education"),
    ENGINEERING("Engineering"),
    ENGLISH("English"),
    ENVIRONMENTAL_GEOLOGY("Environmental Geology"),
    
    // F
    FAMILY_AND_HUMAN_STUDIES("Family and Human Studies"),
    FASHION_INSTITUTE("Fashion Institute"),
    FILM_PRODUCTION_TECHNICIAN("Film Production Technician"),
    
    // G
    GEOGRAPHY("Geography"),
    GEOSCIENCE("Geoscience"),
    
    // H
    HEALTH_SCIENCES("Health Sciences"),
    HISTORY("History"),
    HOSPITALITY_MANAGEMENT("Hospitality Management"),
    HUMANITIES("Humanities"),
    
    // I
    INTERIOR_DESIGN("Interior Design"),
    INTERNATIONAL_STUDIES("International Studies"),
    
    // L
    LANGUAGES("Languages"),
    LEGAL_STUDIES("Legal Studies"),
    
    // M
    MANUFACTURING_ENGINEERING("Manufacturing Engineering"),
    MARKETING_MANAGEMENT("Marketing Management"),
    MATHEMATICS("Mathematics"),
    MORTUARY_SCIENCE("Mortuary Science"),
    MUSIC("Music"),
    
    // N
    NURSING("Nursing"),
    
    // O
    OCCUPATIONAL_THERAPY_ASSISTANT("Occupational Therapy Assistant"),
    
    // P
    PERFORMING_ARTS("Performing Arts"),
    PHILOSOPHY("Philosophy"),
    PHYSICAL_THERAPIST_ASSISTANT("Physical Therapist Assistant"),
    PHYSICS("Physics"),
    POLITICAL_SCIENCE("Political Science"),
    PSYCHOLOGY("Psychology"),
    
    // R
    RADIOLOGIC_TECHNOLOGY("Radiologic Technology"),
    RELIGIOUS_STUDIES("Religious Studies"),
    
    // S
    SOCIAL_WORK("Social Work"),
    SOCIOLOGY("Sociology"),
    
    // V
    VISUAL_ART_AND_DESIGN("Visual Art & Design"),
    
    // W
    WELDING_FABRICATION("Welding Fabrication");

    private final String displayName;

    Major(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
